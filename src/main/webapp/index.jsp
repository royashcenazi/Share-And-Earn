<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
    <title>Sign in with Facebook example</title>
    <script src="./index.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>

<tag:notloggedin>
    <p>Login flow for Web Applications:</p>
    <a href="signin"><img src="./assets/login-with-facebook.png" alt="Sign in with Facebook"></a>
    <hr/>
    <p>Login from Devices:</p>
    <a href="gencode"><img src="./assets/login-with-facebook.png" alt="Sign in with Facebook"></a>
</tag:notloggedin>
<tag:loggedin>
    <h1>Welcome ${facebook.name} (${facebook.id})</h1>
    <a href="tokenInfo" target="_blank">Access Token Info</a>
    <hr/>

    <%--Elad--%>
    <div id="fb-root"></div>
    <button  data-href="http://img.mako.co.il/2009/04/20/33199.jpg" id="shareBtn" class="btn btn-success clearfix">Share</button>
    <%--Elad--%>

    <form action="./post" method="post">
        <textarea cols="80" rows="2" name="message"></textarea>
        <input type="submit" name="post" value="statuses"/>
    </form>
    <a href="./logout">logout</a>
</tag:loggedin>
</body>
</html>