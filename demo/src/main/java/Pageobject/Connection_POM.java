package Pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Connection_POM {
		
	@FindBy(how=How.XPATH,using="//*[@id='Connections']/a")
	public WebElement clickonconnection;
}
