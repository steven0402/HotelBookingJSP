import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotel.user.*;
import java.awt.*;
import java.util.*;

public class SelectHotelReceive extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{

		int singleroom = Integer.parseInt(req.getParameter("single"));
		int doubleroom = Integer.parseInt(req.getParameter("double"));
		int quadroom = Integer.parseInt(req.getParameter("quad"));
		int star = Integer.parseInt(req.getParameter("star"));
		String indate = req.getParameter("indate");	
		String outdate = req.getParameter("outdate");
		int hotelID = Integer.parseInt(req.getParameter("hotelID"));
		int amount = Integer.parseInt(req.getParameter("amount"));
		
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
		
		out.println("	<div class=\"container-main\">\r\n"
				+ "			<form action=\"BookHotel\">		\r\n"
				+ "				<div class=\"searching\">");
		
		out.println("				<div class=\"bookDetail\">");
		out.println("					<div class=\"confirmbar\">");
		
		out.println("						<div id=\"innerplaneAA\"><label><b>酒店號碼: </b></label></div>");
		out.println("							<div id=\"innerplaneBB\"><input type=\"text\" style=\"align-text:center\" class=\"ipx40\" name=\"hotelID\" placeholder=\"酒店號碼\" value=\""+hotelID+"\"></div>");
		out.println("					</div>");	
		
		out.println("					<div class=\"confirmbar\">");
		
		out.println("						<div id=\"innerplaneAA\"><label><b>單人房: </b></label></div>");
		out.println("							<div id=\"innerplaneBB\"><input type=\"text\" style=\"align-text:center\" class=\"ipx40\" name=\"singleR\" placeholder=\"單人房\" value=\""+singleroom+"\"></div>");
		
		out.println("					</div>");
		out.println("					<div class=\"confirmbar\">");
		out.println("						<div id=\"innerplaneAA\"><label><b>雙人房: </b></label></div>");
		out.println("							<div id=\"innerplaneBB\"><input type=\"text\" style=\"align-text:center\" class=\"ipx40\" name=\"doubleR\" placeholder=\"雙人房\" value=\""+doubleroom+"\"></div>");
		out.println("					</div>");
		
		out.println("					<div class=\"confirmbar\">");
		out.println("						<div id=\"innerplaneAA\"><label><b>四人房: </b></label></div>");
		out.println("							<div id=\"innerplaneBB\"><input type=\"text\" style=\"align-text:center\" class=\"ipx40\" name=\"quadR\" placeholder=\"四人房\" value=\""+quadroom+"\"></div>");
		out.println("					</div>");
		
		out.println("					<div class=\"confirmbar\">");
		out.println("						<div id=\"innerplaneAA\"><label><b>姓名: </b></label></div>");
		out.println("							<div id=\"innerplaneBB\"><input type=\"text\" style=\"align-text:center\" class=\"ipx40\" name=\"UIDsingleR\" placeholder=\"姓名\" value=\"admin\"></div>");
		out.println("					</div>");

		out.println("					<div class=\"confirmbar\">");
		out.println("						<div id=\"innerplaneAA\"><label><b>入住日期: </b></label></div>");
		out.println("							<div id=\"innerplaneBB\">"
				+ "							<div class=\"dateformat2\">\r\n"
				+ "								<input type=\"text\" class=\"ipx20\" name=\"inyear\" placeholder=\"年\" value=\"2021\">\r\n"
				+ "								<input type=\"text\" class=\"ipx10\" name=\"inmonth\" placeholder=\"月\" value=\"5\">\r\n"
				+ "								<input type=\"text\" class=\"ipx10\" name=\"inday\" placeholder=\"日\" value=\"16\">\r\n"
				+ "							</div></div>");
		out.println("					</div>");

		out.println("					<div class=\"confirmbar\">");
		out.println("						<div id=\"innerplaneAA\"><label><b>退房日期: </b></label></div>");
		out.println("							<div id=\"innerplaneBB\">							<div class=\"dateformat2\">\r\n"
				+ "								<input type=\"text\" class=\"ipx20\" name=\"outyear\" placeholder=\"年\" value=\"2021\">\r\n"
				+ "								<input type=\"text\" class=\"ipx10\" name=\"outmonth\" placeholder=\"月\" value=\"5\">\r\n"
				+ "								<input type=\"text\" class=\"ipx10\" name=\"outday\" placeholder=\"日\" value=\"20\">\r\n"
				+ "							</div></div>");
		out.println("					</div>");
		out.println("					</div>");
		out.print("	<input type=\"submit\" value=\"確定\" class=\"chosed\">\r\n");
		out.println("</form>");
		out.println("					</div>");
		
		out.println("					</div>");	
		out.println("   			</div>");	
		out.println("   		</div>");
		out.println("</body>");
		out.println("</html>");
	}
}