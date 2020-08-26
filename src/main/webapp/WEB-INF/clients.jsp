<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">
<head>
<title>Marginal Tax</title>
<link rel="stylesheet" href="format.css" />
<link rel="stylesheet" href="table-report.css" />
</head>
<body>
			Developer: ${developer} TimeStamp:  ${date}
			<hr/>
		client:	${client}
		
		
		<jsp:include page="../menu.jsp" />
	<div class="bodyReport">
		<h1>Clients</h1>
		
		<a href="clients?status=ALL">ALL Status</a>
		<a href="clients?status=MFJ">Married Filing Jointly</a>
		<a href="clients?status=S">Single</a>
		<a href="clients?status=MFS">Married Filing Single</a>
		<a href="clients?status=HH">Head of House Hold</a>
						
		<table>
			<thead>
				<tr>
					<th rowspan="2">Client <br /> Id
					</th>
					<th colspan='2'>Name</th>
					
					<th rowspan="2" >Current <br /> Salary</th>
					<th rowspan="2" >Status</th>					
				</tr>
				<tr>					
					<th>First</th>
					<th>Last</th>										
				</tr>
			</thead>
			<tbody>
			    	<c:forEach items="${clients}" var="t">
			
			<c:if test="${t.clientID == client.clientID}">
						<tr class="highlight">
			</c:if>
			
			<c:if test="${t.clientID != client.clientID}">
						<tr>
			</c:if>
			
			
			
					<td><a href="client.view?clientID=${t.clientID}">${t.clientID}</a></td>
					<td>${t.firstName}</td>
					<td class="money">${t.lastName}</td>
					<td class="money">$${t.currentSalary}</td>
					<td class="money">${t.status}</td>					
				</tr>
				</c:forEach>		
				
			</tbody>
		</table>	
	</div>
</body>
</html>