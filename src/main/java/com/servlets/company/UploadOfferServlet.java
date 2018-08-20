package com.servlets.company;

import dataBase.MongoInteractor;
import javafx.util.converter.DateStringConverter;
import model.Company;
import model.Offer;
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
        company.addOffer(offer);
        MongoInteractor.getInstance().updateCompanyInDataBase(company);
    }

    private Offer getOfferFromRequest(HttpServletRequest req) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Offer offer = new Offer();
        offer.setProductName(req.getParameter("productName"));
        offer.setPictureURL(req.getParameter("pictureUrl"));
        offer.setPoints(Integer.parseInt(req.getParameter("points")));
        try {
            offer.setTimeToPublish(dateFormat.parse(req.getParameter("timeToPublish")));
            offer.setTimeToDelete(dateFormat.parse(req.getParameter("timeToDelete")));
        }catch (Exception e){
            e.printStackTrace();
        }
        offer.setProductName(req.getParameter("productName"));
        offer.setMaxPublishers(Integer.parseInt(req.getParameter("maxPublishers")));
        return offer;
    }
}
