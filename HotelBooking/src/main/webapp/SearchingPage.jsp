<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
		<div class="searching">
				<p style="text-align:center; color:red; font-size:20px"><b>預定成功!!</b></p>
				<p style="text-align:center;font-size:15"><b>姓名: </b><p>
				<p style="text-align:center;font-size:15"><b>訂單編號: </b><p>
				<p style="text-align:center;font-size:15"><b>酒店編號: </b><p>
				<p style="text-align:center;font-size:15"><b>入住日期: </b><p>
				<p style="text-align:center;font-size:15"><b>退房日期: </b><p>
				<p style="text-align:center;font-size:15"><b>單人房: </b><p>
				<p style="text-align:center;font-size:15"><b>雙人房: </b><p>
				<p style="text-align:center;font-size:15"><b>四人房: </b><p>
				<p style="text-align:center;font-size:15"><b>總價: </b><p>
				<p style="text-align:center;font-size:15"><b>天數: </b><p>
		</div>
	</div>
</body>
</html>