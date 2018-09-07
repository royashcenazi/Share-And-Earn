package utils;

public class servletUtils {

    public static String buildImgTransformationUrl(String url) {
        String[] splitedUrl = url.split("upload");
        String res = new StringBuilder()
                .append(splitedUrl[0])
                .append("upload/c_scale,h_200,q_auto,r_16,w_300")
                .append(splitedUrl[1])
                .toString();

        return res;
    }
}
