package com.servlets;

import DataBase.MongoInteractor;
import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.conf.ConfigurationBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {
    private static final long serialVersionUID = -7453606094644144082L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthAppId("223473395065781")
                .setOAuthAppSecret("639cb3b650b6f5ec7b334b46638b7846")
                .setOAuthPermissions("email,public_profile");
        FacebookFactory ff = new FacebookFactory(cb.build());
        Facebook facebook = ff.getInstance();
        request.getSession().setAttribute("facebook", facebook);
        StringBuffer callbackURL = request.getRequestURL();
        int index = callbackURL.lastIndexOf("/");
        callbackURL.replace(index, callbackURL.length(), "").append("/callback");
        response.sendRedirect(facebook.getOAuthAuthorizationURL(callbackURL.toString()));
    }
}
