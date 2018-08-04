package utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static utils.Constants.*;

public class SessionUtils {

    public static String getUsername(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Object sessionAttribute = session != null ? session.getAttribute(USERNAME) : null;
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

    public static void saveUserToSession(HttpServletRequest request, String name, String id) {
        HttpSession session = request.getSession(true); // true for creating the session if not exist

        if (session.getAttribute(USERID) == null) {
            session.setAttribute(USERID, id);
            session.setAttribute(USERNAME, name);
        }

    }
}