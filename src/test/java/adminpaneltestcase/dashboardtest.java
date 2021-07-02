package adminpaneltestcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hms.base.testbase;
import hms.pages.Loginpage;
import hms.pages.dashboardPage;

public class dashboardtest  extends testbase{
	 Loginpage objlog;
	 dashboardPage objdash;
public dashboardtest() {
	super();
}
@BeforeMethod
public void setup() {
	initialization();
	objlog=new Loginpage();
   objdash=objlog.loggin(pop.getProperty("username"),pop.getProperty("password"));
}


@Test
public void dashtest() {
	Assert.assertTrue(objdash.verifytitle());
	objdash.frontoffice();
	
}

@AfterMethod
public void teardown()
{
	driver.close();
	}
}

