package com.servlets.company;

import com.google.gson.JsonObject;
import dataBase.MongoInteractor;
import model.Company;
import utils.Constants;
import utils.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.mongodb.client.model.Filters.eq;

@WebServlet("/loginCompany")
public class CompanyLogInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String companyName = req.getParameter(Constants.COMPANYNAME);
        String password = req.getParameter(Constants.PASSWORD);
        Company company = MongoInteractor.getInstance().getCompanyByName(companyName);
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
            SessionUtils.saveCompanyToSession(req,company);
            getServletContext().getRequestDispatcher(Constants.COMPANY_LANDINGPAGE_JSP_PATH).forward(req, resp);
        }

        /* Return to javascript a boolean if Login success or not and finally output the json string*/
        resp.getWriter().print(json.toString());
    }
}
