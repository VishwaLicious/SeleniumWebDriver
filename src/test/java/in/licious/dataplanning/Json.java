package in.licious.dataplanning;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Json {

	public static void main(String[] args) throws IOException {
		//String ss="select sum(revenue),sum(quantity) from aggregation-data where date BETWEEN '2018-07-01' AND '2018-07-31' and product_id ='pr_57f539b03c668' and hub_id = 4";
		String ss="select sum(price) from orderdataplannew where date BETWEEN '2018-07-01' AND '2018-07-31' and product_id ='pr_57f539b03c668' and hub_id = 4";
		String sURL = "http://52.66.9.219:9200/_sql?sql="+URLEncoder.encode(ss); //just a string
		
//	String	sURL1 = URLEncoder.encode(sURL, "UTF-8");
	    // Connect to the URL using java's native library
	    URL url = new URL(sURL);
	    URLConnection request = url.openConnection();
	    request.connect();

	    // Convert to a JSON object to print data
	    JsonParser jp = new JsonParser(); //from gson
	    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
	    String rootobj = root.getAsJsonObject().get("aggregations").getAsJsonObject().get("SUM(price)").getAsJsonObject().get("value").getAsString();
	    
	    //May be an array, may be an object. 
	    System.out.println(rootobj);
	  // String value = rootobj.get("value").getAsString(); //just grab the zipcode
	    //System.out.println(value);

	}

}
