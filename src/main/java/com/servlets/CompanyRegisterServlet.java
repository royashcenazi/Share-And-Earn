package com.servlets;

import DataBase.Company;
import DataBase.CompanyBuilder;
import DataBase.MongoInteractor;
import model.DetailsWithPassword;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static DataBase.MongoConstants.*;

public class CompanyRegisterServlet extends HttpServlet {

    //    Constants
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PASS = "password";
    private static final String LOGO_URL = "logourl";
    private static final String EMAIL = "email";
    private static final String PHONEADDRESS = "phoneAddress";
    private static final String ADDRESS = "address";


    private MongoInteractor db = MongoInteractor.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Company company = fetchCompanyDetails(req);
        db.saveCompanyToDataBase(company);
    }

    private Company fetchCompanyDetails(HttpServletRequest req) {
        DetailsWithPassword details = new DetailsWithPassword(req.getParameter(EMAIL),
                req.getParameter(PHONEADDRESS),
                req.getParameter(ADDRESS),
                req.getParameter(PASS));

        CompanyBuilder companyBuilder = new CompanyBuilder().setDetails(details)
                .setId(Integer.parseInt(req.getParameter(ID)))
                .setLogoUrl(req.getParameter(LOGO_URL))
                .setName(req.getParameter(NAME));

        Company company = companyBuilder.createCompany();

        return company;
    }
}
