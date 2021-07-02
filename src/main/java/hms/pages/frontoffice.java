package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hms.base.testbase;

public class frontoffice extends testbase {

	@FindBy (xpath="//h3[text()='Appointment Details']")WebElement FOtitle;
	@FindBy (xpath="//a[contains(text(),'Visitor Book')]")WebElement vbutton;
	
	public frontoffice() {
		PageFactory.initElements(driver, this);
	}
	public boolean verifyFO() {
		
		return FOtitle.isDisplayed();
		
		
	}
	public visitorpage clickvisitor() {
	
		vbutton.click();
		return new visitorpage();
	}
	
}
