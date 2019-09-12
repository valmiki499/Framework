package Pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Rememberme_POM {
	
	@FindBy(how=How.XPATH,using="//label[@id='loginArra']")
	public WebElement strrememberme;

}
