package com.elad;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.Post;
import facebook4j.ResponseList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class OnSharedPostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Facebook facebook = (Facebook) req.getSession().getAttribute("facebook");
        String post_id = getFullPostId(req, facebook);

        System.out.println("Post exist: " + isPostStillPosted(post_id, facebook));
        try {
            facebook.deletePost(post_id);
            System.out.println("Post exist: " + isPostStillPosted(post_id, facebook));
        } catch (FacebookException e) {
            e.printStackTrace();
        }
        try {
            Post post = facebook.getPost(post_id);
            System.out.println(post.getCreatedTime().toString());
        } catch (FacebookException e) {
            e.printStackTrace();
        }
        resp.getWriter().write("ok");
    }

    private String getFullPostId(HttpServletRequest req, Facebook facebook) {
        String post_id = req.getParameter("post_id");
        String query_id = post_id;
        try {
            query_id = facebook.getId() + "_" + post_id;
        } catch (FacebookException e) {
            e.printStackTrace();
        }

        return query_id;
    }

    public void deleteAllposts(Facebook facebook) {
        try {
            ResponseList<Post> posts = facebook.getPosts();
            for (Post post : posts) {
                facebook.deletePost(post.getId());
            }
        } catch (FacebookException e) {
            e.printStackTrace();
        }
    }

    public static boolean isPostStillPosted(String post_id, Facebook fb) {
        boolean isExist = true;

        try {
            fb.getPost(post_id);
        } catch (FacebookException e) {
            isExist = false;
        }

        return isExist;
    }

}
