import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotel.exceptions.OrderException;
import hotel.user.*;
import java.awt.*;
import java.util.*;
import java.sql.*;
import hotel.exceptions.OrderException;
import hotel.user.*;

public class BookHotelReceive extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
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
			//req.setAttribute("OrderResult", r);
			//req.getRequestDispatcher("BookingFinishPage.jsp").forward(req, res);
			
		}
		catch(OrderException order_err){
			res.sendRedirect("BookingFailPage.jsp");
			
		}
	}
}