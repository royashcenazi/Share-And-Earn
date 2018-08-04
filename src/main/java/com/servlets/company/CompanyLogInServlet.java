package com.servlets.company;

import com.google.gson.JsonObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dataBase.MongoInteractor;
import model.Company;
import utils.Constants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.mongodb.client.model.Filters.eq;

@WebServlet("/loginCompany")
public class CompanyLogInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String companyName = req.getParameter(Constants.COMPANYNAME);
        String password = req.getParameter(Constants.PASSWORD);
        MongoDatabase db = MongoInteractor.getInstance().getDb();
        MongoCollection<Company> companiesCollection = db.getCollection("companies", Company.class);
        Company company = companiesCollection.find(eq("name", companyName)).first();
        boolean companyExist = (company != null);
        boolean correctPassword = false;
        boolean loginSuccess = false;

        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");

        if (companyExist) {
            correctPassword = (password.equals(company.getPassword()));
        }

        loginSuccess = companyExist && correctPassword;

        // Create Json Object
        JsonObject json = new JsonObject();

        // Put some value pairs into the JSON object .
        json.addProperty("companyExist", companyExist);
        json.addProperty("correctPassword", correctPassword);
        json.addProperty("loginSuccess", loginSuccess);
        if (loginSuccess) {
            json.addProperty("url", Constants.COMPANY_LOBY_URL);
        }

        /* Return to javascript a boolean if Login success or not and finally output the json string*/
        resp.getWriter().print(json.toString());

    }
}
