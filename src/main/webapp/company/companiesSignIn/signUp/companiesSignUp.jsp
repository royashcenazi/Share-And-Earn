<%--
  Created by IntelliJ IDEA.
  User: eladg
  Date: 24/08/18
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="companiesSignUp.css">
    <title>Signup</title>
</head>
<body>
<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <form id="signUpForm" action="/registerCompany" method="post">
            <ul id="progressbar">
                <li class="active">Details</li>
                <li>Logo</li>
                <li>Submit</li>
            </ul>
            <fieldset>
                <h2 class="fs-title">Personal Details</h2>
                <h3 class="fs-subtitle">Tell us something more about you</h3>
                <input type="text" placeholder="Enter Company name" name="companyName" id="companyName" required>
                <input type="number" placeholder="Enter Phone" name="phone" id="phone" required>
                <input type="text" placeholder="Enter Address" name="address" id="address" required>
                <input type="email" placeholder="Enter Email" name="email" id="email" required>
                <input type="password" placeholder="Enter Password" name="psw" id="psw" required>
                <input type="password" placeholder="Repeat Password" name="psw-repeat" id="psw-repeat"
                       oninput="validateRepeatPassword(this)" required>
                <textarea id="about" name="about" cols="40" rows="5" placeholder="About ..." required></textarea>
                <input type="button" name="next" class="next action-button" value="Next"/>
            </fieldset>
            <fieldset>
                <h2 class="fs-title">COMPANY LOGO</h2>
                <h3 class="fs-subtitle">Your company logo</h3>
                <button id="uploadFileSpinner" class="btn btn-sm btn-warning" style="display: none;">
                    <span class="glyphicon glyphicon-refresh glyphicon-refresh-animate"></span> Uploading...
                </button>
                <br>
                <br>
                <input class="form-control-file" type="file" name="file-upload" id="file-upload">
                <input type="button" name="previous" class="previous action-button-previous" value="Previous"/>
                <input type="button" name="next" class="next action-button" value="Next"/>
            </fieldset>
            <fieldset>
                <input type="submit" name="submit" class="submit action-button" value="Submit"/>
            </fieldset>
        </form>
    </div>
</div>

<script src="https://code.jquery.com/jquery-2.1.4.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="https://code.jquery.com/jquery-2.1.4.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
<script src="./companiesSignUp.js"></script>
<script src="/common/js/utils.js"></script>
</body>
</html>
