package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class ValidateBar extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializerDriver();
		
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void basePageNavigation() throws IOException, InterruptedException {
		
		
		
		LandingPage l = new LandingPage(driver);
//	System.out.println(l.getNavigationBar().isDisplayed());
		Thread.sleep(3000);
	Assert.assertTrue(l.getNavigationBar().isDisplayed());
	log.info("Navigation bar isdisplayed");
}
	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;
	}
	
	
}
