package appmodule;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Excelunit;

public class Booking_com_Reservation {
	//Add to check monthname in inventory screen
	static String[] monthName = {"January", "February","March", "April", "May", "June", "July","August", "September", "October", "November","December"};
	
	//Add for Single room to store inventory of 14 days which is display in Inventory screen
	static String[] Singleroominventory = new String[14];
	
	//Add for Double room to store inventory of 14 days which is display in Inventory screen
	static String[] DoubleRoominventory = new String[14];
	
	//Add to get daye in single digits
	static DateFormat dateFormat = new SimpleDateFormat("d");
	
	//Created date object 
	static Date date = new Date();
	
	//variabale declare to get system date 
	static String systemdateandtime= dateFormat.format(date);
	
	//static int Singleresult = Integer.parseInt(systemdateandtime);
	//static int doubleresult = Integer.parseInt(systemdateandtime);
	
	//Add for THN channel room to store inventory of whole month which is display in THN inventory test site 
	static String[] THNSinglrinventory = new String[35];
	
	//Add for THN channel room to store inventory of whole month which is display in THN inventory test site
	static String[] THNDoubleinventory = new String[35];
	
	
	static Calendar cal = Calendar.getInstance();
	
	static String month = monthName[cal.get(Calendar.MONTH)];
	
	public static void Booking_comavaiabilitycompare(WebDriver driver) throws Exception
	{
		
		String testdate =driver.findElement(By.xpath("//*[@id='lstdate']/div[1]/a")).getText();
		System.out.println(testdate);
		//testdate=testdate.replaceAll("\n", "");
		String []aa=testdate.split("\n");
		
		System.out.println(aa[1]);
		//String v1 =testdate.substring(4,5);
		int Singleresult = Integer.parseInt(aa[1]);
		int doubleresult = Integer.parseInt(aa[1]);
		System.out.println("current date is " +Singleresult);
		
		List<WebElement> Roomcount=driver.findElements(By.xpath("//*[@id='inventorydata']/div"));
		int size=Roomcount.size();
		System.out.println(size);
		//for Single room
		for(int i=1;i<=size;i++)
		{
			String Roomname=driver.findElement(By.xpath("//*[@id='inventorydata']/div["+i+"]/div[1]/div/div[1]/h4/a")).getText();
			//*[@id="inventorydata"]/div[1]/div[1]/div/div[1]/h4/a
			
														 
			System.out.println(Roomname);
			if(Roomname.contains("Single Room"))
			{
				i=i-1;
				for(int Single=0;Single<=13;Single++)
				{
					
					Singleroominventory[Single] =driver.findElement(By.xpath("//*[@id='CurrentInventory_"+i+"_Date"+Single+"']")).getAttribute("value");
					
					//*[@id="CurrentInventory_1_Date0"]
					//*[@id="CurrentInventory_0_Date0"]
					
					System.out.println("value of  " + Single + " is " + Singleroominventory[Single]);
					
					//Excelunit.setexceldata(1, Single, Excelunit.excelpath, Singleroominventory[Single]);
					//*[@id="CurrentInventory_2_Date0"]
					
				}
				break;
			}
		}
		
		((JavascriptExecutor) driver).executeScript("window.open();");
		System.out.println("Navigating to Booking.com channel site");
		ArrayList arr= new ArrayList(driver.getWindowHandles());
		String pareant=arr.get(0).toString();
		String childewindow=arr.get(1).toString();
		driver.switchTo().window(childewindow);
		driver.get("https://account.booking.com/sign-in?op_token=EgVvYXV0aCJHChQ2Wjcyb0hPZDM2Tm43emszcGlyaBIJYXV0aG9yaXplGhpodHRwczovL2FkbWluLmJvb2tpbmcuY29tLyoCe31CBGNvZGUqDDDvp7j2yrQjOgBCAA");
		driver.findElement(By.id("loginname")).clear();
		driver.findElement(By.id("loginname")).sendKeys("useross_extranet");
		driver.findElement(By.xpath("//span[@class='bui-button__text']")).click();
		driver.findElement(By.id("password")).sendKeys("Budget14#");
		driver.findElement(By.xpath("//span[@class='bui-button__text']")).click();
		Thread.sleep(1000000);
		
	}

}
