package com.servlets.facebookApiIntergration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/.well-known/pki-validation/59E348F289C531A3A334ADBF1DA3994D.txt")
public class Cert extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("4D5ABD1B7F292F3AC5652AB91C97B157C9B6D3BEB869304EFB7187F4B9BC558A\n" +
                "comodoca.com");
    }
}
