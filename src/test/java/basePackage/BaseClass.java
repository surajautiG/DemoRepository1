package basePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	public static WebDriver openChromeBrowser() {
	    
		System.setProperty("webdriver.chrome.driver", "E:\\Automation Java\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
		return driver;
		
	}
	
	public static WebDriver openFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver", "E:\\Automation Java\\geckodriver.exe");	
		WebDriver driver = new FirefoxDriver();
		return driver;
		
	}
	
//	    public static WebDriver openOperaBrowser() {
//		System.setProperty("webdriver.opera.driver", "E:\\Katraj Class\\chromedriver.exe");	
//		WebDriver driver = new ChromeDriver();
//		return driver;

 }