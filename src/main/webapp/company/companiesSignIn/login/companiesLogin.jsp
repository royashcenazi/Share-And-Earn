<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="companiesLogin.css" media="screen" type="text/css">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
    <script type="text/javascript" src="/common/js/utils.js"></script>
</head>

<html lang="en-US">
<body>
<p>asd</p>
<div class="container">
    <div id="login">
        <form action="/loginCompany" method="post" id="loginForm">
            <fieldset class="clearfix">
                <div id="allContent">
                    <img src="../../../imgs/LOGO.png" alt="Shar&Earn Logo">
                    <p><span class="fas fa-user"></span><input type="text" placeholder="Company Name" name="COMPANYNAME"
                                                               required></p>
                    <p><span class="fas fa-lock"></span><input type="password" placeholder="Password" name="PASSWORD"
                                                               required></p>
                    <form><p><input type="submit" value="Sign In"></p></form>
                </div>
            </fieldset>
        </form>

        <p>Not a member? <a href="../signUp/companiesSignUp.jsp">Sign up now</a><span class="fas fa-arrow-right"></span>
        </p>

    </div> <!-- end login -->
</div>
<script type="text/javascript" src="companiesLogin.js"></script>
</body>
</html>
