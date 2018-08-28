<%@ page import="dataBase.MongoInteractor" %>
<%@ page import="model.Company" %>
<%@ page import="java.util.List" %>

<% List<Company> companyList = MongoInteractor.getInstance().getAllCompanies(); %>
<% if (companyList != null) { %>
<% for (Company company : companyList) {
    String companyName = company.getName();%>

<div class="col-sm-4">
    <div class="thumbnail">
        <label>Company name:</label> <%= companyName %> <br>
        <a href="<%="./companiesProducts/companyProducts.jsp?companyName=" + companyName%>">
            <img src=<%= company.getLogoUrl()%> data-toggle="modal"/>
        </a>
    </div>
</div>
<% }
} %>