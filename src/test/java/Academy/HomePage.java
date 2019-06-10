package Academy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
	driver = initializerDriver();
	
	//driver.get(prop.getProperty("url"));
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String uname , String password,String text) throws IOException, InterruptedException {
		
   //driver = initializerDriver();
		
		driver.get(prop.getProperty("url"));
		
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(uname);
		Thread.sleep(3000);
		lp.getPassword().sendKeys(password);
		
		lp.getLogin().click();
	log.info(text);
}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data =  new Object[2][3];
		
		data [0][0]=  "nonresc@gamia.com";				
		data [0][1]=	"nonresctriced";
		data [0][2]="text1";
		
		data [1][0]= "sddc@gamia.com"; 				
		data [1][1]="gscxcsg";
		data [1][2]="text2";
		return data;
	}
	
	
}
