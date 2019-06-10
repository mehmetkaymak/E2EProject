package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class ValidateTitle extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializerDriver();
		log.info("Driver is initiliazed");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage");
	}
	
	@Test
	public void ValidateTitle() throws IOException {
		
	
		
		LandingPage l = new LandingPage(driver);
		//l.getTitle().getText();
	Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES123");
	log.info("Successfully validated");
}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;
	}
	
	
}