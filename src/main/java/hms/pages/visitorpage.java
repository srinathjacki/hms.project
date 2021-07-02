package hms.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hms.base.testbase;
import hms.utility.CommonUtility;
import hms.utility.Datepicker;

public class visitorpage extends testbase{
	Datepicker dp=new Datepicker();
@FindBy (xpath="//h3[text()='Visitor List']")WebElement vtitle;
@FindBy (xpath="//a[contains(text(),'Add Visitor')]")WebElement AVbutton;
@FindBy (xpath="//*[@id=\"formadd\"]/div[1]/div[1]/div[1]/div/select")WebElement drpdwn;
@FindBy (xpath="//*[@id=\"formadd\"]/div[1]/div[1]/div[2]/div/input")WebElement name;
@FindBy (xpath="//*[@id='formadd']/div[1]/div[2]/div[1]/div/input")WebElement phonetxtbox;
@FindBy (xpath="//*[@id=\"formadd\"]/div[1]/div[2]/div[2]/div/input")WebElement ID;
@FindBy (css="form#formadd>div>div>div>div>input[name='pepples']")WebElement NOP;
@FindBy (xpath="//*[@id='description']") WebElement note;
@FindBy (xpath="//*[@id=\"date\"]") WebElement date;
@FindBy(xpath="//*[@id='formadd']/div[1]/div[6]/div/div/input")WebElement vupload;

public visitorpage() {
	
	PageFactory.initElements(driver, this);
}
public boolean verifyvtitile() {
	
	return vtitle.isDisplayed();
	
}
public void addvisitor() {
	
	AVbutton.click();
	
}
public void visitorfield(String drppp, String nam,String idcard,String nop,String notee ,String phone,String datee ) {
	Select sdrp=new Select(drpdwn);
    sdrp.selectByVisibleText(drppp);
    phonetxtbox.sendKeys(phone);
	 name.sendKeys(nam);
	 ID.sendKeys(idcard);
	 NOP.sendKeys(nop);
	 note.sendKeys(notee);
	date.click();
	dp.datpicker(datee);
	 CommonUtility.mouseclick(vupload);
	 String floc="D:\\punisher.jpg";
	 CommonUtility.upload(floc);

	
	}
}

	
	
	


