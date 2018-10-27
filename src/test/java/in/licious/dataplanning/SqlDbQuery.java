package in.licious.dataplanning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlDbQuery {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
	
		 String otp1=null;
		
		// TODO Auto-generated constructor stub
			
			
	//}

	
		//public static void main(String[] args) throws ClassNotFoundException, SQLException {
	//		System.out.println("Pass 11");
		
			
			
			
			
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Class.forName("com.mysql.jdbc.Driver");
			
	//		System.out.println("Pass 22");
			
			
			// Dev DB Access for OTP
			String url="jdbc:mysql://metabase-replica.c5zwbgmshqe9.ap-southeast-1.rds.amazonaws.com:3306/licious";
			
			 
			// ORT DB Access for OTP
			//String url="jdbc:mysql://52.220.241.136:3306/licious?autoReconnect=true&useSSL=false";
			
			//?autoReconnect=true;useSSL=false;
//:3306/tbl_sql.php?db=licious&table=orders&token=de1fa561bbc38396fc35d3aa8fb5461c
			
			
			Connection con;
		
				// Establishing DB connection for Dev
				con=DriverManager.getConnection(url, "marketing", "+\"4hf~`2CMAn:8=}");
				
				// Establishing DB connection for ORT
				//con=DriverManager.getConnection(url, "webmaster", "Licious@121");
			
	//			System.out.println("Pass 33");
				//ResultSet res = con.createStatement().executeQuery(" use licious");
				ResultSet res1 = con.createStatement().executeQuery(" select sum(oi.quantity) from orders o, order_items oi where o.order_id = oi.order_id and date(o.order_processing_date) BETWEEN '2018-07-01 ' AND '2018-07-31 '  and o.hub_id = '4' and product_id = 'pr_57f539b03c668' group by product_id; ");
				
				while (res1.next())
				{
				   //String otp = res1.getString(1);
				   
				   otp1=res1.getString(1);
				   
				  // System.out.println(otp);
						   
						   System.out.println(otp1);
				  
				}
				
				
	//			System.out.println("Pass 44");
				
				
				//System.out.println(res1.getString(1));
				con.close();
				res1.close();
		
			Class.forName("com.mysql.cj.jdbc.Driver");
		//} 	
		}
				
	}	

