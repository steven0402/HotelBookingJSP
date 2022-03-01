import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotel.exceptions.OrderException;
import hotel.user.*;
import java.awt.*;
import java.util.*;
import java.sql.*;

public class BookHotelReceive extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{

		int singleroom = Integer.parseInt(req.getParameter("singleR"));
		int doubleroom = Integer.parseInt(req.getParameter("doubleR"));
		int quadroom = Integer.parseInt(req.getParameter("quadR"));
		String indate = req.getParameter("inyear")+"-"+req.getParameter("inmonth")+"-"+req.getParameter("inday");
		String outdate = req.getParameter("outyear")+"-"+req.getParameter("outmonth")+"-"+req.getParameter("outday");
		int hotelID = Integer.parseInt(req.getParameter("hotelID"));
		String UID = req.getParameter("UID");
		
		Order order = new Order(singleroom, doubleroom, quadroom, indate, outdate, hotelID, UID);

		try{
			OrderResult r = order.orderRoom();
			res.setContentType("text/html; charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "\r\n"
					+ "	<meta charset=\"utf-8\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
					+ "	<title>�s���w���t��</title>\r\n"
					+ "	<link rel=\"stylesheet\" type=\"text/css\" href=\"mycss.css\">\r\n"
					+ "	\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "	<div class=\"backgroundImage\"></div>\r\n"
					+ "	\r\n"
					+ "	<div class=\"topnavi\">\r\n"
					+ "		<a href=\"IndexPage.html\"> �D�� </a>\r\n"
					+ "		<a href=\"#\"> ����ڭ� </a>\r\n"
					+ "		<a href=\"booking.html\"> �q�� </a>\r\n"
					+ "	</div>\r\n"
					+ "\r\n"
					+ "	<div class=\"container-main\">\r\n"
					+ "		<div class=\"searching\">\r\n"
					+ "				<p style=\"text-align:center; color:red; font-size:20px\"><b>�w�w���\!!</b></p>\r\n"
					+ "				<p style=\"text-align:center;font-size:15\"><b>�m�W: "+ r.uid +"</b><p>\r\n"
					+ "				<p style=\"text-align:center;font-size:15\"><b>�q��s��: "+r.id+"</b><p>\r\n"
					+ "				<p style=\"text-align:center;font-size:15\"><b>�s���s��: "+r.hotel_id+" </b><p>\r\n"
					+ "				<p style=\"text-align:center;font-size:15\"><b>�J����: "+r.in_date+"</b><p>\r\n"
					+ "				<p style=\"text-align:center;font-size:15\"><b>�h�Ф��: "+r.out_date+"</b><p>\r\n"
					+ "				<p style=\"text-align:center;font-size:15\"><b>��H��: "+r.one_adult+"</b><p>\r\n"
					+ "				<p style=\"text-align:center;font-size:15\"><b>���H��: "+r.two_adults+"</b><p>\r\n"
					+ "				<p style=\"text-align:center;font-size:15\"><b>�|�H��: "+r.four_adults+"</b><p>\r\n"
					+ "				<p style=\"text-align:center;font-size:15\"><b>�`��: "+r.total_price+"</b><p>\r\n"
					+ "				<p style=\"text-align:center;font-size:15\"><b>�Ѽ�: "+r.total_nights+"</b><p>\r\n"
					+ "		</div>\r\n"
					+ "	</div>\r\n"
					+ "</body>\r\n"
					+ "</html>");
		}
		catch(OrderException order_err){
		}
		/*
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "\r\n"
				+ "	<meta charset=\"utf-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "	<title>�s���w���t��</title>\r\n"
				+ "	<link rel=\"stylesheet\" type=\"text/css\" href=\"mycss.css\">\r\n"
				+ "	\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<div class=\"backgroundImage\"></div>\r\n"
				+ "	\r\n"
				+ "	<div class=\"topnavi\">\r\n"
				+ "		<a href=\"IndexPage.html\"> �D�� </a>\r\n"
				+ "		<a href=\"#\"> ����ڭ� </a>\r\n"
				+ "		<a href=\"booking.html\"> �q�� </a>\r\n"
				+ "	</div>\r\n"
				+ "\r\n"
				+ "	<div class=\"container-main\">\r\n"
				+ "		<div class=\"searching\">\r\n"
				+ "				<p style=\"text-align:center; color:red; font-size:20px\"><b>�w�w���\!!</b></p>\r\n"
				+ "				<p style=\"text-align:center;font-size:15\"><b>�m�W: "+ r.uid +"</b><p>\r\n"
				+ "				<p style=\"text-align:center;font-size:15\"><b>�q��s��: "+r.id+"</b><p>\r\n"
				+ "				<p style=\"text-align:center;font-size:15\"><b>�s���s��: "+r.hotel_id+" </b><p>\r\n"
				+ "				<p style=\"text-align:center;font-size:15\"><b>�J����: "+r.in_date+"</b><p>\r\n"
				+ "				<p style=\"text-align:center;font-size:15\"><b>�h�Ф��: "+r.out_date+"</b><p>\r\n"
				+ "				<p style=\"text-align:center;font-size:15\"><b>��H��: "+r.one_adult+"</b><p>\r\n"
				+ "				<p style=\"text-align:center;font-size:15\"><b>���H��: "+r.two_adults+"</b><p>\r\n"
				+ "				<p style=\"text-align:center;font-size:15\"><b>�|�H��: "+r.four_adults+"</b><p>\r\n"
				+ "				<p style=\"text-align:center;font-size:15\"><b>�`��: "+r.total_price+"</b><p>\r\n"
				+ "				<p style=\"text-align:center;font-size:15\"><b>�Ѽ�: "+r.total_nights+"</b><p>\r\n"
				+ "		</div>\r\n"
				+ "	</div>\r\n"
				+ "</body>\r\n"
				+ "</html>");*/
	}
}