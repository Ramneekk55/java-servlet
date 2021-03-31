package Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet("/display")

public class DisplayServlet extends HttpServlet {

 protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
 {
  PreparedStatement ps=null;
  String s="";
  PrintWriter p=res.getWriter();
  String uname=req.getParameter("username");
 // p.println("Welcome: "+uname);
  Connection con=db.getDBConnection();
  try {
	  ps=con.prepareStatement("select * from table11");
	  ResultSet rs=ps.executeQuery();  
	  while(rs.next()){
		s=rs.getString("Name");
		if(uname.equals(s)) {
			p.println("Welcome: "+uname+"\n");
			p.println("<br>Your Roll no. is: "+rs.getInt("Roll no."));
			p.println("<br>You are currently in: "+rs.getInt("Year")+" year");
			break;
		}
	  }
 }
	  catch(SQLException e)
	  {
	   p.println(e);
	  }
}
}