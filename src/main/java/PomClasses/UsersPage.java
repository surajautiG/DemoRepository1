package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsersPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy (xpath = "(//div[text()='Users'])[1]")
	private WebElement users;
	
	@FindBy (xpath = "//div[text()='New User']")
	private WebElement newUser;
	
	@FindBy (xpath = "//div[@class='createPanel_footer '] //div[text()='Cancel']")
	private WebElement cancel;
	//div[@class='createPanel_footer '] //div[text()='Cancel']
	public UsersPage(WebDriver driver)
	{
		wait = new WebDriverWait(driver , 10);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnUsers()
	{
		wait.until(ExpectedConditions.visibilityOf(users)).click();
	}
	
	public void clickNewUser()
	{
		wait.until(ExpectedConditions.visibilityOf(newUser)).click();
	}

	public void clickOnCancel()
	{
		wait.until(ExpectedConditions.visibilityOf(cancel)).click();
	}
}
