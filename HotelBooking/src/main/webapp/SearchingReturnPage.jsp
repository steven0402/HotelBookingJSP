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
		Query HotelQuery = (Query)request.getAttribute("HotelQuery");
		ArrayList<QueryResult> resultList = HotelQuery.searchRoom(0);
	
		String indate = request.getParameter("inyear")+"-"+request.getParameter("inmonth")+"-"+request.getParameter("inday");
		String outdate = request.getParameter("outyear")+"-"+request.getParameter("outmonth")+"-"+request.getParameter("outday");
		String inyear = request.getParameter("inyear");
		String inmonth = request.getParameter("inmonth");
		String inday = request.getParameter("inday");
		String outyear = request.getParameter("outyear");
		String outmonth = request.getParameter("outmonth");
		String outday = request.getParameter("outday");
	%>
	
	<form action="selectHotel">
		<div class="hiddenChoice" id="hiddenbox">
			<input type="text" name="inyear" id="Hinyear" value="<%=inyear%>">
			<input type="text" name="inmonth" id="Hinmonth" value="<%=inmonth%>">
			<input type="text" name="inday" id="Hinday" value="<%=inday%>">
			<input type="text" name="outyear" id="Houtyear" value="<%=outyear%>">
			<input type="text" name="outmonth" id="Houtmonth" value="<%=outmonth%>">
			<input type="text" name="outday" id="Houtday" value="<%=outday%>">
			<input type="text" name="hotelID" id="HhotelID">
			<input type="text" name="star" id="Hstar">
			<input type="text" name="single" id="Hsingle">
			<input type="text" name="double" id="Hdouble">
			<input type="text" name="quad" id="Hquad">
			<input type="text" name="amount" id="Hamount">
			<input type="text" name="indate" id="Hindate" value="<%=indate%>">
			<input type="text" name="outdate" id="Houtdate" value="<%=outdate%>">	
		</div>
		
		<div class="container-main">
			<div class="searchResult">
				<c:set var = "QuerySize" value = "${HotelQuery.searchRoom(0).size()}" />
				<c:choose>
					<c:when test="${QuerySize == 0}">
						<p class="noresult" style="text-align:center">查無結果</p>
					</c:when>
					<c:otherwise>
						<div class="resultTable">
							<table class="tableStyle" id="example" >
								<thead>
									<tr>
										<th><b>酒店號碼</b></th>
										<th><b>星級</b></th>
										<th><b>單人房</b></th>
										<th><b>雙人房</b></th>
										<th><b>四人房</b></th>
										<th><b>總價</b></th>
									</tr>
								</thead>
								
								<tbody>
									<%
										int i = 1;
										for(QueryResult r : resultList){
											out.println("<tr class=\"normal\">");
											out.println("<td name=\"id"+i+"\" value=\""+r.hotel_id+"\">" + r.hotel_id + "</td>" +
														"<td name=\"star"+i+"\" value=\""+r.star+"\">" + r.star + "</td>" +
														"<td name=\"one_adult"+i+"\" value=\""+r.one_adult+"\">" + r.one_adult + "</td>" +
														"<td name=\"two_adults"+i+"\" value=\""+r.two_adults+"\">" + r.two_adults + "</td>" +
														"<td name=\"four_adults"+i+"\" value=\""+r.four_adults+"\">" + r.four_adults + "</td>"  +
														"<td name=\"total_price"+i+"\" value=\""+r.total_price+"\">" + r.total_price + "</td>" );
											out.println("<tr>");
										i ++;
										}
									%>
								</tbody>
							</table>
						</div>
						<input type="submit" value="選擇" class="chosed">
					</c:otherwise>
				</c:choose>
				
			</div>
		</div>
		
	</form>
	
	<script>
		highlight_row();
		function highlight_row() {
			var table = document.getElementById('example');
			var hotelID = document.getElementById('HhotelID');
			var star = document.getElementById('Hstar');
			var singleR = document.getElementById('Hsingle');
			var doubleR = document.getElementById('Hdouble');
			var quadR = document.getElementById('Hquad');
			var amount = document.getElementById('Hamount');
			var cells = table.getElementsByTagName('td');
			
			for (var i = 0; i < cells.length; i++) {
				var cell = cells[i];
				
				cell.onclick = function () {
					var rowId = this.parentNode.rowIndex;
					var rowsNotSelected = table.getElementsByTagName('tr');
					
					for (var row = 0; row < rowsNotSelected.length; row++) {
						rowsNotSelected[row].style.backgroundColor = "";
						rowsNotSelected[row].classList.remove('selected');
					}
					var rowSelected = table.getElementsByTagName('tr')[rowId];
					rowSelected.className += " selected";
					hotelID.value = rowSelected.cells[0].innerHTML;
					star.value = rowSelected.cells[1].innerHTML;
					singleR.value = rowSelected.cells[2].innerHTML;
					doubleR.value = rowSelected.cells[3].innerHTML;
					quadR.value = rowSelected.cells[4].innerHTML;
					amount.value = rowSelected.cells[5].innerHTML;
				}
				
			}
			
		}
	</script>
</body>
</html>