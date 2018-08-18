package com.servlets.company;

import dataBase.MongoInteractor;
import model.Company;
import model.Offer;
import utils.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/uploadOffer")
public class UploadOfferServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Offer offer = new Offer();
        offer.setPictureURL(req.getParameter("productUrl"));
        offer.setAmount(Integer.parseInt(req.getParameter("maxAmount")));
        //add setters for product
        //produce offer builder
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
}
