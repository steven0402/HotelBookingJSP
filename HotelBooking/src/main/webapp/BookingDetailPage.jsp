<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="java.util.ArrayList,hotel.user.*"%>    
<!DOCTYPE html>
<html>
<head>

	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>酒店預約系統</title>
	<link rel="stylesheet" type="text/css" href="mycss.css">
	
</head>

<body>
	<div class="header"> <jsp:include page="/header.jsp" /> </div>
	
	<div class="container-main">
		<form action="DeleteBooking">	
			<input style="hidden" name="OrderUID" value="${OrderUID}">
			<input style="hidden" name="OrderID" value="${OrderID}">		
			<div class="searching">
				<p style="text-align:center; color:red; font-size:20px"><b>您的訂單</b></p>
				<p style="text-align:center;font-size:15"><b>姓名: ${OrderUID}</b></p>
				<p style="text-align:center;font-size:15"><b>訂單編號: ${OrderID}</b></p>
				<p style="text-align:center;font-size:15"><b>酒店編號: ${OrderHOTELID} </b></p>
				<p style="text-align:center;font-size:15"><b>入住日期: ${OrderINDATE}</b></p>
				<p style="text-align:center;font-size:15"><b>退房日期: ${OrderOUTDATE}</b></p>
				<p style="text-align:center;font-size:15"><b>單人房: ${OrderSINGLE}</b></p>
				<p style="text-align:center;font-size:15"><b>雙人房: ${OrderDOUBLE}</b></p>
				<p style="text-align:center;font-size:15"><b>四人房: ${OrderQUAD}</b></p>
				<p style="text-align:center;font-size:15"><b>總價: ${OrderTOTALP}</b></p>
				<p style="text-align:center;font-size:15"><b>天數: ${OrderTOTALN}</b></p>
			</div>
			<input type="submit" value="取消預訂" class="searchButton">	
		</form>	
	</div>		
</body>
</html>