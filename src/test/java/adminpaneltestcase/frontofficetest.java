package adminpaneltestcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hms.base.testbase;
import hms.pages.Loginpage;
import hms.pages.dashboardPage;
import hms.pages.frontoffice;

public class frontofficetest extends testbase {
	Loginpage objlog;
	dashboardPage objdash;
	frontoffice objofc;
	
	
	public frontofficetest() {
		super();
		
	}
@BeforeMethod
public void setup() {
	initialization();
	objlog=new Loginpage();
	objdash=objlog.loggin(pop.getProperty("username"), pop.getProperty("password"));
	objofc=objdash.frontoffice(); 
}
@Test
public void visitorpage() {
	Assert.assertTrue(objofc.verifyFO());
	objofc.clickvisitor();

}

@AfterMethod
public void teardoen() {
	driver.close();
}
}
 