<!DOCTYPE html>
<html>
<head>
    <%--<link rel="stylesheet" type="text/css" href="./newOffer.css">--%>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <title>Add new offer</title>
</head>
<body>
<%--<%@ include file="navbar.jsp" %>--%>

<div class="container">
    <div id="addNewOfferDiv" class="form-group">
        <form action="/uploadOffer">
            <div><label for="productName">Product Name:</label>
                <input id="productName" class="form-control" name="productName" type="text" required
                       placeholder="Enter product name here, Maximum 15 charcters" maxlength="15"></div>

            <div><label for="offerId">Product ID:</label>
                <input class="form-control" id="offerId" name="offerId" type="number" required min="1"
                       placeholder="Enter product ID"></div>

            <div><label for="pictureUrl">Product Image:</label>
                <input class="form-control" id="pictureUrl" name="pictureUrl" type="file" required></div>

            <div><label for="points">Product value:</label>
                <input class="form-control" id="points" name="points" type="range" required
                       min="1" max="1000" onchange=""></div>  <!--  onchange show the value any time (JS) -->

            <div><label for="maxPublish">Maximum publishers:</label>
                <input class="form-control" id="maxPublish" name="maxPublish" type="range" required
                       min="1" max="1500" onchange=""></div>  <!--  onchange show the value any time (JS) -->

            <div><label for="timeToPublish">Publish date:</label>
                <input class="form-control" id="timeToPublish" name="timeToPublish" type="date" required></div>

            <div><label for="timeToDelete">Delete date:</label>
                <input class="form-control" id="timeToDelete" name="timeToDelete" type="date" required></div>

            <div>
                <button type="submit"> Submit</button>
                <button type="reset">Reset</button>
            </div>
        </form>

    </div>

</div>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>