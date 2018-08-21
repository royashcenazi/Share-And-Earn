package com.servlets.company;

import dataBase.MongoInteractor;
import model.Company;
import model.Offer;
import model.builders.OfferBuilder;
import utils.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

@WebServlet("/uploadOffer")
public class UploadOfferServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Offer offer = getOfferFromRequest(req);

        Company company = null;
        try {
            company = SessionUtils.getCompanyFromSession(req);
        } catch (Exception e) {
            e.printStackTrace();
            //change
            resp.sendRedirect("Please Allow Cookies");
        }
        if(company.getOfferById(offer.getOfferId()) != null) {
            company.getOffers().remove(offer);
        }
        company.addOffer(offer);
        MongoInteractor.getInstance().updateCompanyInDataBase(company);
    }

    private Offer getOfferFromRequest(HttpServletRequest req) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        OfferBuilder offerBuilder = new OfferBuilder();
        offerBuilder.setOfferId(Integer.parseInt(req.getParameter("offerId")))
                .setProductName(req.getParameter("productName"))
                .setPoints(Integer.parseInt(req.getParameter("points")));
        try {
            offerBuilder.setTimeToPublish(dateFormat.parse(req.getParameter("timeToPublish")))
             .setTimeToDelete(dateFormat.parse(req.getParameter("timeToDelete")));
        }catch (Exception e){
            e.printStackTrace();
        }
        offerBuilder.setProductName(req.getParameter("productName"))
            .setMaxPublishers(Integer.parseInt(req.getParameter("maxPublishers")));
        return offerBuilder.createOffer();
    }
}
