import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotel.user.*;
import java.awt.*;
import java.util.*;

public class SelectHotelReceive extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		
		//int singleroom = Integer.parseInt(req.getParameter("single"));
		//int doubleroom = Integer.parseInt(req.getParameter("double"));
		//int quadroom = Integer.parseInt(req.getParameter("quad"));
		//int star = Integer.parseInt(req.getParameter("star"));
		//String indate = req.getParameter("indate");	
		//String outdate = req.getParameter("outdate");
		//int hotelID = Integer.parseInt(req.getParameter("hotelID"));
		//int amount = Integer.parseInt(req.getParameter("amount"));
		if(req.getParameter("hotelID") !="")
		{
			req.getRequestDispatcher("SelectReturnPage.jsp").forward(req, res);
		}
		else
		{
			res.sendRedirect("BookingFailPage.jsp");
		}
		
		
	}
}