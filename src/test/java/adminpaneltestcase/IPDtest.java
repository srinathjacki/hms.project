package adminpaneltestcase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hms.base.testbase;
import hms.pages.IPDpage;
import hms.pages.Loginpage;
import hms.pages.dashboardPage;
import hms.utility.ReadExcel;

public class IPDtest extends testbase{
       Loginpage objlog;
       dashboardPage objdash;
       IPDpage objipd;
 public IPDtest() {
	 super();
 }
	@BeforeClass
	public void setup() {
		initialization();
		objlog=new Loginpage();
		objdash=objlog.loggin(pop.getProperty("username"), pop.getProperty("password"));
		objipd=objdash.IPDclick();
	}
	
	@AfterClass
	public void teardown() {
		driver.close();
	}
	
	@Test
	public void clickaddipdpatient() {
		
		objipd.clickaddpatient();
		Assert.assertTrue(objipd.verifyaddptitle());
		
	}
	@DataProvider
	public Object[][] getipddata(){
		Object[][] testdata=ReadExcel.getTestData("ipd");
		return testdata;
	
	}
	
	@Test(dataProvider="getipddata")
	public void enterfields(String name,String gname, String gender ,String maritalstatus ) {
		objipd.enterfield(name,gname,gender,maritalstatus);
	}
}
