<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,hotel.user.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
	
	<%
		int singleroom = Integer.parseInt(request.getParameter("single"));
		int doubleroom = Integer.parseInt(request.getParameter("double"));
		int quadroom = Integer.parseInt(request.getParameter("quad"));
		int star = Integer.parseInt(request.getParameter("star"));
		String indate = request.getParameter("indate");	
		String outdate = request.getParameter("outdate");
		int hotelID = Integer.parseInt(request.getParameter("hotelID"));
		int amount = Integer.parseInt(request.getParameter("amount"));
	%>
		
	<div class="container-main">
		<form action="BookHotel">
			<div class="searching">
			
				<div class="bookDetail">
				
					<%--酒店號碼--%>
					<div class="confirmbar">
						<div id="innerplaneAA"><label><b>酒店號碼: </b></label></div>
						<div id="innerplaneBB"><input type="text" style="align-text:center" class="ipx40" name="hotelID" placeholder="酒店號碼" value=<%=hotelID%>></div>
					</div>
					<%--單人房--%>
					<div class="confirmbar">
						<div id="innerplaneAA"><label><b>單人房: </b></label></div>
						<div id="innerplaneBB"><input type="text" style="align-text:center" class="ipx40" name="singleR" placeholder="單人房" value=<%=singleroom%>></div>
					</div>
					<%--雙人房--%>
					<div class="confirmbar">
						<div id="innerplaneAA"><label><b>雙人房: </b></label></div>
						<div id="innerplaneBB"><input type="text" style="align-text:center" class="ipx40" name="doubleR" placeholder="雙人房" value=<%=doubleroom%>></div>
					</div>
					<%--四人房--%>
					<div class="confirmbar">
						<div id="innerplaneAA"><label><b>四人房: </b></label></div>
						<div id="innerplaneBB"><input type="text" style="align-text:center" class="ipx40" name="quadR" placeholder="四人房" value=<%=quadroom%>></div>
					</div>
					<%--姓名--%>
					<div class="confirmbar">
						<div id="innerplaneAA"><label><b>姓名: </b></label></div>
						<div id="innerplaneBB"><input type="text" style="align-text:center" class="ipx40" name="UID" placeholder="姓名" value="admin"></div>
					</div>	
					<%--入住日期--%>
					<div class="confirmbar">
						<div id="innerplaneAA"><label><b>入住日期: </b></label></div>
						<div id="innerplaneBB">
							<div class="dateformat2">
								<input type="text" class="ipx20" name="inyear" placeholder="年" value="2022">
								<input type="text" class="ipx10" name="inmonth" placeholder="月" value="1">
								<input type="text" class="ipx10" name="inday" placeholder="日" value="5">
							</div>
						</div>
					</div>
					<%--退房日期--%>
					<div class="confirmbar">
						<div id="innerplaneAA"><label><b>退房日期: </b></label></div>
						<div id="innerplaneBB">
							<div class="dateformat2">
								<input type="text" class="ipx20" name="outyear" placeholder="年" value="2022">
								<input type="text" class="ipx10" name="outmonth" placeholder="月" value="1">
								<input type="text" class="ipx10" name="outday" placeholder="日" value="7">
							</div>
						</div>
					</div>
					
				</div>
				<input type="submit" value="確定" class="chosed">
			</div>

		</form>
	</div>
</body>
</html>