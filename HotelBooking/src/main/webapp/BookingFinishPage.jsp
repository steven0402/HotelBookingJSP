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
			<p style="text-align:center; color:red; font-size:20px"><b>�w�w���\!!</b></p>
			<p style="text-align:center;font-size:15"><b>�m�W: ${OrderResult.uid}</b></p>
			<p style="text-align:center;font-size:15"><b>�q��s��: ${OrderResult.id}</b></p>
			<p style="text-align:center;font-size:15"><b>�s���s��: ${OrderResult.hotel_id} </b></p>
			<p style="text-align:center;font-size:15"><b>�J����: ${OrderResult.in_date}</b></p>
			<p style="text-align:center;font-size:15"><b>�h�Ф��: ${OrderResult.out_date}</b></p>
			<p style="text-align:center;font-size:15"><b>��H��: ${OrderResult.one_adult}</b></p>
			<p style="text-align:center;font-size:15"><b>���H��: ${OrderResult.two_adults}</b></p>
			<p style="text-align:center;font-size:15"><b>�|�H��: ${OrderResult.four_adults}</b></p>
			<p style="text-align:center;font-size:15"><b>�`��: ${OrderResult.total_price}</b></p>
			<p style="text-align:center;font-size:15"><b>�Ѽ�: ${OrderResult.total_nights}</b></p>
		</div>
	</div>
			
</body>
</html>