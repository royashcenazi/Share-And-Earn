<%@ page import="utils.SessionUtils" %>

<% if (!SessionUtils.isUserConnected(request)) { %>
    <jsp:forward page="/common/jsp/redirectToHomePage.jsp"/>
<% } %>