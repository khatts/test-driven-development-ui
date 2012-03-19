<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>

</head>
 <link href="<%= request.getContextPath()%>/css/jquery-ui-1.8.18.custom.css" rel="stylesheet" type="text/css"/>
  <script src="<%= request.getContextPath()%>/js/jquery-1.7.1.min.js"></script> 
  <script src="<%= request.getContextPath()%>/js/jquery-ui-1.8.18.custom.min.js"></script> 
  <script src="<%= request.getContextPath()%>/js/createOrder.js"></script> 
  
<body>

<form:form method="post" id="validationform" action="validationform.html"

commandName="validationForm">
<div id="orderTable">
<table>

<tr>

<td>User Name:<font color="red"><form:errors

path="userName" /></font></td>

</tr>

<tr>

<td><form:input path="userName" /></td>

</tr>

<tr>

<td>Age:<font color="red"><form:errors path="age" /></font></td>

</tr>

<tr>

<td><form:input path="age" /></td>

</tr>

<tr>

<td>Password:<font color="red"><form:errors

path="password" /></font></td>

</tr>

<tr>

<td><form:password path="password" /></td>

</tr>

<tr>

<td><input type="button" id="check" value="Submit" /></td>

</tr>

</table>
</div>
</form:form>

</body>
<script>
$(document).ready(function() {
	alert("On loading validation form");
});
  $('#check').click(function(){
	 alert("On clicked");
	 $.ajax({
			type: "POST",
	        url: "/test-driven-development-ui/forms/validate.htm",
	        data: $('#validationform').serializeArray(),
	        success: function(data) {
				alert("Inside success"+data);
				$("#orderTable").html(data);
	        },
	        error:function(data){
	        	alert("Inside error"+data);
	        },
	        statusCode:{
	        	100:function(data){
	        		alert("Got 409 code "+data);
	        	}
	        }
		});
  });
  </script>


</html>