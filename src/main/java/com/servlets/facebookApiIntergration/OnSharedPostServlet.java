package com.servlets.facebookApiIntergration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import dataBase.MongoInteractor;
import facebook4j.Facebook;
import model.*;
import utils.SessionUtils;

//TODO:: add time logic to start and due date! think of a better way to create shares and earns

@WebServlet("/OnSharedPost")
public class OnSharedPostServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Facebook facebook = (Facebook)req.getSession().getAttribute("facebook");
        String postId = req.getParameter("postId");
        String companyName = req.getParameter("companyName");
        int offerId = Integer.parseInt(req.getParameter("offerId"));

        if(isPostStillPosted(facebook, postId) == true){
            try {
                User user = SessionUtils.getUserFromSession(req);
                Company company = MongoInteractor.getInstance().getCompanyByName(companyName);
                Earn earn = buildEarn(company, offerId);
                Share share = buildShare(company,user, offerId, postId);
                user.addEarn(earn);
                company.addShare(share);
                saveDetailsToDb(user, company);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    private void saveDetailsToDb(User user, Company company) {
        MongoInteractor.getInstance().updateCompanyInDataBase(company);
        MongoInteractor.getInstance().updateUserInDataBase(user);
    }

    private Share buildShare(Company company,User user, int offerId, String postId) {
        Offer offer = company.getOfferById(offerId);
        Share share = new Share();
        share.setAmount(offer.getPoints());
        share.setCompanyId(company.getName());
        share.setDueDate(offer.getTimeToDelete());
        share.setOffer(offer);
        share.setPublisher(user);
        share.setPostId(postId);
        //share.setReadyToUseDate(Date.now);
        return share;
    }

    private Earn buildEarn(Company company, int offerId) {
        Earn earn = new Earn();
        Offer offer = company.getOfferById(offerId);
        earn.setAmount(offer.getPoints());
        earn.setCompanyId(company.getName());
        earn.setDueDate(offer.getTimeToDelete());
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

        return isExist;
    }
}
