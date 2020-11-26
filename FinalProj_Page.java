package finalProjectPkg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class FinalProj_Page {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id='search_query_top']")
	private WebElement itemName;
	public WebElement getitemName() {
		return this.itemName;
	}
	
	@FindBy(xpath="//*[@name='submit_search']")
	private WebElement clickSearchButton;
	public WebElement clickSearch() {
		return this.clickSearchButton;
	}
	
	@FindBy(xpath="//*[@id='selectProductSort']")
	private WebElement clickSortButton;
	public WebElement clickSort() {
		return this.clickSortButton;
	}
	
	@FindBy(linkText="Printed Chiffon Dress")
	private WebElement selectItem;
	public WebElement clickSelectedItem() {
		return this.selectItem;
	}
	
	@FindBy(xpath="//*[@class='exclusive']")
	private WebElement addToCart;
	public WebElement addItemToCart() {
		return this.addToCart;
	}
	
	@FindBy(linkText="Proceed to checkout")
	private WebElement proceedToChkOut;
	public WebElement clickCheckOut() {
		return this.proceedToChkOut;
	}
	@FindBy(xpath="//*[@id='total_price']")
	private WebElement totalPrice;
	public WebElement getTotalPrice() {
		return this.totalPrice;
	}
		
	public void openFinalProjApplication(String driverPath,String URL,int waitTime) {
		System.setProperty("webdriver.chrome.driver",driverPath);
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(waitTime,TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().window().maximize();
	}
	
	public void orderingAnItem(String itemName,String lowestPrice,int timeout,String printTotalValue) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,timeout), this);
		
		getitemName().sendKeys(itemName);
		clickSearch().click();
		
		Select sortBtn=new Select(clickSort());
		sortBtn.selectByValue(lowestPrice);
			
		clickSelectedItem().click();
		addItemToCart().click();
		clickCheckOut().click();
		
		System.out.println(printTotalValue + getTotalPrice().getText());
		clickCheckOut().click();		
	}
	
	public String verifyLandingPageTitle() {
		String actualTitle=driver.getTitle();
		return actualTitle;		
	}
	
	public void closeFinalProjApplication() {
		driver.close();
	}

}
