package com.servlets.company;

import model.Company;
import model.Offer;
import model.builders.OfferBuilder;
import utils.numberGenerators.IRobustNumberGenerator;
import utils.numberGenerators.IdGeneratorImplRobust;
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
            Offer offer = buildOffer(req);
            Company company = SessionUtils.getCompanyFromSession(req);
            insertOffer(offer, company);
            ServletUtils.updateCompanyInDbAndSession(req, company);
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write(e.getMessage());// TODO: implement in client side
        }
        resp.sendRedirect("/company/landing/companyLandingPage.jsp");
    }

    private Offer buildOffer(HttpServletRequest req) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        OfferBuilder offerBuilder = new OfferBuilder();
        IRobustNumberGenerator idGenerator = IdGeneratorImplRobust.getInstance();
        try {
            offerBuilder.setOfferId(idGenerator.generateNumber())
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

    private void insertOffer(Offer offer, Company company) {
        if (company.getOfferById(offer.getOfferId()) != null) {
            company.getOffers().remove(offer);
        }
        company.addOffer(offer);
    }

}
