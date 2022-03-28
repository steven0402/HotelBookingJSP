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

public class DeleteBookingReceive extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{

		int hotelID = Integer.parseInt(req.getParameter("OrderID"));
		String UID = req.getParameter("OrderUID");
		
		Cancel cancel = new Cancel(UID, hotelID);
		try{
			cancel.delOrder();
			
			req.getRequestDispatcher("CancelFinishPage.jsp").forward(req, res);
			
		}
		catch(Exception order_err){
			res.sendRedirect("BookingFailPage.jsp");
			
		}
	}
}