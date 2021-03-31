package Login;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
 
 protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
  {
   // TODO Auto-generated method stub 
  PrintWriter p=res.getWriter();
  PreparedStatement ps=null;
 // Connection con=null;
  String s="";
  String st="";
  int flag=0;
  String uname=req.getParameter("username");
  String pwd=req.getParameter("password");
 Connection con=db.getDBConnection();
  try {
  ps=con.prepareStatement("select * from users");
  ResultSet rs=ps.executeQuery();  
  while(rs.next()){
	s=rs.getString("username");
	if(uname.equals(s)) {
	  st=rs.getString("password");
	  if(pwd.equals(st)) {
		  RequestDispatcher rd=req.getRequestDispatcher("/hello");
		   rd.forward(req,res);
	  }
	  else {
		 flag=1;
		 break;
	  }
	}
	else {
		 flag=0;
	}
  }
  //<br> <br> <br> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp <br> <br> <br> <br> <br> <br> <br> <br> <br>
  if(flag==0) {
	 // p.println("Username is not registered");
	  RequestDispatcher rd=req.getRequestDispatcher("login1.html");
	  rd.include(req,res);
  }
  else if(flag==1) {
	 // p.println("Password is incorrect");
	  RequestDispatcher rd=req.getRequestDispatcher("login2.html");
	  rd.include(req,res);
  }
  }
  catch(SQLException e)
  {
   p.println(e);
  }
  
  
 }

}