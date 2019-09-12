package appmodule;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Pageobject.Inventory_POM;
import Pageobject.Login_Logout_POM;
import utility.Commonfunction;
import utility.Excelunit;

public class Inventory {
	
	
	
	public static void inventoryaction(WebDriver driver) throws Exception
	{
		Excelunit.configexcel(Excelunit.excelpath, "THN inventory check");
		Login_Logout_POM Login=PageFactory.initElements(driver, Login_Logout_POM.class);
		Login.logincredentials("10104", "Test123");
		Thread.sleep(3000);
		
		if(Commonfunction.isAlertPresent(driver))
		{
			Alert art=driver.switchTo().alert();
			String alertText = art.getText();
			System.out.println(alertText +"Occured.......driver closed");
			art.accept();
			driver.close();
		}
		else
		{
			Inventory_POM inv=PageFactory.initElements(driver, Inventory_POM.class);
			inv.clickoninventory.click();
			Thread.sleep(5000);
			THNAddbookingBN.THNaddbooking(driver);
			THNModifybookingBN.THNModifybooking(driver);
			inv.clickoninventory.click();
			THNcompare.THNavaiabilitycompare(driver);
			Booking_com_Reservation.Booking_comavaiabilitycompare(driver);
		}
	}

}
