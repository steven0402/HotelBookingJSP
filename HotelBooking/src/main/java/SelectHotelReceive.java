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
				+ "	<title>�s���w���t��</title>"
				+ "	<link rel=\"stylesheet\" type=\"text/css\" href=\"mycss.css\">"		
				+ "</head>\r\n"
				+ "<body>"
				+ "	<div class=\"backgroundImage\"></div>");
		
		out.println("	<div class=\"topnavi\">\r\n"
				+ "		<a href=\"IndexPage.html\"> �D�� </a>\r\n"
				+ "		<a href=\"#\"> ����ڭ� </a>\r\n"
				+ "		<a href=\"booking.html\"> �q�� </a>\r\n"
				+ "	</div>");
		
		out.println("	<div class=\"container-main\">\r\n"
				+ "			<form action=\"BookHotel\">		\r\n"
				+ "				<div class=\"searching\">");
		
		out.println("				<div class=\"bookDetail\">");
		out.println("					<div class=\"confirmbar\">");
		
		out.println("						<div id=\"innerplaneAA\"><label><b>�s�����X: </b></label></div>");
		out.println("							<div id=\"innerplaneBB\"><input type=\"text\" style=\"align-text:center\" class=\"ipx40\" name=\"hotelID\" placeholder=\"�s�����X\" value=\""+hotelID+"\"></div>");
		out.println("					</div>");	
		
		out.println("					<div class=\"confirmbar\">");
		
		out.println("						<div id=\"innerplaneAA\"><label><b>��H��: </b></label></div>");
		out.println("							<div id=\"innerplaneBB\"><input type=\"text\" style=\"align-text:center\" class=\"ipx40\" name=\"singleR\" placeholder=\"��H��\" value=\""+singleroom+"\"></div>");
		
		out.println("					</div>");
		out.println("					<div class=\"confirmbar\">");
		out.println("						<div id=\"innerplaneAA\"><label><b>���H��: </b></label></div>");
		out.println("							<div id=\"innerplaneBB\"><input type=\"text\" style=\"align-text:center\" class=\"ipx40\" name=\"doubleR\" placeholder=\"���H��\" value=\""+doubleroom+"\"></div>");
		out.println("					</div>");
		
		out.println("					<div class=\"confirmbar\">");
		out.println("						<div id=\"innerplaneAA\"><label><b>�|�H��: </b></label></div>");
		out.println("							<div id=\"innerplaneBB\"><input type=\"text\" style=\"align-text:center\" class=\"ipx40\" name=\"quadR\" placeholder=\"�|�H��\" value=\""+quadroom+"\"></div>");
		out.println("					</div>");
		
		out.println("					<div class=\"confirmbar\">");
		out.println("						<div id=\"innerplaneAA\"><label><b>�m�W: </b></label></div>");
		out.println("							<div id=\"innerplaneBB\"><input type=\"text\" style=\"align-text:center\" class=\"ipx40\" name=\"UIDsingleR\" placeholder=\"�m�W\" value=\"admin\"></div>");
		out.println("					</div>");

		out.println("					<div class=\"confirmbar\">");
		out.println("						<div id=\"innerplaneAA\"><label><b>�J����: </b></label></div>");
		out.println("							<div id=\"innerplaneBB\">"
				+ "							<div class=\"dateformat2\">\r\n"
				+ "								<input type=\"text\" class=\"ipx20\" name=\"inyear\" placeholder=\"�~\" value=\"2021\">\r\n"
				+ "								<input type=\"text\" class=\"ipx10\" name=\"inmonth\" placeholder=\"��\" value=\"5\">\r\n"
				+ "								<input type=\"text\" class=\"ipx10\" name=\"inday\" placeholder=\"��\" value=\"16\">\r\n"
				+ "							</div></div>");
		out.println("					</div>");

		out.println("					<div class=\"confirmbar\">");
		out.println("						<div id=\"innerplaneAA\"><label><b>�h�Ф��: </b></label></div>");
		out.println("							<div id=\"innerplaneBB\">							<div class=\"dateformat2\">\r\n"
				+ "								<input type=\"text\" class=\"ipx20\" name=\"outyear\" placeholder=\"�~\" value=\"2021\">\r\n"
				+ "								<input type=\"text\" class=\"ipx10\" name=\"outmonth\" placeholder=\"��\" value=\"5\">\r\n"
				+ "								<input type=\"text\" class=\"ipx10\" name=\"outday\" placeholder=\"��\" value=\"20\">\r\n"
				+ "							</div></div>");
		out.println("					</div>");
		out.println("					</div>");
		out.print("	<input type=\"submit\" value=\"�T�w\" class=\"chosed\">\r\n");
		out.println("</form>");
		out.println("					</div>");
		
		out.println("					</div>");	
		out.println("   			</div>");	
		out.println("   		</div>");
		out.println("</body>");
		out.println("</html>");
	}
}