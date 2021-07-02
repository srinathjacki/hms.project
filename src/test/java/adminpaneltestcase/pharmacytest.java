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
import hms.pages.pharmacypage;
import hms.utility.ReadExcel;

public class pharmacytest extends testbase {

	Loginpage logp;
	dashboardPage dashp;
	pharmacypage pharp;
	public pharmacytest(){
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		logp=new Loginpage();
		dashp=logp.loggin(pop.getProperty("username"), pop.getProperty("password"));
		pharp=dashp.pharmacyclick();
		
	}
@AfterMethod
public void teardown() {
	driver.close();
}

@Test
public void billbuttonclick() {
	dashp.pharmacyclick();
	Assert.assertTrue(pharp.verifyphartitle());
}
@DataProvider
public Object[][] getphardata(){
Object[][] testdata=ReadExcel.getTestData("pharmacy");
	return testdata;
}


@Test(dataProvider="getphardata")
public void enterfields(String args[]) {
	
	pharp.generatebillpharmacy(args);
}
	























}

