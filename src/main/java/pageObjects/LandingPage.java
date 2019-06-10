package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
public WebDriver driver;

By signin = By.xpath("//span[text()='Login']");
By title = By.xpath("//h2[text()='Featured Courses']");
By navigationBar= By.cssSelector(".nav.navbar-nav.navbar-right>li>a");

//public LandingPage(WebDriver driver) {
//	// TODO Auto-generated constructor stub
//this.driver= driver;
//}

public LandingPage(WebDriver driver) {
	this.driver=driver;
}

public WebElement getLogin() {
	return driver.findElement(signin);
}
public WebElement getTitle() {
	return driver.findElement(title);
}
public WebElement getNavigationBar() {
	return driver.findElement(navigationBar);
}

}
