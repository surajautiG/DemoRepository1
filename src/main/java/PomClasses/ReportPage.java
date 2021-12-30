package PomClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions action;
	
	@FindBy (xpath = "//div[@id='container_reports']")
	private WebElement report;
	
	@FindBy (xpath = "//div[text()='Create Widget']")
	private WebElement widgets;
	
	@FindBy (xpath = "(//input[@type='text'])[7]")
	private WebElement name;
	
	@FindBy (xpath = "//span[text()='Add Widget']")
	private WebElement addWidget;
	
	
	public ReportPage(WebDriver driver)
	{
		action = new Actions(driver);
		wait = new WebDriverWait(driver , 10);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnReport()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='container_reports']")));
		action.moveToElement(report).click().build().perform();
	}
	
	public void clickOnWidget()
	{
		wait.until(ExpectedConditions.visibilityOf(widgets));
		action.moveToElement(widgets);
	}
	
	public void widgetName()
	{
		wait.until(ExpectedConditions.visibilityOf(name)).sendKeys("Kripto Currency");
	}
	
	public void addWidget()
	{
		wait.until(ExpectedConditions.visibilityOf(addWidget)).click();
	}
}
