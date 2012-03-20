<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>TDD - Equity Order Management Manager</title>
</head>
<style>
/* body
{
font-size:7pt !important;
font-family:Palatino, serif;
background-color:#FFFFF0;
color:#000080;
margin:10px;
}  */
.inputFont{
font-family:Times, serif;
font-size:normal;
}
tr{
height:20px;
}
td {
	padding: 0 0.9em;
	font-size:10pt !important;
}
.errors{
font-size:12pt !important;
font-family:Palatino, serif;
background-color:#FFFFF0;
color:red;
}
.dropdown{
height:25px;
width:200;
font-family:Times, serif;
font-size:normal;
}
table{
max-width:100px;
}
#qty,#stopPrice,#limitPrice{
width:75px;
}
#Save{
font-family:Times, serif;
font-size:12pt !important;
background-color:#FFFFF0;
color:#000080;
font-weight: bold

}

</style>
   <link href="<%= request.getContextPath()%>/css/jquery-ui-1.8.18.custom.css" rel="stylesheet" type="text/css"/>
  <script src="<%= request.getContextPath()%>/js/jquery-1.7.1.min.js"></script> 
  <script src="<%= request.getContextPath()%>/js/jquery-ui-1.8.18.custom.min.js"></script> 
  <script src="<%= request.getContextPath()%>/js/createOrder.js"></script> 
<body>
<form:form id="createOrder" method="post" name="createOrder" modelAttribute="equityOrder" commandName="equityOrder" >
 <div align="left" id="orderTable">
    <table cellspacing="10" style="height: 200px;">
    <tr>
        <td><form:label path="symbol.name"><spring:message code="label.symbol"/></form:label></td>
        <td><form:input id="symbol" path="symbol.name" cssStyle="font-family:Times, serif;font-size:normal;"/></td>
    </tr>
    <tr>
        <td><form:label path="securityName"><spring:message code="label.securityName"/></form:label></td>
        <td><form:input id="securityName" path="securityName" readonly="true"/></td>
    </tr>
	<tr>
		<td><form:label path="side"><spring:message code="label.side"/></form:label></td>
		<td>
			<form:radiobutton path="side" value="Buy"/><spring:message code="label.buy"/>
			  <form:radiobutton path="side" value="Sell"/><spring:message code="label.sell"/>
		</td>
	</tr>
	<tr>
		<td><form:label path="orderType"><spring:message code="label.orderType"/></form:label></td>
		<td>
			<form:radiobutton path="orderType" value="Market"/><spring:message code="label.orderType.market"/>
			<form:radiobutton path="orderType" value="Limits"/><spring:message code="label.orderType.limits"/>
			<form:radiobutton path="orderType" value="Stop"/><spring:message code="label.orderType.stop"/>
			<form:radiobutton path="orderType" value="Stop Limit"/><spring:message code="label.orderType.stopLimit"/>
		</td>
	</tr>
	<tr>
		<td><form:label path="orderQualifier"><spring:message code="label.orderQualifier"/></form:label></td>
		<td>
			<form:radiobutton path="orderQualifier" value="DayOrder"/><spring:message code="label.orderQualifier.dayOrder"/>
			<form:radiobutton path="orderQualifier" value="GoodTillCancelled"/><spring:message code="label.orderQualifier.goodTillCancelled"/>
		</td>
	</tr>
	<tr>
		<td><form:label path="accountType"><spring:message code="label.accountType"/></form:label></td>
		<td>
			<form:radiobutton path="accountType" value="Cash"/><spring:message code="label.accountType.cash"/>
			<form:radiobutton path="accountType" value="Margin"/><spring:message code="label.accountType.margin"/>
		</td>
	</tr>  
	<tr>
		<td><form:label path="subAccount.name"><spring:message code="label.subAccounts"/></form:label></td>
		<td>
			<form:select id="subAccounts" path="subAccount.name" multiple="false" cssStyle="font-family:Times, serif;font-size:normal;height:25px;width:200;">
				<form:option value="" label=""/> 
				 <form:options items="${subAccounts}"/>
			</form:select>
		</td>
		 <td><form:errors path="subAccount" cssClass="errors"/></td>
	</tr> 
	<tr>
		<td><form:label path="portfolio.name"><spring:message code="label.portfolio"/></form:label></td>
		<td>
			<form:select  id="portfolios" path="portfolio.name" multiple="false" cssStyle="font-family:Times, serif;font-size:normal;height:25px;width:200;"> 
				 <form:options items="${portfolios}" />
			</form:select>
			<a id="addPortfolio" href="#" style="font-family:Times, serif;font-size:normal;background-color:#FFFFF0;color:#000080;">Add</a>
		</td>
		 
        <td><form:errors path="portfolio" cssClass="errors"/></td>
	</tr>
	
	<tr>
		<td><form:label path="qty"><spring:message code="label.Quantity"/></form:label></td>
		 <td><form:input path="qty" cssStyle="font-family:Times, serif;font-size:normal;"/></td>
		 <td><form:errors path="qty" cssClass="errors"/></td>
	</tr>
	<tr>
		<td><form:label path="stopPrice"><spring:message code="label.stopPrice"/></form:label></td>
		 <td><form:input path="stopPrice" cssStyle="font-family:Times, serif;font-size:normal;"/></td>
		 <td><form:errors path="stopPrice" cssClass="errors"/></td>
	</tr>
	<tr>
		<td><form:label path="limitPrice"><spring:message code="label.limitPrice"/></form:label></td>
		 <td><form:input path="limitPrice" cssStyle="font-family:Times, serif;font-size:normal;"/></td>
		 <td><form:errors path="limitPrice" cssClass="errors"/></td>
	</tr>
	<tr>
		<td><form:label path="notify"><spring:message code="label.notify"/></form:label></td>
		 <td><form:checkbox path="notify"/></td>
	</tr> 
	<tr>
		 <td><form:label path="notes"><spring:message code="label.notes"/></form:label></td>
		 <td><form:textarea path="notes" rows="5" cols="40" cssStyle="font-family:Times, serif;font-size:normal;"/></td>
		 <td><form:errors path="notes" cssClass="errors"/></td>
	</tr>
	</table>
	<table>
	<tr align="center">
		<td align="center"><strong><input id="Save" type="button" value="Save" /></strong></td>
	</tr>    
	</table>
</div>
</form:form>
<div id="dialog-form" title="Add Portfolio">
	<div>
	<table>
	<tr/>
	<tr><td><label for="name">Name</label>
		<td><input type="text" name="name" id="portfolioName" width="200px"/></td>
	</table>
	</div>
</div>

</body>
</html>
