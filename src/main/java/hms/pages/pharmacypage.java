package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hms.base.testbase;

public class pharmacypage extends testbase{
@FindBy (css="div.box-header.with-border>h3") WebElement ptitle;
@FindBy (css="div.box-tools.pull-right>a:nth-of-type(1)") WebElement generatebillbutt;
@FindBy (xpath="//h4[text()='Generate Bill']")WebElement gbtit;
@FindBy (css="input#billno.form-control") WebElement billno;
@FindBy (css="input.form-control.datetime")WebElement cale;
@FindBy (xpath="//select[@name='medicine_category_id[]']") WebElement medcat;
@FindBy (css="input#patient_name.form-control")WebElement patname;

public pharmacypage() {
	PageFactory.initElements(driver, this);
}

public boolean verifyphartitle() {
	waitforElementvisible(ptitle);
	return ptitle.isDisplayed();
}
public void generatebillpharmacy(String data[]) {
  generatebillbutt.click();	
  waitforElementvisible(gbtit);
  billno.sendKeys(data[0]);
  cale.sendKeys(data[1]);
  Select category=new Select(medcat);
  category.selectByVisibleText(data[2]);
  patname.sendKeys(data[3]);
  
}

}