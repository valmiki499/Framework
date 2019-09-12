package utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Commonfunction {
	
	static ConfigReader config= new ConfigReader();
	public ExtentReports report; 
	public ExtentTest logger;
	ExtentHtmlReporter extents;
	
	public Commonfunction()
	{
		
		Reporter.log("Setting up reports and Test is getting ready",true);
		extents= new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Repots/+"+Commonfunction.getCurrentdateandTime()+".html"));
		report= new ExtentReports();
		report.attachReporter(extents);
		Reporter.log("Setting done - Test can be start",true);
	}
	
	
	public static WebDriver driver;
	
	
	public static void waitforloader(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,5000L);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public static void Action(WebDriver driver,WebElement element)
	{
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public static void Webdriverwait_forall(WebDriver driver, WebElement webele)
	{
		
		WebDriverWait waitTransaction=new WebDriverWait(driver, 10);
		waitTransaction.until(ExpectedConditions.elementToBeClickable(webele)).click();
	}
	
	public static  boolean isAlertPresent(WebDriver driver)
	{
		try
		{
			driver.switchTo().alert();
			return true;

		}
		catch(NoAlertPresentException ex)
		{
			System.out.println(ex);
			return false;
		}
	}
	
	public static void Initialize(String browser) throws Exception
	{
		
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.out.println(config.getchromepath());
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", config.getchromepath());
			ChromeOptions opt= new ChromeOptions();
			opt.addArguments("--window-size=1920,1080");
			driver= new ChromeDriver(opt);
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.out.println(config.getFirefoxpath());
			System.setProperty("webdriver.gecko.driver", config.getFirefoxpath());
			driver = new FirefoxDriver();
		}
		
			
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//driver.manage().window().setSize(new Dimension(1024,768));
	driver.get(config.getURl());
	driver.findElement(By.xpath("//*[@id='myNavbar']/ul[2]/li[2]/a")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='propertyID']")).click();//*[@id="propertyID"]
	}
	
	public static String failed(WebDriver driver)
	{
		TakesScreenshot ts=((TakesScreenshot)driver);
		String Screenshotpath=System.getProperty("user.dir") +"/Screenshots/"+ getCurrentdateandTime() +".png";
		try {
			File source= ts.getScreenshotAs(OutputType.FILE);
			File des= new File("D:\\valmiki\\Selenium program New\\demo\\TSFailErrorscreenshot\\"+getCurrentdateandTime()+".png");
			FileUtils.copyFile(source, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return Screenshotpath;
		
		
	}
	
	public static String getCurrentdateandTime()
	{
		DateFormat customformat= new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentdate= new Date();
		return customformat.format(currentdate);
		
		
	}
}
