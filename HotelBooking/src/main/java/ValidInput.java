import java.io.IOException;
import java.util.regex.*;

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

public class ValidInput
{
	public boolean CheckSpecialCharExist(String inputString)
	{
		
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(inputString);
		boolean b = m.find();
		return b;
	}
}