package facebook4j.examples.signin;

import DataBase.MongoInteractor;
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
        String userName = MongoInteractor.saveDetailsToDataBase(facebook);
        response.getWriter().write("hello" + userName);
        response.sendRedirect(request.getContextPath() + "/companysPage.html");
    }
}
