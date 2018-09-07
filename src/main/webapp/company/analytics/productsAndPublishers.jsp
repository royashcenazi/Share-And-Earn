<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="com.google.gson.JsonObject" %>
<%@ page import="dataBase.MongoInteractor" %>
<%@ page import="model.Company" %>
<%@ page import="model.Offer" %>

<%
    Gson gsonObj = new Gson();
    Company company = SessionUtils.getCompanyFromSession(request);
    List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
    for (Offer offer : company.getOffers()) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("label", offer.getProductName());
        map.put("y", offer.getCurrentPublisherNumber());
        list.add(map);
    }
    String dataPoints = gsonObj.toJson(list);
%>


<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript">
        window.onload = function () {

            var chart = new CanvasJS.Chart("chartContainer", {
                animationEnabled: true,
                theme: "light2", // "light1", "dark1", "dark2"
                title: {
                    text: "World Arsenic Production 2016"
                },
                subtitles: [{
                    text: "In Metric Tons",
                    fontSize: 16
                }],
                axisY: {
                    scaleBreaks: {
                        type: "wavy",
                        autoCalculate: true
                    }
                },
                data: [{
                    type: "column",
                    indexLabel: "{y}",
                    dataPoints: <%=dataPoints%>
                }]
            });
            chart.render();

        }
    </script>
</head>
<body>
<%@ include file="/company/common/navbar.jsp" %>
<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript">
        window.onload = function () {

            var chart = new CanvasJS.Chart("chartContainer", {
                animationEnabled: true,
                exportEnabled: true,
                title: {
                    text: "Products And Current Publishers"
                },
                data: [{
//                    type: "column", //change type to bar, line, area, pie, etc
//                    indexLabel: "{y}", //Shows y value on all Data Points
                    indexLabelFontColor: "#5A5757",
                    indexLabelPlacement: "outside",
                    dataPoints: <%=dataPoints%>
                }]
            });
            chart.render();

        }
    </script>
</head>
<body>
<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>