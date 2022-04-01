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
			<p class="webtitle"><b>歡迎使用酒店預約系統</bi> </p>	
			<form action="SearchHotel">		
				<div class="searching">
				
					<div id="innerplaneA">
						<div class="roomsize">
							<p>房間大小</p>
							<div style="display:inline-block">		
							<label>單人房</label>
							<input type="text" class="ipx80" name="single" placeholder="單人房" value="1">
							</div>
							<div style="display:inline-block">
							<label>雙人房</label>
							<input type="text" class="ipx80" name="double" placeholder="雙人房" value="2">
							</div>
							<div style="display:inline-block">
							<label>四人房</label>
							<input type="text" class="ipx80" name="quad" placeholder="四人房" value="2">		
							</div>		
						</div>				
					</div>

					<div id="innerplaneB">
						<p> 星級</p>
						<div class="stars">
							<input type="text" class="ipx80" name="star" placeholder="酒店星數" value="3">
						</div>
						
						<div class="indate">
							<label>入住日期: </label>
							<div class="dateformat">
								<input type="text" class="ipx20" name="inyear" placeholder="年" value="2021">
								<input type="text" class="ipx10" name="inmonth" placeholder="月" value="5">
								<input type="text" class="ipx10" name="inday" placeholder="日" value="16">
							</div>
						</div>
						
						<div class="outdate">
							<label>退房日期: </label>
							<div class="dateformat">
								<input type="text" class="ipx20" name="outyear" placeholder="年" value="2021">
								<input type="text" class="ipx10" name="outmonth" placeholder="月" value="5">
								<input type="text" class="ipx10" name="outday" placeholder="日" value="20">
							</div>
						</div>
						  <input type="submit" value="搜尋" class="searchButton">
					</div>
				</div>
				
		 </form>

	</div>

</body>
</html>