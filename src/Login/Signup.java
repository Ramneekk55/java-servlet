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
public class Signup extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	  {
	   // TODO Auto-generated method stub 
	  PrintWriter p=res.getWriter();
	  PreparedStatement ps=null;
	  int flag=0,r=0;
	  int rno=Integer.parseInt(req.getParameter("rollno"));
	  String n=req.getParameter("name1");
	  int y=Integer.parseInt(req.getParameter("year"));
	  String uname=req.getParameter("username");
	  String pwd=req.getParameter("password");
	 Connection con=db.getDBConnection();
	 try {
		  ps=con.prepareStatement("select * from table11");
		  ResultSet rs=ps.executeQuery();  
		  while(rs.next()){
			r=rs.getInt("Roll no.");
			if(rno==r) {
				flag=1;
			}
		  }
		  if(flag==1) {
			  RequestDispatcher rd=req.getRequestDispatcher("signup1.html");
			  rd.include(req,res);
		  }
	 }
	 catch(SQLException e)
	  {
	   p.println(e);
	  }
	 if(flag==0) {
	 try
	  {
	   ps=con.prepareStatement("insert into users values(?,?)");
	   ps.setString(1,uname);
	   ps.setString(2,pwd);
	   int t=ps.executeUpdate();
	  }
	  catch(SQLException e)
	  {
	   e.printStackTrace();
	  }
	 try
	  {
	   ps=con.prepareStatement("insert into table11 values(?,?,?,?)");
	   ps.setInt(1,rno);
	   ps.setString(2,n);
	   ps.setString(3,uname);
	   ps.setInt(4,y);
	   int t=ps.executeUpdate();
	  }
	  catch(SQLException e)
	  {
	   e.printStackTrace();
	  }
	 
	 p.println("Records inserted successfully");
	 }
}
}