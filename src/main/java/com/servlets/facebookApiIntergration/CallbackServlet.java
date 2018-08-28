package com.servlets.facebookApiIntergration;

import model.User;
import dataBase.MongoInteractor;
import utils.SessionUtils;
import facebook4j.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CallbackServlet extends HttpServlet {
    private static final long serialVersionUID = 6305643034487441839L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
        String oauthCode = request.getParameter("code");

        try {
            facebook.getOAuthAccessToken(oauthCode);
        } catch (FacebookException e) {
            throw new ServletException(e);
        }

        try {
            String name = facebook.getName();
            String id = facebook.getId();
            User user = new User();
            user.setFaceBookId(id);
            user.setName(name);
            MongoInteractor.getInstance().saveAppUserDetailsToDataBase(user.getName(), user.getFaceBookId());
            SessionUtils.saveUserToSession(request, user);
        } catch (FacebookException e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "user/landing/userLandingPage.jsp");
    }
}
