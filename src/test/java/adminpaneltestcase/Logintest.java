package adminpaneltestcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hms.base.testbase;
import hms.pages.Loginpage;

public class Logintest extends testbase {
	 Loginpage objlog;
public Logintest() {
	super();
}

@BeforeMethod
public void setup() {
	initialization();
	objlog=new Loginpage();
}
@Test
public void verifylogo()
{
objlog.verifylogo();
Assert.assertTrue(objlog.verifylogo());
}
@Test
public void verifytitle() {
	String actual =objlog.verifytitle(); 
	String expected="Smart Hospital : Hospital Management System";
	Assert.assertEquals(actual,expected );
}
@Test
public void logintest() {
	objlog.loggin(pop.getProperty("username"), pop.getProperty("password"));
	
}
@AfterMethod
public void close()
{
	driver.close();
}
}


