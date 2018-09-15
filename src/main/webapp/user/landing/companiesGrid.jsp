<%@ page import="dataBase.MongoInteractor" %>
<%@ page import="model.Company" %>
<%@ page import="java.util.List" %>

<% List<Company> companyList = MongoInteractor.getInstance().getAllCompanies(); %>
<% int i = 0;
    if (companyList != null) {
        for (Company company : companyList) {
            String companyName = company.getName();

            if (i == 0) { %>
<div class="row">
    <% } %>

    <div class="col-sm-4">
        <label>Company name:</label> <%= companyName %> <br>
        <div class="thumbnail" style="border: none;">
            <a href="<%="./companiesProducts/companyProducts.jsp?companyName=" + companyName%>">
                <img src=<%= company.getLogoUrl()%> data-toggle="modal" style="cursor: pointer"/>
            </a>
        </div>
    </div>

    <% i = (i + 1) % 3;
        if (i == 0) { %>
</div>
<% }
}
} %>