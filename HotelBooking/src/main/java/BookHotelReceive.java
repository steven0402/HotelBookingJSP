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
		ValidInput checkvalid = new ValidInput();
		if(checkvalid.CheckSpecialCharExist(UID) == false)
		{
			Order order = new Order(singleroom, doubleroom, quadroom, indate, outdate, hotelID, UID);
			try{
				OrderResult r = order.orderRoom();
				
				req.setAttribute("OrderUID", r.uid);
				req.setAttribute("OrderID", r.id);
				req.setAttribute("OrderHOTELID", r.hotel_id);
				req.setAttribute("OrderINDATE", r.in_date);
				req.setAttribute("OrderOUTDATE", r.out_date);
				req.setAttribute("OrderSINGLE", r.one_adult);
				req.setAttribute("OrderDOUBLE", r.two_adults);
				req.setAttribute("OrderQUAD", r.four_adults);
				req.setAttribute("OrderTOTALP", r.total_price);
				req.setAttribute("OrderTOTALN", r.total_nights);
				
				req.getRequestDispatcher("BookingFinishPage.jsp").forward(req, res);
				
			}
			catch(OrderException order_err){
				res.sendRedirect("BookingFailPage.jsp");
				
			}
		}
		else
		{
			res.sendRedirect("WrongInputPage.jsp");
		}
	}
}