package appmodule;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Channelconnection {
	
	static String connotherproper; 
	public static void booknow(WebDriver driver)
	{
		driver.findElement(By.id("select2-chosen-1")).click();
		driver.findElement(By.id("s2id_autogen1_search")).sendKeys("Book Now");
		driver.findElement(By.id("s2id_autogen1_search")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		driver.findElement(By.xpath("//*[@id='select2-chosen-1']")).click();
		Select os1= new Select(driver.findElement(By.id("lstRoomTypes_0__ChannelRoomTypeId")));
		os1.selectByVisibleText("Enable");
		driver.findElement(By.xpath("//*[@id='select2-chosen-2']")).click();
		Select os2= new Select(driver.findElement(By.id("lstRoomTypes_1__ChannelRoomTypeId")));
		os2.selectByVisibleText("Enable");
		driver.findElement(By.xpath("//*[@id='select2-chosen-3']")).click();
		Select os3= new Select(driver.findElement(By.id("lstRoomTypes_2__ChannelRoomTypeId")));
		os3.selectByVisibleText("Enable");
		
		driver.findElement(By.xpath("//button[contains(text(),'Connect & Sync')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		
	}
	
	public static void bookingcom(WebDriver driver) throws Exception
	{
		Thread.sleep(3000);
		driver.findElement(By.id("select2-chosen-1")).click();
		driver.findElement(By.id("s2id_autogen1_search")).sendKeys("Booking.com");
		driver.findElement(By.id("s2id_autogen1_search")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("OtherDetails")).clear();
		driver.findElement(By.id("OtherDetails")).sendKeys("407888");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		connotherproper = driver.findElement(By.xpath("html/body/div[5]/h5")).getText();
		if(connotherproper.contains("This channel property is already connected with other property"))
		{
			driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
			
		}
		else
		{
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		
		List<WebElement> ls=driver.findElements(By.xpath("//*[@class='connections_panel1_left']"));
		int connections_panel_count=ls.size();
		System.out.println(connections_panel_count);
		
		for(int i=0;i<connections_panel_count;i++)
		{
			int j=i+2;
			String Roomname=driver.findElement(By.xpath("//*[@id='dvConnectSync']/div[2]/div["+j+"]/div/div[1]/div/div/div[2]/label")).getText();
			
			//*[@id="dvConnectSync"]/div[2]/div[2]/div/div[1]/div/div/div[2]/label
			//*[@id="dvConnectSync"]/div[2]/div[2]/div/div[1]/div/div/div[2]/label
			//*[@id="dvConnectSync"]/div[2]/div[3]/div/div[1]/div/div/div[2]/label
			System.out.println(Roomname);
			if(Roomname.contains("Single Room"))
			{
				Select os=new Select(driver.findElement(By.xpath("//*[@id='lstRoomTypes_"+i+"__ChannelRoomTypeId']")));
				os.selectByValue("40788801");
				
				System.out.println("Single Room selected");
				break;
			}
			
		}
		
		for(int i=0;i<connections_panel_count;i++)
		{
			int j=i+2;
			String Roomname=driver.findElement(By.xpath("//*[@id='dvConnectSync']/div[2]/div["+j+"]/div/div[1]/div/div/div[2]/label")).getText();
			//*[@id="dvConnectSync"]/div[2]/div[2]/div/div[1]/div/div/div[2]/label
			//*[@id="dvConnectSync"]/div[2]/div[3]/div/div[1]/div/div/div[2]/label
			System.out.println(Roomname);
			if(Roomname.contains("Double Room"))
			{
			
				Select os=new Select(driver.findElement(By.xpath("//*[@id='lstRoomTypes_"+i+"__ChannelRoomTypeId']")));
				os.selectByValue("40788802");
				
				System.out.println("Double Room selected");
				break;
			}
			
			
			
		}
		
		for(int i=0;i<connections_panel_count;i++)
		{
			System.out.println("Twin Room " + connections_panel_count);
			int j=i+2;
			String Roomname=driver.findElement(By.xpath("//*[@id='dvConnectSync']/div[2]/div["+j+"]/div/div[1]/div/div/div[2]/label")).getText();
			//*[@id="dvConnectSync"]/div[2]/div[2]/div/div[1]/div/div/div[2]/label
			//*[@id="dvConnectSync"]/div[2]/div[3]/div/div[1]/div/div/div[2]/label
			System.out.println(Roomname);
			if(Roomname.contains("Twin Room"))
			{
			
				Select os=new Select(driver.findElement(By.xpath("//*[@id='lstRoomTypes_"+i+"__ChannelRoomTypeId']")));
				os.selectByValue("40788812");
				
				System.out.println("Twin Room selected");
				break;
			}
			
		
		
//		driver.findElement(By.xpath("//*[@id='select2-chosen-1']")).click();
//		Select os1= new Select(driver.findElement(By.id("lstRoomTypes_0__ChannelRoomTypeId")));
//		os1.selectByVisibleText("Enable");
//		driver.findElement(By.xpath("//*[@id='select2-chosen-2']")).click();
//		Select os2= new Select(driver.findElement(By.id("lstRoomTypes_1__ChannelRoomTypeId")));
//		os2.selectByVisibleText("Enable");
//		driver.findElement(By.xpath("//*[@id='select2-chosen-3']")).click();
//		Select os3= new Select(driver.findElement(By.id("lstRoomTypes_2__ChannelRoomTypeId")));
//		os3.selectByVisibleText("Enable");
		
			
		
		}
		driver.findElement(By.xpath("//button[contains(text(),'Connect & Sync')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		}
	}
	
	public static void Hotelnetworkchannel(WebDriver driver) throws Exception
	{
		
		Thread.sleep(3000);
		driver.findElement(By.id("select2-chosen-1")).click();
		driver.findElement(By.id("s2id_autogen1_search")).sendKeys("Hotel Network");
		driver.findElement(By.id("s2id_autogen1_search")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("OtherDetails")).clear();
		driver.findElement(By.id("OtherDetails")).sendKeys("6873");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		connotherproper = driver.findElement(By.xpath("html/body/div[5]/h5")).getText();
		if(connotherproper.contains("This channel property is already connected with other property"))
		{
			driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
			
		}
		else
		{
		
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		
		List<WebElement> ls=driver.findElements(By.xpath("//*[@class='connections_panel1_left']"));
		int connections_panel_count=ls.size();
		System.out.println(connections_panel_count);
		
		for(int i=0;i<connections_panel_count;i++)
		{
			int j=i+2;
			String Roomname=driver.findElement(By.xpath("//*[@id='dvConnectSync']/div[2]/div["+j+"]/div/div[1]/div/div/div[2]/label")).getText();
			//*[@id="dvConnectSync"]/div[2]/div[2]/div/div[1]/div/div/div[2]/label
			//*[@id="dvConnectSync"]/div[2]/div[3]/div/div[1]/div/div/div[2]/label
			System.out.println(Roomname);
			if(Roomname.contains("Single Room"))
			{
				Select os=new Select(driver.findElement(By.xpath("//*[@id='lstRoomTypes_"+i+"__ChannelRoomTypeId']")));
				os.selectByVisibleText("CM Test Room");
				
				System.out.println("Single Room selected");
				break;
			}
			
		}
		
		for(int i=0;i<connections_panel_count;i++)
		{
			int j=i+2;
			String Roomname=driver.findElement(By.xpath("//*[@id='dvConnectSync']/div[2]/div["+j+"]/div/div[1]/div/div/div[2]/label")).getText();
			//*[@id="dvConnectSync"]/div[2]/div[2]/div/div[1]/div/div/div[2]/label
			//*[@id="dvConnectSync"]/div[2]/div[3]/div/div[1]/div/div/div[2]/label
			System.out.println(Roomname);
			if(Roomname.contains("Double Room"))
			{
				Select os=new Select(driver.findElement(By.xpath("//*[@id='lstRoomTypes_"+i+"__ChannelRoomTypeId']")));
				os.selectByVisibleText("CM Test Room 2");
				
				System.out.println("Double Room selected");
				break;
			}
			
		}
		driver.findElement(By.xpath("//button[contains(text(),'Connect & Sync')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		}
	}
	
	public static void Lidochannel(WebDriver driver) throws Exception
	{
		
		Thread.sleep(3000);
		driver.findElement(By.id("select2-chosen-1")).click();
		driver.findElement(By.id("s2id_autogen1_search")).sendKeys("Lido");
		driver.findElement(By.id("s2id_autogen1_search")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("OtherDetails")).clear();
		driver.findElement(By.id("OtherDetails")).sendKeys("9525");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		connotherproper = driver.findElement(By.xpath("html/body/div[5]/h5")).getText();
		if(connotherproper.contains("This channel property is already connected with other property"))
		{
			driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
			
		}
		else
		{
		
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		
		List<WebElement> ls=driver.findElements(By.xpath("//*[@class='connections_panel1_left']"));
		int connections_panel_count=ls.size();
		System.out.println(connections_panel_count);
		
		for(int i=0;i<connections_panel_count;i++)
		{
			int j=i+2;
			String Roomname=driver.findElement(By.xpath("//*[@id='dvConnectSync']/div[2]/div["+j+"]/div/div[1]/div/div/div[2]/label")).getText();
			//*[@id="dvConnectSync"]/div[2]/div[2]/div/div[1]/div/div/div[2]/label
			//*[@id="dvConnectSync"]/div[2]/div[3]/div/div[1]/div/div/div[2]/label
			System.out.println(Roomname);
			if(Roomname.contains("Single Room"))
			{
				Select os=new Select(driver.findElement(By.xpath("//*[@id='lstRoomTypes_"+i+"__ChannelRoomTypeId']")));
				os.selectByValue("31028");
				
				System.out.println("Single Room selected");
				break;
			}
			
		}
		
		for(int i=0;i<connections_panel_count;i++)
		{
			int j=i+2;
			String Roomname=driver.findElement(By.xpath("//*[@id='dvConnectSync']/div[2]/div["+j+"]/div/div[1]/div/div/div[2]/label")).getText();
			//*[@id="dvConnectSync"]/div[2]/div[2]/div/div[1]/div/div/div[2]/label
			//*[@id="dvConnectSync"]/div[2]/div[3]/div/div[1]/div/div/div[2]/label
			System.out.println(Roomname);
			if(Roomname.contains("Double Room"))
			{
				Select os=new Select(driver.findElement(By.xpath("//*[@id='lstRoomTypes_"+i+"__ChannelRoomTypeId']")));
				os.selectByValue("31029");
				
				System.out.println("Double Room selected");
				break;
			}
			
		}
		driver.findElement(By.xpath("//button[contains(text(),'Connect & Sync')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		}
	}

	public static void Expediachannel(WebDriver driver) throws Exception
	
	{
		
		Thread.sleep(3000);
		driver.findElement(By.id("select2-chosen-1")).click();
		driver.findElement(By.id("s2id_autogen1_search")).sendKeys("Expedia");
		driver.findElement(By.id("s2id_autogen1_search")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("OtherDetails")).clear();
		driver.findElement(By.id("OtherDetails")).sendKeys("16637886");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		connotherproper = driver.findElement(By.xpath("html/body/div[5]/h5")).getText();
		if(connotherproper.contains("This channel property is already connected with other property"))
		{
			driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		}
		else
		{
		
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		
		List<WebElement> ls=driver.findElements(By.xpath("//*[@class='connections_panel1_left']"));
		int connections_panel_count=ls.size();
		System.out.println(connections_panel_count);
		
		for(int i=0;i<connections_panel_count;i++)
		{
			int j=i+2;
			String Roomname=driver.findElement(By.xpath("//*[@id='dvConnectSync']/div[2]/div["+j+"]/div/div[1]/div/div/div[2]/label")).getText();
			//*[@id="dvConnectSync"]/div[2]/div[2]/div/div[1]/div/div/div[2]/label
			//*[@id="dvConnectSync"]/div[2]/div[3]/div/div[1]/div/div/div[2]/label
			System.out.println(Roomname);
			if(Roomname.contains("Single Room"))
			{
				Select os=new Select(driver.findElement(By.xpath("//*[@id='lstRoomTypes_"+i+"__ChannelRoomTypeId']")));
				os.selectByValue("202247070");
				
				System.out.println("Single Room selected");
				break;
			}
			
		}
		
		for(int i=0;i<connections_panel_count;i++)
		{
			int j=i+2;
			String Roomname=driver.findElement(By.xpath("//*[@id='dvConnectSync']/div[2]/div["+j+"]/div/div[1]/div/div/div[2]/label")).getText();
			//*[@id="dvConnectSync"]/div[2]/div[2]/div/div[1]/div/div/div[2]/label
			//*[@id="dvConnectSync"]/div[2]/div[3]/div/div[1]/div/div/div[2]/label
			System.out.println(Roomname);
			if(Roomname.contains("Double Room"))
			{
				Select os=new Select(driver.findElement(By.xpath("//*[@id='lstRoomTypes_"+i+"__ChannelRoomTypeId']")));
				os.selectByValue("219611548");
				
				System.out.println("Double Room selected");
				break;
			}
			
		}
		
		for(int i=0;i<connections_panel_count;i++)
		{
			int j=i+2;
			String Roomname=driver.findElement(By.xpath("//*[@id='dvConnectSync']/div[2]/div["+j+"]/div/div[1]/div/div/div[2]/label")).getText();
			//*[@id="dvConnectSync"]/div[2]/div[2]/div/div[1]/div/div/div[2]/label
			//*[@id="dvConnectSync"]/div[2]/div[3]/div/div[1]/div/div/div[2]/label
			System.out.println(Roomname);
			if(Roomname.contains("Twin Room"))
			{
				Select os=new Select(driver.findElement(By.xpath("//*[@id='lstRoomTypes_"+i+"__ChannelRoomTypeId']")));
				os.selectByValue("219610052");
				
				System.out.println("Twin Room selected");
				break;
			}
			
		}
		driver.findElement(By.xpath("//button[contains(text(),'Connect & Sync')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		}
	}
}
