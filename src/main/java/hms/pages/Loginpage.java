package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hms.base.testbase;

public class Loginpage  extends testbase{

@FindBy(css="div.form-top-left>img")WebElement Hmslogo;
@FindBy(css="div.form-top-right>i.fa.fa-key")WebElement Keylogo;
@FindBy(id="email") WebElement uname;
@FindBy(id="password") WebElement pass;
@FindBy(className="btn")WebElement buttn;
@FindBy(className="forgot")WebElement fpass;
public Loginpage()
{
PageFactory.initElements(driver, this);

}
public String verifytitle() {
	return driver.getTitle();
}

public boolean verifylogo() {
	return Hmslogo.isDisplayed();

	
}
public dashboardPage loggin(String username,String password) {
	
	uname.sendKeys(username);
	pass.sendKeys(password);
	buttn.click();
	return new dashboardPage(); 
}
}
