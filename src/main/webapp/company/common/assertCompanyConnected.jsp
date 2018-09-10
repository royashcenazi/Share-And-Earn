<%@ page import="utils.SessionUtils" %>

<% if (!SessionUtils.isCompanyConnected(request)) { %>
    <jsp:forward page="/common/jsp/redirectToHomePage.jsp"/>
<% } %>