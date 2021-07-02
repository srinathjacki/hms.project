package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hms.base.testbase;

public class IPDpage  extends testbase{
     
	
	@FindBy (css="ul.sidebar-menu.verttop>li:nth-of-type(3)")WebElement ipdbutn;
	@FindBy  WebElement ipdtitle;
	@FindBy (css="div.box-tools.pull-right>a#addp.btn.btn-primary.btn-sm")WebElement addpbtn;
	@FindBy (xpath="//h4[text()='Add Patient']")WebElement addptitle;
	@FindBy	(css="input#name.form-control") WebElement namefield;
	@FindBy (xpath="//input[@name='guardian_name']") WebElement gnamefield;
	@FindBy (css="#formadd > div.row.row-eq > div.col-lg-8.col-md-8.col-sm-8 > div > div.col-md-2 > div > select")WebElement genderfield;
	@FindBy (css="select#marital_status.form-control")WebElement mstatusfield;
	
	
public IPDpage() {
	PageFactory.initElements(driver, this);
}	
public void IPDclick() {
	ipdbutn.click();
}
public boolean verifyipdtitle() {
	waitforElementvisible(ipdtitle);
	return ipdtitle.isDisplayed();
	
}
public void clickaddpatient() {
	waitforElementvisible(addpbtn);
	addpbtn.click();
}

public boolean verifyaddptitle() {
	waitforElementvisible(addptitle);
	return addptitle.isDisplayed();
	
}

public void enterfield(String name,String gname,String gender, String maritalstatus) {
	
	namefield.sendKeys(name);
	gnamefield.sendKeys(gname);
	Select sdrp=new Select(genderfield);
	sdrp.selectByVisibleText(gender);
	Select ms=new Select (mstatusfield);
	ms.selectByVisibleText(maritalstatus);
	
			
}
}   











