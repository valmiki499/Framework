package Pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Inventory_POM {
	
	@FindBy(how=How.XPATH,using="//*[@id='Inventory']/a")
	public WebElement clickoninventory; 

}
