package Dbms;
import java.sql.*;
public class Drivers {
		
		public static Connection con=null;
		public static Connection myconn(){
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "QWERTY");
		}
		catch (Exception exc){
			exc.printStackTrace();
				}
		
		return con;

		}
	}
