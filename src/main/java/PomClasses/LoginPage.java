package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy (xpath = "//input[@id='username']")
	private WebElement username ;
	
	@FindBy (xpath = "//input[@name='pwd']")
	private WebElement password ;
	
	@FindBy (xpath = "//div[text()='Login ']")
	private WebElement login ;
	
	
	public LoginPage(WebDriver driver)
	{
		wait = new WebDriverWait(driver , 10);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}

	public void sendUsername()
	{
		//wait.until(ExpectedConditions.visibilityOf(username));
		username.sendKeys("surajauti4444@gmail.com");
	}
	
	public void sendPass()
	{
		//wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys("Manager");
	}
	
	public void clickSignIn()
	{
		login.click();
	}
}
