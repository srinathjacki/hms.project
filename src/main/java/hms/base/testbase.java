package hms.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hms.utility.WebEventListener;


public class testbase {
	public static Properties pop;
	public static WebDriver driver;
	 public static WebEventListener web_el;
	 public static EventFiringWebDriver event;
	public testbase() {
		pop=new Properties();
		try {
			FileInputStream ipconfig=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/hms/config/config.properties");
			pop.load(ipconfig);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated ;catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//SCRIPT FOR INITIAL SETUP
public static void initialization() {
	String browserName=pop.getProperty("browser");
	if (browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
		 driver=new ChromeDriver();
	}
	else if (browserName.equals("edge")) {
		System.setProperty("webdriver.edge.driver", "./src/test/resources/msedgedriver.exe");
		 driver=new EdgeDriver();
		
	}
//basic method
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
	driver.get(pop.getProperty("URL"));
	web_el= new WebEventListener();
	event=new EventFiringWebDriver(driver);
	event.register(web_el);
	driver=event;
}
//web element wait
	 
	 public void waitforElementvisible(WebElement el) {
		 WebDriverWait wait=new WebDriverWait(driver,10);
		 wait.until(ExpectedConditions.visibilityOf(el));
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
			 
	 



			
		
		
	} 
	
	
