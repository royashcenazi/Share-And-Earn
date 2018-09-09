package com.servlets.company.offers;

import dataBase.MongoInteractor;
import model.Company;
import model.Offer;
import utils.ServletUtils;
import utils.SessionUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteOffer")
public class DeleteOfferServlet  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            Company company = MongoInteractor.getInstance().getCompanyByName(req.getParameter("companyName"));
            Offer offer  = company.getOfferById(Integer.parseInt(req.getParameter("offerId")));
            company.getOffers().remove(offer);
            ServletUtils.updateCompanyInDbAndSession(req, company);
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write(e.getMessage());// TODO: implement in client side
        }
        resp.sendRedirect("/company/landing/companyLandingPage.jsp");
    }
}
