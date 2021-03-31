package Login;

import java.sql.*;
import java.sql.DriverManager;

public class db {
   public static Connection getDBConnection() {
	   Connection con=null;
	   try {
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Table1?serverTimezone=UTC","root","");
		   System.out.println("Connection established");
	   }
	   catch(ClassNotFoundException e){
		   System.out.print(e);
	   }
	   catch(SQLException e) {
		   System.out.print(e);
	   }
	   return con;
   }
}
