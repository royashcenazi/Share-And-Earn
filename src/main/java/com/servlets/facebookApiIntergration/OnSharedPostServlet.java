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
import utils.numberGenerators.IRobustNumberGenerator;
import utils.numberGenerators.CodeGeneratorImplRobust;
import utils.ServletUtils;
import utils.SessionUtils;

//TODO:: add time logic to start and due date! think of a better way to create shares and earns

@WebServlet("/OnSharedPost")
public class OnSharedPostServlet extends HttpServlet {
    private boolean succeededToPost;
    JsonObject jsonObject = new JsonObject();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Facebook facebook = (Facebook) req.getSession().getAttribute("facebook");
        //TODO: get user_posts approvals
        //String postId = req.getParameter("postId");
        int offerId = Integer.parseInt(req.getParameter("offerId"));

        if (isPostStillPosted(facebook, "stam") == true) {
            try {
                User user = SessionUtils.getUserFromSession(req);
                Company company = MongoInteractor.getInstance().getCompanyByName(req.getParameter("companyName"));
                Offer offer = company.getOfferById(offerId);
                //this is synchronized so offer wont be published more times than configured
                synchronized (MongoInteractor.getInstance()) {
                    createShareAndEarn(company, user, offer, offerId, req);
                }
            } catch (Exception e) {
                e.printStackTrace();
                succeededToPost = false;
            }
            jsonObject.addProperty("isPosted", succeededToPost);
            resp.getOutputStream().print(jsonObject.toString());
        }
    }

    private void createShareAndEarn(Company company, User user, Offer offer, int offerId, HttpServletRequest req) throws Exception {
        if (offer.getCurrentPublisherNumber() < offer.getMaxPublishers()) {
            if(user.isOfferPublished(offerId) == false) {
                Earn earn = buildEarn(company, offer, offerId);
                Share share = buildShare(company, offer, user, "stam", earn.getCode());
                user.addEarn(earn);
                company.addShare(share);
                offer.decreaseNumPublishers(1);
                saveDetailsToDb(user, company, req);
                succeededToPost = true;
            }
            else{
                succeededToPost = false;
                jsonObject.addProperty("failureReason", "You have already published this offer");
                throw new Exception("User has already published this offer");
            }
        } else {
            succeededToPost = false;
            jsonObject.addProperty("failureReason", "This offer has reached the limit of its publishers");
            throw new Exception("This offer reached the limit of its publishers");
        }
    }

    //ready to use date doesnt have any importance since there is currently no post_id
    private Share buildShare(Company company, Offer offer, User user, String postId, int code) {
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
        earn.setOfferId(offerId);
        earn.setAmount(offer.getPoints());
        earn.setCompanyId(company.getName());
        earn.setDueDate(offer.getTimeToDelete());
        IRobustNumberGenerator codeGenerator = CodeGeneratorImplRobust.getInstance();
        earn.setCode(codeGenerator.generateNumber());
        earn.setPictureUrl(offer.getPictureURL());
        earn.setProductName(offer.getProductName());
        //earn.setReadyToUseDate(offer.getTimeToPublish());
        return earn;
    }


    public boolean isPostStillPosted(Facebook fb, String post_id) {
        boolean isExist = false;
        //not relevant as long as we dont have user_post approval
//        try {
//            fb.getPost(post_id);
//            isExist = true;
//        } catch (Exception e) {
//            isExist = false;
//            e.printStackTrace();
//        }

        //return isExist;
        return true;
    }


    private void saveDetailsToDb(User user, Company company, HttpServletRequest req) {
        ServletUtils.updateCompanyInDbAndSession(req, company);
        ServletUtils.updateUserToDbAndSession(req, user);
    }

}
