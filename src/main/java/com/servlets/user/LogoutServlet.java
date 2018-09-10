package com.servlets.user;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import utils.Constants;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utils.Constants.HOMEPAGE;

public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 5357658337449255998L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logoutFromFB(request, response);
        request.getSession().invalidate();
        response.sendRedirect(HOMEPAGE);
    }

    private void logoutFromFB(HttpServletRequest req, HttpServletResponse resp) {
        Facebook fb = (Facebook) req.getSession().getAttribute("facebook");

        if (fb != null) {
            try {
                fb.deleteAllPermissions();
            } catch (FacebookException e) {
                e.printStackTrace();
            }
        }
    }
}
