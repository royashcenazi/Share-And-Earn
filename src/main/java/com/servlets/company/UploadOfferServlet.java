package com.servlets.company;

import model.Company;
import model.Offer;
import model.builders.OfferBuilder;
import utils.SessionUtils;
import utils.ServletUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/uploadOffer")
public class UploadOfferServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try {
            Offer offer = getOfferFromRequest(req);
            Company company = SessionUtils.getCompanyFromSession(req);
            updateOffer(offer, company);
            ServletUtils.updateCompanyInDbAndSession(req, company);
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write(e.getMessage());// TODO: implement in client side
        }
        resp.sendRedirect("/company/landing/companyLandingPage.jsp");
    }

    private Offer getOfferFromRequest(HttpServletRequest req) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        OfferBuilder offerBuilder = new OfferBuilder();

        try {
            offerBuilder.setOfferId(Integer.parseInt(req.getParameter("offerId")))
                    .setProductName(req.getParameter("productName"))
                    .setPoints(Integer.parseInt(req.getParameter("points")))
                    .setMaxPublishers(Integer.parseInt(req.getParameter("maxPublishers")))
                    .setTimeToDelete(dateFormat.parse(req.getParameter("timeToDelete")))
                    .setTimeToPublish(new Date())
                    .setPictureURL(ServletUtils.buildImgTransformationUrl(req.getParameter("picUrl")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return offerBuilder.createOffer();
    }

    private void updateOffer(Offer offer, Company company) {
        if (company.getOfferById(offer.getOfferId()) != null) {
            company.getOffers().remove(offer);
        }
        company.addOffer(offer);
    }

}
