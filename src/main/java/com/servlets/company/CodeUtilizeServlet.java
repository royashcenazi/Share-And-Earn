package com.servlets.company;

import com.google.gson.JsonObject;
import dataBase.MongoInteractor;
import model.Company;
import model.Earn;
import model.Share;
import model.User;
import utils.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UtilizePoints")
public class CodeUtilizeServlet extends HttpServlet {
    private MongoInteractor db = MongoInteractor.getInstance();
    private boolean transactionSuccess = true;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonObject jsonObject = new JsonObject();
        try {
            Company company = SessionUtils.getCompanyFromSession(req);
            int code = Integer.parseInt(req.getParameter("code"));
            Share share = getShareFromCode(company, code);
            User user = share.getPublisher();
            Earn earn = getEarnFromCode(user, code);
            deleteShareAndEarn(company, share,user, earn);
            jsonObject.addProperty("points", share.getAmount());
        }catch (Exception e){
            e.printStackTrace();
            transactionSuccess = false;
        }
        jsonObject.addProperty("success", transactionSuccess);
        resp.getOutputStream().print(jsonObject.toString());
    }

    private void deleteShareAndEarn(Company company, Share share,User user, Earn earn) {
        company.getShares().remove(share);
        user.getEarnList().remove(earn);
    }

    private Earn getEarnFromCode(User publisher, int code) {
        Earn res = null;
        for (Earn earn : publisher.getEarnList()) {
            if(earn.getCode() == code){
                res = earn;
                break;
            }
        }
        return res;
    }

    private Share getShareFromCode(final Company company, int code) {
        Share res = null;
        for (Share share : company.getShares()) {
            if (share.getCode() == code) {
                res = share;
                break;
            }
        }
        return res;
    }
}