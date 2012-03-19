<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>TDD - Equity Order Management Manager</title>
</head>
<style>
body
{
font-size:62.5%;
font-family:Palatino, serif;
background-color:#FFFFF0;
color:#000080;
margin:10px;
font-weight: 500;
} 
/* #equities,#orders,#blotters{
font-size:100%;
font-family:verdana,arial,'sans serif';
background-color:#FFFFF0;
color:#000080;
margin:10px;
} */
</style>
  <link href="<%= request.getContextPath()%>/css/jquery-ui-1.8.18.custom.css" rel="stylesheet" type="text/css"/>
  <script src="<%= request.getContextPath()%>/js/jquery-1.7.1.min.js"></script> 
  <script src="<%= request.getContextPath()%>/js/jquery-ui-1.8.18.custom.min.js"></script> 
  <script src="<%= request.getContextPath()%>/js/jquery.ui.tabs.js"></script>
  <script src="<%= request.getContextPath()%>/js/equityOrder.js"></script> 
<body>
 <form:form id="user" name="user" modelAttribute="user" commandName="user" >
<table align="right" ,style="width:10%;">
<%-- <tr><td><b><form:input readonly="true" id="name" path="name" cssStyle="background-color:#FFFFF0;color:#000080;"/></b></td></tr> --%>
<tr><td><b><a href="/tdd/login.jsp">Logout</a></b></td></tr>
</table>
</form:form> 
<div id="equities" style="width:80%;top:0px;">
	<ul>
		<li><a id="orders-tab" href="#orders">Order</a></li>
		<li><a id="blotters-tab" href="#blotters">Blotter</a></li>
	</ul>
	<div id="orders"></div>
	 <div id="blotters"></div>
		
</div>
</body>
</html>