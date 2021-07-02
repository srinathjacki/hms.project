 package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hms.base.testbase;

public class dashboardPage extends testbase{
   @FindBy (css="li.dropdown.user-menu>a")WebElement profile;
   @FindBy (xpath="//h4[text()='Super Admin']")WebElement usernamelabel;
   @FindBy (css="ul.sidebar-menu>li>a>i.fas.fa-dungeon")WebElement frontoffice;
   @FindBy (css="ul.sidebar-menu.verttop>li:nth-of-type(3)")WebElement ipdbutn;
   @FindBy (css="ul.sidebar-menu.verttop>li:nth-of-type(4)") WebElement pharmacybtn;
   
   
   
   public dashboardPage() {
	   PageFactory.initElements(driver, this);
   }
   public boolean verifytitle() {
	profile.click();
	waitforElementvisible(usernamelabel );
	boolean label=usernamelabel.isDisplayed();
	   
	   return label;   
   }
   //menu access
   public frontoffice frontoffice()
   {
	   frontoffice.click();
	return new frontoffice();
   }
   public IPDpage IPDclick() {
		ipdbutn.click();
		return new IPDpage();
	}
   public pharmacypage pharmacyclick() {
	   pharmacybtn.click();
	return new pharmacypage();
	
	
	   
   }
 
   

}