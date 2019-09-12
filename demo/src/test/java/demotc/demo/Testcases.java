package demotc.demo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import appmodule.AddRooms;
import appmodule.Booking;
import appmodule.Connection;
import appmodule.Forgotpassword;
import appmodule.Inventory;
import appmodule.Login_Logout;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Commonfunction;
import utility.ConfigReader;
import utility.CustomListener;


//@Listeners(CustomListener.class)
public class Testcases extends Commonfunction{
		
		@BeforeClass //we can also use @BeforeMethod
		@Parameters("browser")
		public void setup(String browser) throws Exception
		{
			logger.info("Starting Application");
			Initialize(browser);
			
		}
		
		@Test
		public void loginandlogout() throws Exception
		{
			logger=report.createTest("Login and Logout USEROSS");
			Login_Logout.loginandlogoutaction(driver);
			
			logger=report.createTest("Forgot password");
			Forgotpassword.forgotpasswordaction(driver);
			
			//Rememberme.remembermeaction(driver);
			//Changepassword.changepasswordaction(driver);
			AddRooms.Addroomaction(driver);
			Connection.connection(driver);
			Booking.Addmanualbooking(driver);
			Inventory.inventoryaction(driver);
		}
		
		@AfterClass //we can also use @AfterMethod
		public void setupclosed()
		{
			driver.close();
		}
		
		@AfterMethod
		public void tearDownmethod(ITestResult result) throws Exception 
		{
			Reporter.log("Test is about to Run",true);
			
			if(result.getStatus()==ITestResult.FAILURE)
			{
				Reporter.log("Test FAILURE",true);
				//CommonHelper.captureScreenshot(driver);
				logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Commonfunction.failed(driver)).build());
			}
			report.flush();
		}

}
