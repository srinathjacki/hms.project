package adminpaneltestcase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hms.base.testbase;
import hms.pages.Loginpage;
import hms.pages.dashboardPage;
import hms.pages.frontoffice;
import hms.pages.visitorpage;
import hms.utility.ReadExcel;

public class visitortest extends testbase{
	Loginpage objlog;
	dashboardPage objdash;
	frontoffice objofc;
	visitorpage objv;
	public visitortest(){
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		objlog=new Loginpage();
		objdash=objlog.loggin(pop.getProperty("username"), pop.getProperty("password"));
		objofc=objdash.frontoffice();
		objv=objofc.clickvisitor();
	}
	@Test
	public void addvisitorclick() {
		Assert.assertTrue(objv.verifyvtitile());
		objv.addvisitor();
		
	}
	@DataProvider
	public Object [][] getvisdata(){
		Object[][] testdata=ReadExcel.getTestData("visitordata");
		
		return testdata;
		
	}
@Test(dataProvider="getvisdata")
public void enterfield(String drppp,String nam,String idcard,String nop,String notee ,String phone ,String datee) {
	objv.addvisitor();
	objv.visitorfield(drppp,nam,idcard,nop,notee,phone ,datee);
	
	}
			
	@AfterMethod
	public void teardown() {
		//driver.close();
	}
		
	
}


