package com.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataBase.MongoInteractor;
import com.google.gson.JsonObject;
import DataBase.Company;

import java.io.IOException;
import java.util.List;


@WebServlet("/getAllPictures")
public class getAllPicturesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Company> companyList = MongoInteractor.getInstance().getAllCompanies();
        JsonObject jsonObject = new JsonObject();
        for (Company company : companyList) {
            jsonObject.addProperty(company.getName(), company.getLogoUrl());
        }
        resp.getOutputStream().print(jsonObject.toString());
    }
}
