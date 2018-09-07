package utils;

import dataBase.MongoInteractor;
import facebook4j.internal.http.HttpRequest;
import model.Company;
import model.User;

import javax.servlet.http.HttpServletRequest;

public class ServletUtils {

    public static String buildImgTransformationUrl(String url) {
        String[] splitedUrl = url.split("upload");
        String res = new StringBuilder()
                .append(splitedUrl[0])
                .append("upload/c_scale,h_200,q_auto,r_16,w_300")
                .append(splitedUrl[1])
                .toString();

        return res;
    }
    public static void updateCompanyInDbAndSession(HttpServletRequest req, Company company){
        try{
            MongoInteractor.getInstance().updateCompanyInDataBase(company);
            SessionUtils.saveCompanyToSession(req, company);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void updateUserToDbAndSession(HttpServletRequest req, User user){
        try{
            MongoInteractor.getInstance().updateUserInDataBase(user);
            SessionUtils.saveUserToSession(req, user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
