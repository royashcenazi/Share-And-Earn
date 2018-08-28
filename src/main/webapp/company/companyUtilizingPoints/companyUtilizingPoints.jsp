<%@ page import="dataBase.MongoInteractor" %>
<%@ page import="model.Company" %>

<!DOCTYPE html>
<html>
<head>
	<title>Utilizing Points</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="companyUtilizingPoints.css">
	<link href="https://fonts.googleapis.com/css?family=Ubuntu+Condensed" rel="stylesheet">
	<script
	  src="https://code.jquery.com/jquery-3.3.1.slim.js"
	  integrity="sha256-fNXJFIlca05BIO2Y5zh1xrShK3ME+/lYZ0j+ChxX2DA="
	  crossorigin="anonymous"></script>

</head>

<body>
	<%Company company = MongoInteractor.getInstance().getCompanyByName("Test Company");%>
	<%--<%@ include file="navbar.jsp" %>--%>

	<div>
		<img src="<%=company.getLogoUrl()%>" alt="Company Logo" class="company-logo center">
		<h1 class="center">Utilizing Points</h1>
		<hr>

		<div class="customer-details center">
			<div class="block">
				<label>Customer ID: </label>
				<input type="text" name="customer-id" id="customer-id">	
			</div>

			
			<div class="block">
				<label>Points to utilize: </label>
				<input type="text" name="points" id="points">
			</div>
			<br>

			<button type="button" class="btn btn-primary" id="btnSubmit">Submit</button>
		</div>
	</div>

	<script type="text/javascript" src="companyUtilizingPoints.js"></script>

</body>
</html>