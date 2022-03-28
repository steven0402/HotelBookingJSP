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
				<div class="BookingBox">
					<img style="width:100%; height:50px" src="img/banner1.jpg">
					<form action="SearchBooking">
						<%--姓名--%>
						<div class="confirmbar" style="left: 50%">
							<div class="columnplane">
								<label><b>姓名: </b></label><br>
								<input type="text" style="align-text:center;" class="ipx40" name="UID" placeholder="姓名" value="">
							</div>
						</div>
				
						<%--訂單編號--%>
						<div class="confirmbar">
							<div class="columnplane">
								<label><b>訂單編號: </b></label><br>
								<input type="text" style="align-text:center" class="ipx40" name="OID" placeholder="訂單編號" value="">
							</div>
						</div>
						<input type="submit" value="搜尋" class="BookingsearchButton">
					</form>
				</div>
				
			</div>
		</div>
</body>
</html>