<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>

<body>
<h3>Training Portal</h3>

<!-- read the favorite programming language cookie -->
<%
 // the default ... if there are no cookies
 String favLang = "Java";
 String favDish = "Pizza";
 String favNews= "Entertainment";
 // get the cookies from the browser request
 Cookie[] theCookies = request.getCookies();
 Cookie[] theCookies1= request.getCookies();
 Cookie[] theCookies2= request.getCookies();
 // find our favorite language cookie
 if (theCookies != null) {
  
  for (Cookie tempCookie : theCookies) {
   
   if ("myApp.favoriteLanguage".equals(tempCookie.getName())) {
    favLang = tempCookie.getValue();
    break;
   }
  }
 }
 if (theCookies1 != null) {
	  
	  for (Cookie tempCookie : theCookies1) {
	   
	   if ("myApp.favoriteDish".equals(tempCookie.getName())) {
	    favDish = tempCookie.getValue();
	    break;
	   }
	  }
	 }
 if (theCookies2 != null) {
	  
	  for (Cookie tempCookie : theCookies2) {
	   
	   if ("myApp.favoriteNews".equals(tempCookie.getName())) {
	    favNews = tempCookie.getValue();
	    break;
	   }
	  }
	 }
%>

<!-- now show a personalized page ... use the "favLang" variable -->

<!-- show new books for this lang -->
<h4>New Books for <%= favLang %></h4>
<ul>
 <li>blah blah blah</li>
 <li>blah blah blah</li>
</ul>

<h4>Show some Places for <%= favDish %></h4>
<ul>
 <li>blah blah blah</li>
 <li>blah blah blah</li>
</ul>

<h4>Latest News of <%= favNews %></h4>
<ul>
 <li>blah blah blah</li>
 <li>blah blah blah</li>
</ul>

<hr>
<a href="cookies-personalize-form.html">Personalize this page</a>
</body>

</html>