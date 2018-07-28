package com.servlets;

import model.Company;
import DataBase.MongoInteractor;
import model.CompanyBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerCompany")
public class CompanyRegisterServlet extends HttpServlet {

    private static final String NAME = "companyName";
    private static final String PASS = "psw";
    private static final String LOGO_URL = "logoUrl";
    private static final String EMAIL = "email";
    private static final String PHONEADDRESS = "phone";
    private static final String ADDRESS = "address";

    private MongoInteractor db = MongoInteractor.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Company company = fetchCompanyDetails(req);
        db.saveCompanyToDataBase(company);
    }

    private Company fetchCompanyDetails(HttpServletRequest req) {
        CompanyBuilder companyBuilder = new CompanyBuilder()
                .setAddress(req.getParameter(ADDRESS))
                .setEmail(req.getParameter(EMAIL))
                .setLogoUrl(req.getParameter(LOGO_URL))
                .setName(req.getParameter(NAME))
                .setPassword(req.getParameter(PASS))
                .setPhoneNumber(req.getParameter(PHONEADDRESS));

        Company company = companyBuilder.createCompany();

        return company;
    }
}
