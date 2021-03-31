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
public class SignupDisplay extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	  {
	   // TODO Auto-generated method stub 
	  PrintWriter p=res.getWriter();
	  PreparedStatement ps=null;
	 // Connection con=null;
	  int flag=0;
	  int rno=Integer.parseInt(req.getParameter("rollno"));
	  String n=req.getParameter("name");
	  int y=Integer.parseInt(req.getParameter("year"));
	  String uname=req.getParameter("username");
	  String pwd=req.getParameter("password");
	 Connection con=db.getDBConnection();
	 p.println(rno);
	 /* try {
	  ps=con.prepareStatement("select * from users");
	  ResultSet rs=ps.executeQuery();
}
catch(SQLException e)
  {
   p.println(e);
  }*/
}
}