package com.servlets.facebookApiIntergration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.google.gson.JsonObject;
import dataBase.MongoInteractor;
import facebook4j.Facebook;
import model.*;
import utils.ICodeGenerator;
import utils.SessionUtils;

//TODO:: add time logic to start and due date! think of a better way to create shares and earns

@WebServlet("/OnSharedPost")
public class OnSharedPostServlet extends HttpServlet {

    private boolean succeededToPost;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Facebook facebook = (Facebook) req.getSession().getAttribute("facebook");
        //TODO:: get user_posts approvals
        //String postId = req.getParameter("postId");
            String companyName = req.getParameter("companyName");
        int offerId = Integer.parseInt(req.getParameter("offerId"));

        if (isPostStillPosted(facebook, "stam") == true) {
            try {
                User user = SessionUtils.getUserFromSession(req);
                Company company = MongoInteractor.getInstance().getCompanyByName(companyName);
                Offer offer = company.getOfferById(offerId);
                //this is synchronized so offer wont be published more times than configured
                synchronized (MongoInteractor.getInstance()) {
                    createShareAndEarn(company, user, offer, offerId);
                }
            } catch (Exception e) {
                e.printStackTrace();
                succeededToPost = false;
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("isPosted",succeededToPost);
            resp.getOutputStream().print(jsonObject.toString());
        }
    }

    private void createShareAndEarn(Company company, User user, Offer offer, int offerId) {
        if (offer.getCurrentPublisherNumber() < offer.getMaxPublishers()) {
            Earn earn = buildEarn(company, offer, offerId);
            Share share = buildShare(company, offer, user, offerId, "stam", earn.getCode());
            user.addEarn(earn);
            company.addShare(share);
            saveDetailsToDb(user, company);
            succeededToPost = true;
        } else {
            //TODO::notify user that offer is irelevent
            succeededToPost = false;
        }
    }


    private void saveDetailsToDb(User user, Company company) {
        MongoInteractor.getInstance().updateCompanyInDataBase(company);
        MongoInteractor.getInstance().updateUserInDataBase(user);
    }

    //reaady to use date doesnt have any importance since there is currently no post_id
    private Share buildShare(Company company, Offer offer, User user, int offerId, String postId, int code) {
        Share share = new Share();
        share.setAmount(offer.getPoints());
        share.setCompanyId(company.getName());
        share.setDueDate(offer.getTimeToDelete());
        share.setOffer(offer);
        share.setPublisher(user);
        share.setPostId(postId);
        share.setCode(code);
        //share.setReadyToUseDate(Date.now);
        return share;
    }

    private Earn buildEarn(Company company, Offer offer, int offerId) {
        Earn earn = new Earn();
        earn.setAmount(offer.getPoints());
        earn.setCompanyId(company.getName());
        earn.setDueDate(offer.getTimeToDelete());
        ICodeGenerator codeGenerator = utils.ICodeGeneratorImpl.getInstance();
        earn.setCode(codeGenerator.generateCode());
        //earn.setReadyToUseDate(offer.getTimeToPublish());
        return earn;
    }


    public boolean isPostStillPosted(Facebook fb, String post_id) {
        boolean isExist = false;

        try {
            fb.getPost(post_id);
            isExist = true;
        } catch (Exception e) {
            isExist = false;
            e.printStackTrace();
        }

        //return isExist;
        return true;
    }
}
