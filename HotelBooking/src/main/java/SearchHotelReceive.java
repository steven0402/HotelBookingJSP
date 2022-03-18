import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotel.user.*;
import java.awt.*;
import java.util.*;

public class SearchHotelReceive extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		int singleroom = Integer.parseInt(req.getParameter("single"));
		int doubleroom = Integer.parseInt(req.getParameter("double"));
		int quadroom = Integer.parseInt(req.getParameter("quad"));
		int star = Integer.parseInt(req.getParameter("star"));	
		String indate = req.getParameter("inyear")+"-"+req.getParameter("inmonth")+"-"+req.getParameter("inday");
		String outdate = req.getParameter("outyear")+"-"+req.getParameter("outmonth")+"-"+req.getParameter("outday");
		
		Query HotelQuery;
		HotelQuery = new Query(singleroom, doubleroom, quadroom, indate, outdate, star);
		
		req.setAttribute("HotelQuery", HotelQuery);
		req.getRequestDispatcher("SearchingReturnPage.jsp").forward(req, res);
		
		
	}

}
