package in.licious.dataplanning;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.testng.annotations.Test;

import groovy.json.JsonParser;
import io.restassured.response.Response;
import junit.framework.Assert;



public class RestAssured {
@SuppressWarnings("deprecation")
@Test
public void getTest()
{
    String sURL="http://52.66.9.219:9200/_sql?sql=select sum(revenue),sum(quantity) from aggregation-data where date IN('2018-07-23', '2018-07-16', '2018-07-09', '2018-07-02') and product_id ='pr_5746a7a8198ef' and hub_id = 4";
    Response response=io.restassured.RestAssured.get("http://52.66.9.219:9200/_sql?sql=select sum(revenue),sum(quantity) from aggregation-data where date IN('2018-07-23', '2018-07-16', '2018-07-09', '2018-07-02') and product_id ='pr_5746a7a8198ef' and hub_id = 4");
    int stcode=response.getStatusCode();
    String resbody=response.asString();
    
    System.out.println(resbody);
    Assert.assertEquals(200, stcode);
    
}
}