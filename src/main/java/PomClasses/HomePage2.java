package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage2 {
	private  WebDriver driver;
	private WebDriverWait wait;
	
	//elements
	@FindBy (xpath = "//div [@id='container_tt']")
	private WebElement homepage;
	
	@FindBy (xpath = "//a[text()='View Time-Track']")
	private WebElement timetrack;
		
	@FindBy (xpath = "//a[text()='Logout']")
	private WebElement logOut;
	//constructor
	public HomePage2(WebDriver driver)
	{
		wait = new WebDriverWait(driver , 10);  //implicit wait
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    
	//method
	public void clickHomepage()
	{
		//wait.until(ExpectedConditions.visibilityOf(homepage));
		homepage.click();
	}

	public void timeTrack()
	{
		wait.until(ExpectedConditions.visibilityOf(timetrack));
		timetrack.click();
	}
	
	public void logOut()
	{
	
		wait.until(ExpectedConditions.visibilityOf(logOut)).click();
		
	}
}
