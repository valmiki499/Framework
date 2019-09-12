package appmodule;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Pageobject.Signup_POM;
import utility.Excelunit;

public class  Signup {
	
		public static String temppropertyID;
		public static String temppassword;
	public static void signupaction(WebDriver driver) throws Exception
	{
		
		
		Excelunit.configexcel(Excelunit.excelpath, "Property owner Sign up");
		String Propertyname=Excelunit.Getexceldata(1, 1);
		String NoofRooms=Excelunit.Getexceldata(2, 1);
		String Website=Excelunit.Getexceldata(3, 1);
		String phoneno=Excelunit.Getexceldata(4, 1);
		String propemail=Excelunit.Getexceldata(5, 1);
		String Fax=Excelunit.Getexceldata(6, 1);
		String postal=Excelunit.Getexceldata(7, 1);
		String Pms=Excelunit.Getexceldata(8, 1);
		String Country=Excelunit.Getexceldata(9, 1);
		String state=Excelunit.Getexceldata(10, 1);
		String city=Excelunit.Getexceldata(11, 1);
		String Address1=Excelunit.Getexceldata(12, 1);
		String Address2=Excelunit.Getexceldata(13, 1);
		String Hostname=Excelunit.Getexceldata(14, 1);
		String Mobile=Excelunit.Getexceldata(15, 1);
		String email=Excelunit.Getexceldata(16, 1);
		String password=Excelunit.Getexceldata(17, 1);
		temppassword=password;
		String confpassword=Excelunit.Getexceldata(18, 1);
		System.out.println(Propertyname);
		Signup_POM spom=PageFactory.initElements(driver, Signup_POM.class);
		spom.strclickonsignup.click();
		spom.strPropertyName.sendKeys(Propertyname);
		spom.strNoOfRooms.clear();
		spom.strNoOfRooms.sendKeys(NoofRooms);
		spom.strWebsite.sendKeys(Website);
		spom.strPhoneNo.sendKeys(phoneno);
		spom.strPropertyEmail.sendKeys(propemail);
		spom.strFaxNo.sendKeys(Fax);
		spom.strPostCode.sendKeys(postal);
		
		//to check list of value in drop-down and compare with excel data and if match then select it
		Select opms= new Select(spom.strdrpPMS);
		List<WebElement> elementcount= opms.getOptions();
		int isize=elementcount.size();
		for(int i =0; i<isize ; i++ )
		{
			String spmsdropreadvalue=elementcount.get(i).getText();
			if(spmsdropreadvalue.equals(Pms))
			{
				opms.selectByIndex(i);
				break;
			}
		}
		
		Select ocountry= new Select(spom.strdrpCountry);
		List<WebElement> councount= ocountry.getOptions();
		int consize=councount.size();
		for(int i =0; i<consize ; i++ )
		{
			String scontryvalue=councount.get(i).getText();
			if(scontryvalue.equals(Country))
			{
				ocountry.selectByIndex(i);
				break;
			}
		}
		
		Thread.sleep(2000);
		Select ostate= new Select(spom.strdrpState);
		List<WebElement> statecount= ostate.getOptions();
		int statesize=statecount.size();
		for(int i =0; i<statesize ; i++ )
		{
			String statevalue=statecount.get(i).getText();
			System.out.println(statevalue);
			if(statevalue.equals(state))
			{
				ostate.selectByIndex(i);
				break;
			}
		}
		
		spom.strtxtCity.sendKeys(city);
		spom.strAddressLine1.sendKeys(Address1);
		spom.strAddressLine2.sendKeys(Address2);
		spom.strtEmail.sendKeys(email);
		spom.strtxtHostName.sendKeys(Hostname);
		spom.strttxtMobileNo.sendKeys(Mobile);
		spom.strtxtPassword.sendKeys(password);
		spom.strtxtConfirmPassword.sendKeys(confpassword);
		//this thread is for to Enter Captcha manually
		Thread.sleep(10000);
		
		spom.strbtnSubmit.click();
		
		((JavascriptExecutor) driver).executeScript("window.open();");
		ArrayList arr= new ArrayList(driver.getWindowHandles());
		String a=arr.get(1).toString();
		driver.switchTo().window(a);
		driver.navigate().to("https://outlook.office.com/owa/?path=/mail/inbox");
		driver.findElement(By.id("i0116")).sendKeys("valmiki.k@intelegain.com");
		driver.findElement(By.id("idSIButton9")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("i0118")).clear();
		driver.findElement(By.id("i0118")).sendKeys("krishna@1990");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		driver.findElement(By.xpath("//*[@id='idSIButton9']")).click();
		Thread.sleep(2000);
		boolean ispresent =driver.findElement(By.id("idBtn_Back")).isDisplayed();
		if(ispresent)
		{
			driver.findElement(By.id("idBtn_Back")).click();
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='_ariaId_25']")).click();
		//*[@id="idSIButton9"]
		Thread.sleep(10000);
		
		//driver.findElement(By.xpath("//*[contains(text(),'Property Sign Up - Property')]")).click();
		
		//*[@id="_ariaId_29"]/div[2]/div[4]/div[3]/span[1]/span
		//*[@id="_ariaId_187"]/div[2]
		//*[@id="_ariaId_172"]/div[2]
		//*[@id="_ariaId_87"]/div[2]/div[4]/div[3]/span[1]/span
		boolean linkpresent =driver.findElement(By.xpath("//span[contains(text(),'Property Sign Up - Property')]")).isDisplayed();
		if(linkpresent)
		{
			driver.findElement(By.xpath("//span[contains(text(),'Property Sign Up - Property')]")).click();
			
		}
		Thread.sleep(10000);
		
		String propertyID=driver.findElement(By.xpath("//*[@id='Item.MessageUniqueBody']/div/div/div/div/table/tbody/tr/td/ul/li[1]")).getText();
		System.out.println(propertyID);
		temppropertyID=propertyID;
		//driver.findElement(By.xpath("//*[@id='Item.MessageUniqueBody']/div/div/div/div/table[2]/tbody/tr/td/ul/li[6]/a[2]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Activation')]")).click();
		driver.close();
		//ArrayList arr2= new ArrayList(driver.getWindowHandles());
		//System.out.println(arr2);
		for(String windo : driver.getWindowHandles())
		{
			System.out.println(windo);
			driver.switchTo().window(windo);
			
		}
		Thread.sleep(5000);
		boolean buttonpresent =driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div/div/div[1]/div[2]/div/a")).isDisplayed();
		if(buttonpresent)
		{
			driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div/div/div[1]/div[2]/div/a")).click();
			System.out.println("Account Activated..........");
		}
		else
		{
			driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div/div/div/div[2]/div/a")).click();
			System.out.println("Account already Activated..........");
		}
									 
		
		
		
		System.out.println("Signup functionality pass..........");
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
