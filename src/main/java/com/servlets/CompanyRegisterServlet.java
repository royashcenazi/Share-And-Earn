package com.servlets;

import DataBase.Company;
import DataBase.MongoInteractor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.servlets.Constants.*;

//private int id;
//private String name;
//private List<Offer> offers;
//private List<AppUser> Users;
//private DetailsWithPassword details;
//private String logoUrl;

public class CompanyRegisterServlet extends HttpServlet {

    private MongoInteractor mongo = MongoInteractor.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        fetchCompaniesDetails(req);

        mongo.saveAppUserDetailsToDataBase();
    }

    private Company fetchCompaniesDetails(HttpServletRequest req) {
        String id = req.getParameter(Constants.ID);
        String name = req.getParameter(Constants.NAME);
        String logo_url = req.getParameter(Constants.LOGO_URL);
        String pass = req.getParameter(Constants.PASS);
        String email = req.getParameter(Constants.EMAIL);
        String phoneAddress = req.getParameter(Constants.PHONEADDRESS);
        String address = req.getParameter(Constants.PASS);
        Company company = new Company(id, name, pass, logo_url);

        return company;
    }
}
