package utils;

import dataBase.MongoConstants;
import model.Company;
import model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static utils.Constants.*;

public class SessionUtils {

    public static String getUsername(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Object sessionAttribute = session != null ? session.getAttribute(USERID) : null;
        return sessionAttribute != null ? sessionAttribute.toString() : null;
    }

    public static void clearSession(HttpServletRequest request) {
        request.getSession().invalidate();
    }

    public static boolean isUserConnected(HttpServletRequest request) {
        String usernameFromSession = getUsername(request);
        boolean isConnected = !(usernameFromSession == null);

        return isConnected;
    }

    public static void saveUserToSession(HttpServletRequest request, User user) {
        HttpSession session = request.getSession(true); // true for creating the session if not exist

        if (session.getAttribute(USERID) == null) {
            session.setAttribute(USERID, user);
        }

    }

    public static void saveCompanyToSession(HttpServletRequest request, Company company){
        HttpSession session = request.getSession(true);
        if(session.getAttribute(COMPANYNAME) == null){
            session.setAttribute(COMPANYNAME, company);
        }
    }

    public static Company getCompanyFromSession(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();

        Company company = (Company) session.getAttribute(COMPANYNAME);
        if(company == null){
            throw new Exception(String.format("Company: %s dosn't exist in session"));
        }

        return company;
    }
}