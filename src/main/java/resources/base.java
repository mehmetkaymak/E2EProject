package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
public static WebDriver driver;
public Properties prop;
public WebDriver initializerDriver() throws IOException {
	
	 prop= new Properties();
	FileInputStream fis=  new FileInputStream("C:\\Users\\Kaymak\\eclipse-workspace\\arraysPractice\\E2EProject\\src\\main\\java\\resources\\data.properties");
prop.load(fis);

String browserName = prop.getProperty("browser");
System.out.println(browserName);

if(browserName.equals("chrome")) {
	WebDriverManager.chromedriver().setup();
	
	 driver= new ChromeDriver();

	
}
else if(  browserName.equals("firefox")) {
	WebDriverManager.firefoxdriver().setup();
	driver =  new FirefoxDriver();
}
else if( browserName.equals("IE")) {
	
}
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
return driver;

}
public void getScreenShot(String result) throws IOException {
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C:\\Users\\Kaymak\\Screenshot\\"+result +"shot.png"));
}

}
