package com.servlets;

import Utils.SessionUtils;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/companiesPage/userInfo")
public class UserInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = SessionUtils.getUsername(req);
        JsonObject json = new JsonObject();
        PrintWriter writer = resp.getWriter();

        json.addProperty("name", name);
        writer.write(json.toString());
    }

}
