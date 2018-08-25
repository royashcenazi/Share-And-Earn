<%@ page import="utils.SessionUtils" %>
<%@ page import="model.Company" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="./newOffer.css">
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="./companyLandingPage.css">
    <link rel="stylesheet" href="./newOffer.css">
    <title>Add new offer</title>
</head>
<body>
<%@ include file="navbar.jsp" %>

<div class="container">
    <div id="addNewOfferDiv" class="form-group">
        <form id="uploadOfferForm" action="/uploadOffer" onsubmit="return validateFileUploaded();">

            <label for="offerId">Product id:</label>
            <input id="offerId" class="form-control" name="offerId" type="number"
                   placeholder="Enter product id here" required>

            <label for="productName">Product Name:</label>
            <input id="productName" class="form-control" name="productName" type="text" required
                   placeholder="Enter product name here, Maximum 15 charcters" maxlength="15">

            <label for="points">Product value:</label>
            <input class="form-control" id="points" name="points" type="number" required min="1" max="1000"
                   placeholder="The amount of points each publisher will get">

            <label for="maxPublishers">Maximum amount of publishers:</label>
            <input class="form-control" id="maxPublishers" name="maxPublishers" type="text" required
                   min="1" max="1500" placeholder="The maximum amount of users that can share this item">

            <label for="timeToDelete">Delete date:</label>
            <input class="form-control" id="timeToDelete" name="timeToDelete" type="date" required>

            <button id="uploadFileSpinner" class="btn btn-sm btn-warning" style="display: none;">
                <span class="glyphicon glyphicon-refresh glyphicon-refresh-animate"></span> Uploading...
            </button>
            <br><br>
            <label for="file-upload">Product Image:</label>
            <input class="form-control-file" type="file" name="file-upload" id="file-upload" required>

            <div id="buttonsDiv">
                <button class="btn btn-success pull-right" type="submit">Submit</button>
                <button id="resetBtn" class="btn btn-info pull-right" type="reset">Reset</button>
            </div>

            <input id="logoUrlInput" type="hidden" name="picUrl">

        </form>

    </div>

</div>


<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="https://code.jquery.com/jquery-2.1.4.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="./newOffer.js"></script>
<%--for file upload--%>
</body>
</html>