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

/* tr{
height:20px;
font-size:10pt !important;
font-family:Palatino, serif;
border-width: 3px;
}
th{
font-size:14pt !important;
font-family:Palatino, serif;
padding: 0 0.5em;
	text-align: left;
} */
th{
}
</style>
<body>
<form:form>
<table border="1" align="center" id="blottersTable" cellspacing="0" style="font-size:11pt !important;font-family:Palatino, serif;">
	<tbody>
		<tr align="center">
			<td style="width:10%;">OrderId</td>
			<td style="width:10%;">Status</td>
			<td style="width:10%;">Qty</td>
			<td style="width:10%;">OrderType</td>
			<td style="width:15%;">OrderQualifier</td>
			<td style="width:12%;">AccountType</td>
			<td style="width:12%;">SubAccount</td>
			<td style="width:10%;">Portfolio</td>
			<td style="width:10%;">StopPrice</td>
			<td style="width:16%;">LimitPrice</td>
		</tr>
	</tbody>
	<tbody>
		<c:forEach var="order" items="${orders}">
            <tr>
                <td align="center">${order.orderId}</td>
                <td align="center">${order.status}</td>
                <td align="center">${order.qty}</td>
                <td>${order.orderType}</td>
                <td>${order.orderQualifier}</td>
                <td>${order.accountType}</td>
                <td>${order.subAccount}</td>
                <td>${order.portfolio}</td>
                <td align="center">${order.stopPrice}</td>
                <td align="center">${order.limitPrice}</td>
            </tr>
        </c:forEach>
	</tbody>
</table>
</form:form>
</body>