import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotel.user.*;
import java.awt.*;
import java.util.*;

public class SearchHotelReceivePROT extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		int singleroom = Integer.parseInt(req.getParameter("single"));
		int doubleroom = Integer.parseInt(req.getParameter("double"));
		int quadroom = Integer.parseInt(req.getParameter("quad"));
		int star = Integer.parseInt(req.getParameter("star"));	
		String indate = req.getParameter("inyear")+"-"+req.getParameter("inmonth")+"-"+req.getParameter("inday");
		String outdate = req.getParameter("outyear")+"-"+req.getParameter("outmonth")+"-"+req.getParameter("outday");
		
		Query HotelQuery;
		HotelQuery = new Query(singleroom, doubleroom, quadroom, indate, outdate, star);
		
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head>\r\n"
				+ "	<meta charset=\"utf-8\">"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
				+ "	<title>酒店預約系統</title>"
				+ "	<link rel=\"stylesheet\" type=\"text/css\" href=\"mycss.css\">"		
				+ "</head>\r\n"
				+ "<body>"
				+ "	<div class=\"backgroundImage\"></div>");
		
		out.println("	<div class=\"topnavi\">\r\n"
				+ "		<a href=\"IndexPage.html\"> 主頁 </a>\r\n"
				+ "		<a href=\"#\"> 關於我們 </a>\r\n"
				+ "		<a href=\"booking.html\"> 訂單 </a>\r\n"
				+ "	</div>");
		
		ArrayList<QueryResult> resultList = HotelQuery.searchRoom(0);
		out.println("<form action=\"selectHotel\">");
		out.println("<div class=\"hiddenChoice\" id=\"hiddenbox\">\r\n"
				+ "	<input type=\"text\" name=\"hotelID\" id=\"HhotelID\">\r\n"
				+ "	<input type=\"text\" name=\"star\" id=\"Hstar\">\r\n"
				+ "	<input type=\"text\" name=\"single\" id=\"Hsingle\">\r\n"
				+ "	<input type=\"text\" name=\"double\" id=\"Hdouble\">\r\n"
				+ "	<input type=\"text\" name=\"quad\" id=\"Hquad\">\r\n"
				+ "	<input type=\"text\" name=\"amount\" id=\"Hamount\">"
				+ " <input type=\"text\" name=\"indate\" id=\"Hindate\" value=\"" + indate + "\">"
				+ " <input type=\"text\" name=\"outdate\" id=\"Houtdate\" value=\"" + outdate + "\">"
				+ "</div>");
		
		out.println("	<div class=\"container-main\">");
		out.println("				<div class=\"searchResult\">");
		if (resultList.size() == 0) { 
			out.println("<p class=\"noresult\" style=\"text-align:center\">查無結果</p>");		
		}
		else
		{
			out.println("<div class=\"resultTable\">");
			out.println("<table class=\"tableStyle\" id=\"example\" >");
			out.println("<thead>");
			out.println("  <tr>\r\n"
					+ "    <th><b>酒店號碼</b></th>\r\n"
					+ "    <th><b>星級</b></th> \r\n"
					+ "    <th><b>單人房</b></th> \r\n"
					+ "    <th><b>雙人房</b></th> \r\n"
					+ "    <th><b>四人房</b></th> \r\n"
					+ "    <th><b>總價</b></th> \r\n"
					+ "  </tr>");
			out.println("</thead>");
			
			out.println("<tbody>");
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
			out.println("</tbody>");
			out.println("</table>");
			
			
			out.println("</div>");
			
			out.print("	<input type=\"submit\" value=\"選擇\" class=\"chosed\">\r\n");
			out.println("</form>");
			out.println("</div>");
			out.println("<script>\r\n"
					+ "highlight_row();\r\n"
					+ "function highlight_row() {\r\n"
					+ "    var table = document.getElementById('example');\r\n"
					
					+ "    var hotelID = document.getElementById('HhotelID');\r\n"
					+ "    var star = document.getElementById('Hstar');\r\n"
					+ "    var singleR = document.getElementById('Hsingle');\r\n"
					+ "    var doubleR = document.getElementById('Hdouble');\r\n"
					+ "    var quadR = document.getElementById('Hquad');\r\n"
					+ "    var amount = document.getElementById('Hamount');\r\n"
					
					+ "    var cells = table.getElementsByTagName('td');\r\n"
					+ "\r\n"
					+ "    for (var i = 0; i < cells.length; i++) {\r\n"
					+ "        // Take each cell\r\n"
					+ "        var cell = cells[i];\r\n"
					+ "        // do something on onclick event for cell\r\n"
					+ "        cell.onclick = function () {\r\n"
					+ "            // Get the row id where the cell exists\r\n"
					+ "            var rowId = this.parentNode.rowIndex;\r\n"
					+ "\r\n"
					+ "            var rowsNotSelected = table.getElementsByTagName('tr');\r\n"
					+ "            for (var row = 0; row < rowsNotSelected.length; row++) {\r\n"
					+ "                rowsNotSelected[row].style.backgroundColor = \"\";\r\n"
					+ "                rowsNotSelected[row].classList.remove('selected');\r\n"
					+ "            }\r\n"
					+ "            var rowSelected = table.getElementsByTagName('tr')[rowId];\r\n"
					+ "            rowSelected.className += \" selected\";\r\n"
					+ "\r\n"
					+ " 			hotelID.value = rowSelected.cells[0].innerHTML; "
					+ " 			star.value = rowSelected.cells[1].innerHTML; "
					+ " 			singleR.value = rowSelected.cells[2].innerHTML; "
					+ " 			doubleR.value = rowSelected.cells[3].innerHTML; "
					+ " 			quadR.value = rowSelected.cells[4].innerHTML; "
					+ " 			amount.value = rowSelected.cells[5].innerHTML; "
					+ "        }\r\n"
					+ "    }\r\n"
					+ "\r\n"
					+ "}\r\n"
					+ "</script>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		}
		
	}

}
