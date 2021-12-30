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
import org.testng.asserts.SoftAssert;

import PomClasses.HomePage2;
import PomClasses.LoginPage;
import PomClasses.ViewTimeTrack;
import basePackage.BaseClass;

public class LoginPageVerification extends BaseClass{

	private WebDriver driver;
	private LoginPage loginpage;	
	private HomePage2 homepage;
	private ViewTimeTrack time;
	private SoftAssert soft;
	
	@BeforeTest
    @Parameters ("browser")
	public void launchBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = openChromeBrowser();
		}
		else 
			if(browser.equalsIgnoreCase("firefox"))
			{
				driver = openFirefoxBrowser();
			}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://online.actitime.com/sauti1/login.do");
	}
	
	
	@BeforeClass
	public void createObjectPom()
	{
		soft = new SoftAssert();
		loginpage = new LoginPage(driver);
	 	homepage = new HomePage2(driver);
	 	time = new ViewTimeTrack(driver);
	 	System.out.println("Before class");
	 	
	}

	@BeforeMethod
	public void loginToApplication() throws InterruptedException
	{	
		Thread.sleep(3000);
	 	loginpage.sendUsername();
		loginpage.sendPass();
		loginpage.clickSignIn();
		Thread.sleep(4000);
		System.out.println("Before Method");
	}
	
	@Test
	public void toVerifyTrackLink() throws InterruptedException
	{
		homepage.timeTrack();
		String url  = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertEquals(url, "https://online.actitime.com/sauti1/user/view_tt.do");
		Thread.sleep(3000);
	
	}
	
	@Test 
	public void toVerifyTimeTrack() throws InterruptedException
	{
		homepage.timeTrack();
		String urlH  = driver.getCurrentUrl();
		System.out.println(urlH);
		Assert.assertEquals(urlH, "https://online.actitime.com/sauti1/user/view_tt.do");
		Thread.sleep(6000);
		time.clickOntimetrack();
		
		Thread.sleep(6000);
		time.selectElements();
		String url  = driver.getCurrentUrl();
		System.out.println(url);
		soft.assertEquals(url , "https://online.actitime.com/sauti1/timetrack/enter.do");
		System.out.println("End");
		
		
		soft.assertAll();
		Thread.sleep(6000);
	}
	
	@AfterMethod
	public void logoutApplication() 
	{
		homepage.logOut();
		System.out.println("After method");
	}

	@AfterClass
	public void nullApplication()
	{
		
		homepage = null;
		loginpage = null;
		time = null;
		System.out.println("After class");
	}
	@AfterTest
	public void closeApplication() throws InterruptedException
	{
		
		Thread.sleep(2000);
		driver.close();
	}
 
}

//  To launch Firefox by testng.xml
//<test name = "firefoxTest">
//<parameter name="browser"  value = "firefox">
//    <classes>
//      <class name="TestPackage.LoginPageVerification"/>
//    </classes>
//  </parameter>
//  </test> <!-- Test -->
