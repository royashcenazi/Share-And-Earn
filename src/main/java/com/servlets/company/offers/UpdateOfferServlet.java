package com.servlets.company.offers;

import model.Company;
import model.Offer;
import utils.ServletUtils;
import utils.SessionUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/updateOffer")
public class UpdateOfferServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try {
            Company company = SessionUtils.getCompanyFromSession(req);
            Offer offer = company.getOfferById(Integer.parseInt(req.getParameter("offerId")));
            updateOfferFromRequest(req, offer);
            updateOfferInCompany(offer, company);
            ServletUtils.updateCompanyInDbAndSession(req, company);
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write(e.getMessage());// TODO: implement in client side
        }
        resp.sendRedirect("/company/landing/companyLandingPage.jsp");
    }

    private void updateOfferFromRequest(HttpServletRequest req,Offer offer) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if(req.getParameter("productName") != null)
                offer.setProductName(req.getParameter("productName"));
            if(req.getParameter("points") != null)
                offer.setPoints(Integer.parseInt(req.getParameter("points")));
            if(req.getParameter("maxPublishers") != null)
                offer.setMaxPublishers(Integer.parseInt(req.getParameter("maxPublishers")));
            if(req.getParameter("timeToDelete") != null)
                offer.setTimeToDelete(dateFormat.parse(req.getParameter("timeToDelete")));
            if(req.getParameter("timeToPublish") != null)
                offer.setTimeToPublish(new Date());
            if(req.getParameter("picUrl") != null)
                offer.setPictureURL(ServletUtils.buildImgTransformationUrl(req.getParameter("picUrl")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateOfferInCompany(Offer offer, Company company) {
        if (company.getOfferById(offer.getOfferId()) != null) {
            company.getOffers().remove(offer);
        }
        company.addOffer(offer);
    }
}
