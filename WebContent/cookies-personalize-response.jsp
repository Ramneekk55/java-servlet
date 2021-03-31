<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>

<head><title>Confirmation</title></head>

<%
 // read form data
 String favLang = request.getParameter("favoriteLanguage");
 String favDish = request.getParameter("favoriteDish");
 String favNews = request.getParameter("favoriteNews");
 // create the cookie
 Cookie theCookie = new Cookie("myApp.favoriteLanguage", favLang);
 Cookie theCookie1= new Cookie("myApp.favoriteDish", favDish);
 Cookie theCookie2= new Cookie("myApp.favoriteNews", favNews);
 // set the life span ... total number of seconds (yuk!)
 theCookie.setMaxAge(60*60*24*365);    // <-- for one year
 theCookie1.setMaxAge(60*60*24);
 theCookie2.setMaxAge(60*60);
 // send cookie to browser
 response.addCookie(theCookie); 
 response.addCookie(theCookie1);
 response.addCookie(theCookie2);
%>
<body>

 Thanks! We set your favorite language to: ${param.favoriteLanguage}</br></br>
 Thanks! We set your favorite Dish to: ${param.favoriteDish}<br></br>
 Thanks! We set your favorite News to: ${param.favoriteNews}<br/><br/>
 
 <a href="cookies.jsp">Return to homepage.</a>
 </body>
 </html>