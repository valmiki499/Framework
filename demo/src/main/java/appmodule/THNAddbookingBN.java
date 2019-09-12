package appmodule;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.json.XML;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class THNAddbookingBN {
	
	 //static String line = "", str = "";
	//public static final String xmlFilePath ="D:\\valmiki\\Selenium progam\\demo\\test-output\\THNAddreservation.xml";
	static String modifyexternalID; 
	static DateFormat df2 = new SimpleDateFormat("ddMMyyHHmmss");
    static Date dateobj2 = new Date();
	public static void THNaddbooking(WebDriver driver) throws Exception
	{
		
		String filePath = "D:\\valmiki\\Selenium progam\\demo\\test-output\\THNAddreservation.xml";
        File xmlFile = new File(filePath);
        
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
        Document xmlDom = docBuilder.parse(xmlFile);
        xmlDom.getDocumentElement().normalize();
        
        Node Rate = xmlDom.getElementsByTagName("Rate").item(0);
        NamedNodeMap attribute = Rate.getAttributes();
        
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        Date date = calendar.getTime();

        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        
        System.out.println(dateFormat.format(date));
        
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        calendar2.add(Calendar.DAY_OF_YEAR,2);
        
        Date tomorrow =calendar.getTime();
        Date dayaftertomorrow=calendar2.getTime();
        System.out.println( dateFormat.format(tomorrow));
        System.out.println( dateFormat.format(dayaftertomorrow));
        
        Node EffectiveDate = attribute.getNamedItem("EffectiveDate");
        EffectiveDate.setNodeValue(dateFormat.format(tomorrow));
        
        Node ExpireDate = attribute.getNamedItem("ExpireDate");
        ExpireDate.setNodeValue(dateFormat.format(tomorrow));
        
        Node TimeSpan = xmlDom.getElementsByTagName("TimeSpan").item(0);
        NamedNodeMap attribute1 = TimeSpan.getAttributes(); 
        
        
        Node Enddate = attribute1.getNamedItem("End");
        Enddate.setNodeValue(dateFormat.format(dayaftertomorrow));
        
        
        Node Startdate = attribute1.getNamedItem("Start");
        Startdate.setNodeValue(dateFormat.format(tomorrow));
        
        
        
        DateFormat df1 = new SimpleDateFormat("ddMMHHmmss");
        Date dateobj1 = new Date();
        System.out.println(df1.format(dateobj1));
        
        Node HotelReservationID = xmlDom.getElementsByTagName("HotelReservationID").item(0);
        NamedNodeMap ResID_Value = HotelReservationID.getAttributes();
        
        Node ResID = ResID_Value.getNamedItem("ResID_Value");
        ResID.setNodeValue(df1.format(dateobj1));
        modifyexternalID= df1.format(dateobj1);
        
//        String xmlAsString = xmlDom.toString(); // this will not print what you want
//        System.out.println("XML as String using DOM Parser : ");
//        System.out.println(xmlAsString);
        xmlDom.getDocumentElement().normalize();
        
        
        System.out.println(df2.format(dateobj2));

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(xmlDom);

        StreamResult streamResult = new StreamResult(new File("D:\\valmiki\\THN_bookingAPI\\THNAddreservation"+df2.format(dateobj2)+".xml"));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(domSource, streamResult);
        System.out.println("XML file updated successfully");
        
        File file = new File("D:\\valmiki\\THN_bookingAPI\\THNAddreservation"+df2.format(dateobj2)+".xml");
		//InputStream inputStream = new FileInputStream("");
        Reader fileReader = new FileReader(file);
        BufferedReader bufReader = new BufferedReader(fileReader);
        StringBuilder sb = new StringBuilder();
        String line = bufReader.readLine();
        while( line != null)
        { 
        	sb.append(line).append("\n"); 
        	line = bufReader.readLine(); 
        }

        String xml2String = sb.toString();
        System.out.println("XML to String using BufferedReader : ");
        System.out.println(xml2String);
        
        
        
        org.json.JSONObject jsonObj = XML.toJSONObject(xml2String);
        
        RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/xml");

		Response resp=request.body(xml2String.toString()).post("https://paymentsdev.useross.com.au/api/HotelNetworkNotif/HotelNetworkBookings");
		
		System.out.println(resp.getBody().asString());
		
		int sc=resp.getStatusCode();
		
		Assert.assertEquals(200, sc);
		
		System.out.println("Status code is "+sc);
		
		System.out.println("The Hotel Network Add booking is done");

		
	}

}
