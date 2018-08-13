<%@ page import="dataBase.MongoInteractor" %>
<%@ page import="model.Company" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: rashcena
  Date: 8/13/18
  Time: 1:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Company> companyList = MongoInteractor.getInstance().getAllCompanies();
    for (Company company : companyList) {
%>
<p>
    url: <%=company.getLogoUrl()%>
</p>
<%}%>
</body>
</html>
