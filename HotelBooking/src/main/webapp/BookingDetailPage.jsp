<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="java.util.ArrayList,hotel.user.*"%>    
<!DOCTYPE html>
<html>
<head>

	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>�s���w���t��</title>
	<link rel="stylesheet" type="text/css" href="mycss.css">
	
</head>

<body>
	<div class="header"> <jsp:include page="/header.jsp" /> </div>
	
	<div class="container-main">
		<form action="DeleteBooking">	
			<input style="hidden" name="OrderUID" value="${OrderUID}">
			<input style="hidden" name="OrderID" value="${OrderID}">		
			<div class="searching">
				<p style="text-align:center; color:red; font-size:20px"><b>�z���q��</b></p>
				<p style="text-align:center;font-size:15"><b>�m�W: ${OrderUID}</b></p>
				<p style="text-align:center;font-size:15"><b>�q��s��: ${OrderID}</b></p>
				<p style="text-align:center;font-size:15"><b>�s���s��: ${OrderHOTELID} </b></p>
				<p style="text-align:center;font-size:15"><b>�J����: ${OrderINDATE}</b></p>
				<p style="text-align:center;font-size:15"><b>�h�Ф��: ${OrderOUTDATE}</b></p>
				<p style="text-align:center;font-size:15"><b>��H��: ${OrderSINGLE}</b></p>
				<p style="text-align:center;font-size:15"><b>���H��: ${OrderDOUBLE}</b></p>
				<p style="text-align:center;font-size:15"><b>�|�H��: ${OrderQUAD}</b></p>
				<p style="text-align:center;font-size:15"><b>�`��: ${OrderTOTALP}</b></p>
				<p style="text-align:center;font-size:15"><b>�Ѽ�: ${OrderTOTALN}</b></p>
			</div>
			<input type="submit" value="�����w�q" class="searchButton">	
		</form>	
	</div>		
</body>
</html>