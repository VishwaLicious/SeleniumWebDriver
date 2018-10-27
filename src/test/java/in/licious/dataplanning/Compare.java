package in.licious.dataplanning;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import in.licious.util.ReadData;

public class Compare {

	public static void main(String[] args) throws Throwable   {
		ReadData rd=new ReadData();
		String excelFilePath="C:\\Users\\vishwa\\git\\SeleniumWebDriver\\ExcelData\\DataPlanning.xlsx";
		String elasticdata=rd.readDataFromExcel(excelFilePath, "Dataplanning", 1, 1);
		System.out.println(elasticdata);
		//String ss="select sum(revenue),sum(quantity) from aggregation-data where date BETWEEN '2018-07-01' AND '2018-07-31' and product_id ='pr_57f539b03c668' and hub_id = 4";
		String sURL = "http://52.66.9.219:9200/_sql?sql="+URLEncoder.encode(elasticdata); //just a string
		
//	String	sURL1 = URLEncoder.encode(sURL, "UTF-8");
	    // Connect to the URL using java's native library
	    URL url = new URL(sURL);
	    URLConnection request = url.openConnection();
	    request.connect();

	    // Convert to a JSON object to print data
	    JsonParser jp = new JsonParser(); //from gson
	    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
	    JsonElement rootobj = root.getAsJsonObject().get("aggregations").getAsJsonObject().get("SUM(quantity)").getAsJsonObject().get("value"); //May be an array, may be an object. 
	    System.out.println(rootobj);
	    
	    
System.out.println("***************************************************************************");


String otp1=null;

Double otp2=null;


// TODO Auto-generated constructor stub
	
	
//}
	

//public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		System.out.println("Pass 11");

	
	
	
	
	//Class.forName("com.mysql.cj.jdbc.Driver");
	
	//Class.forName("com.mysql.jdbc.Driver");
	
//		System.out.println("Pass 22");
	
	
	// Dev DB Access for OTP
	String url1="jdbc:mysql://metabase-replica.c5zwbgmshqe9.ap-southeast-1.rds.amazonaws.com:3306/licious";
	
	 
	// ORT DB Access for OTP
	//String url="jdbc:mysql://52.220.241.136:3306/licious?autoReconnect=true&useSSL=false";
	
	//?autoReconnect=true;useSSL=false;
//:3306/tbl_sql.php?db=licious&table=orders&token=de1fa561bbc38396fc35d3aa8fb5461c
	
	
	Connection con;

		// Establishing DB connection for Dev
		con=DriverManager.getConnection(url1, "marketing", "+\"4hf~`2CMAn:8=}");
		
		// Establishing DB connection for ORT
		//con=DriverManager.getConnection(url, "webmaster", "Licious@121");
	
//			System.out.println("Pass 33");
		//ResultSet res = con.createStatement().executeQuery(" use licious");
		String elasticdata1=rd.readDataFromExcel(excelFilePath, "Dataplanning", 1, 0);
		ResultSet res1 = con.createStatement().executeQuery(elasticdata1);
		
		while (res1.next())
		{
		   //String otp = res1.getString(1);
		   
		   otp1=res1.getString(1);
		   
		  // System.out.println(otp);
				   
				   System.out.println(otp1);
				   
				  // int num = (int) Double.parseDouble(otp1);
				   
				   /*otp2= Double.parseDouble(otp1);
				    
				    String total2 = String.valueOf(otp2); 
				   
				   System.out.println(otp2);
		  */
		}
		
		otp2= Double.parseDouble(otp1);
	    
	    String total2 = String.valueOf(otp2);
	   
	   System.out.println(otp2);
		
		System.out.println("*****************************************************************");
		
		
		//System.out.println(res1.getString(1));
		con.close();
		res1.close();

	Class.forName("com.mysql.cj.jdbc.Driver");
	

	if(rootobj.toString().equals(total2)) {
		
		System.out.println("Same");
	}
	
	else {
		System.out.println("Not Same");
	}
	}
}
