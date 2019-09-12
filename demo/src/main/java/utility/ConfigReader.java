package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	Properties pro;
	
	public ConfigReader()
	{
		
		try {
			File src=new File("D:\\valmiki\\Selenium program New\\demo\\configuration\\config.property");
			FileInputStream fi = new FileInputStream(src);
			pro= new Properties();
			pro.load(fi);
			
		
		} 
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is ==" + e.getMessage());
		}
		
		
	}
	public String getchromepath()
	{
		return pro.getProperty("chromeDriver");
		
	}
	
	public String getFirefoxpath()
	{
		return pro.getProperty("Firefoxdriver");
		
		
	}
	
	public String getURl()
	{
		return pro.getProperty("URL");
		
	}
	
	public  String getExcelpath()
	{
		return pro.getProperty("Excelpath");
		
	}
	
}
