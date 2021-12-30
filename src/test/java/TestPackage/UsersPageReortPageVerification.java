package TestPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PomClasses.HomePage2;
import PomClasses.LoginPage;
import PomClasses.ReportPage;
import PomClasses.UsersPage;
import basePackage.BaseClass;

public class UsersPageReortPageVerification extends BaseClass{
	private WebDriver driver;
	private LoginPage loginpage;	
	private HomePage2 homepage;
	private ReportPage report;
	private UsersPage user;
	
	@BeforeTest
    @Parameters ("browser")
	public void launchBrowser(String browser) throws InterruptedException {
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = openChromeBrowser();
		}
		else 
		{
			if(browser.equalsIgnoreCase("firefox"))
			{
				driver = openFirefoxBrowser();
			}
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://online.actitime.com/sauti1/login.do");
		Thread.sleep(8000);
	
	}
	
	@BeforeClass
	public void beforeClass()
	{
		loginpage = new LoginPage(driver);
	 	homepage = new HomePage2(driver);
	 	report = new ReportPage(driver);
	 	user = new UsersPage(driver);
		System.out.println("Before class");
	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException
	{	
		Thread.sleep(3000);
	 	loginpage.sendUsername();
		loginpage.sendPass();
		loginpage.clickSignIn();	
		System.out.println("Before method");
		
	}
	
	@Test 
	public void testA() throws InterruptedException
	{
		Thread.sleep(4000);
		report.clickOnReport();
		
		report.clickOnWidget();
		report.widgetName();
		report.addWidget();
		String url  = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertTrue(true);
		
		Thread.sleep(4000);
	}
	
	@Test 
	public void testB() throws InterruptedException
	{
		user.clickOnUsers();
		Thread.sleep(5000);
		user.clickNewUser();
		Thread.sleep(5000);
		user.clickOnCancel();
		String url  = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertEquals(url, "https://acctiiyimedmaskbflshdjfjbm" ,  "user page url not match");
		
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException 
	{
		Thread.sleep(3000);
		homepage.logOut();
		System.out.println("after method");
	}

	@AfterClass
	public void aftereClass() throws InterruptedException
	{
		homepage = null;
		loginpage = null;
		
		System.out.println("After class");
	}
	@AfterTest
	public void closeApplication() throws InterruptedException
	{
		
		Thread.sleep(2000);
		driver.close();
	}
	
	
}
