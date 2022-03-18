<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<%
	int singleroom = Integer.parseInt(request.getParameter("singleR"));
	int doubleroom = Integer.parseInt(request.getParameter("doubleR"));
	int quadroom = Integer.parseInt(request.getParameter("quadR"));
	String indate = request.getParameter("inyear")+"-"+request.getParameter("inmonth")+"-"+request.getParameter("inday");
	String outdate = request.getParameter("outyear")+"-"+request.getParameter("outmonth")+"-"+request.getParameter("outday");
	int hotelID = Integer.parseInt(request.getParameter("hotelID"));
	String UID = request.getParameter("UID");
	//var r = request.getParameter("OrderResult");
	%>
	
	<div class="container-main">
		<div class="searching">
			<p style="text-align:center; color:red; font-size:20px"><b>預定成功!!</b></p>
			<p style="text-align:center;font-size:15"><b>姓名: ${OrderResult.uid}</b></p>
			<p style="text-align:center;font-size:15"><b>訂單編號: ${OrderResult.id}</b></p>
			<p style="text-align:center;font-size:15"><b>酒店編號: ${OrderResult.hotel_id} </b></p>
			<p style="text-align:center;font-size:15"><b>入住日期: ${OrderResult.in_date}</b></p>
			<p style="text-align:center;font-size:15"><b>退房日期: ${OrderResult.out_date}</b></p>
			<p style="text-align:center;font-size:15"><b>單人房: ${OrderResult.one_adult}</b></p>
			<p style="text-align:center;font-size:15"><b>雙人房: ${OrderResult.two_adults}</b></p>
			<p style="text-align:center;font-size:15"><b>四人房: ${OrderResult.four_adults}</b></p>
			<p style="text-align:center;font-size:15"><b>總價: ${OrderResult.total_price}</b></p>
			<p style="text-align:center;font-size:15"><b>天數: ${OrderResult.total_nights}</b></p>
		</div>
	</div>
			
</body>
</html>