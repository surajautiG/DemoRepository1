package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewTimeTrack {
	private WebDriverWait wait;
	private WebDriver driver;
	//elements
//	@FindBy (xpath = "//a[text()='View Time-Track']")
//	private WebElement timetrack;
		
	@FindBy (xpath = "//td[@class='middle-right-cell customLeftPart']")
	private WebElement arrow;
	
	@FindBy (xpath = "//td[@class='userSelectorButton']")
	private WebElement element;
	
	@FindBy (xpath = "(//span[text()='Ramirez, Maria'])[1]")
	private WebElement user;
	
	
	
	//div[@class='popup_menu_icon tips_icon_light_on']
	//constructor
	public ViewTimeTrack(WebDriver driver)
	{
		this.driver=driver;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}
    
	//method
	public void clickOntimetrack()
	{
		arrow.click();
					
	}
	
	public void selectElements()
	{
		wait.until(ExpectedConditions.visibilityOf(element)).click();
    	wait.until(ExpectedConditions.visibilityOf(user)).click();
//     	Select s = new Select(user);
//		s.selectByValue("Smith, Brett");
	}
}
