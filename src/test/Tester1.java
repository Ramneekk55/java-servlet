package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/h")
public class Tester1 extends HttpServlet{
 
 public void init()
 {
  
 }
 
 public void service(ServletRequest req, ServletResponse res) throws IOException,ServletException
 {
  PrintWriter pw=res.getWriter();
  res.setContentType("text/html");
  pw.println("Hey!");
 }
 
 public void destroy()
 {
  
 }

}