import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotel.exceptions.CheckException;
import hotel.exceptions.OrderException;
import hotel.user.*;
import java.awt.*;
import java.util.*;
import java.sql.*;
import hotel.exceptions.OrderException;
import hotel.user.*;

public class SearchBookingReceive extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{

		String userID = req.getParameter("UID");
		String orderID = req.getParameter("OID");
		boolean wrongInput = false;
		
		if(userID == "" || orderID == "")
		{
			wrongInput = true;
		}
		
		if(wrongInput == false)
		{
			Check check = new Check(userID, Integer.parseInt(orderID));
			try{
				CheckResult r = check.getOrder();
				req.setAttribute("OrderUID", userID);
				req.setAttribute("OrderID", orderID);	
				req.setAttribute("OrderHOTELID", r.hotel_id);
				req.setAttribute("OrderINDATE", r.in_date);
				req.setAttribute("OrderOUTDATE", r.out_date);
				req.setAttribute("OrderSINGLE", r.one_adult);
				req.setAttribute("OrderDOUBLE", r.two_adults);
				req.setAttribute("OrderQUAD", r.four_adults);
				req.setAttribute("OrderTOTALP", r.total_price);
				req.setAttribute("OrderTOTALN", r.total_nights);
				
				req.getRequestDispatcher("BookingDetailPage.jsp").forward(req, res);
				
			}
			catch(CheckException check_err){
				res.sendRedirect("BookingFailPage.jsp");
			}
		
		}
		else
		{
			res.sendRedirect("BookingFailPage.jsp");
		}
	}
}