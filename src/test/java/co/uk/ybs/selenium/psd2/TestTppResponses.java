package co.uk.ybs.selenium.psd2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Ignore
public class TestTppResponses {
	
	/*static String driverPath = "C://Users//u70017//Downloads//chromedriver_win32 (1)//";
	
	public static WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.out.println("*******************");
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("chrome.switches","--disable-extensions");
		
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		
	}
	@Test(priority = 10)
	public void testaTppToolAuthorisationpage() {
		driver.navigate().to("https://api-uat.ybs.co.uk/v2/web");
		
		String strPageTitle = driver.getTitle();
		
		List<WebElement> radiobutton = driver.findElements(By.name("operation"));
		for (int i=0 ; i <= radiobutton.size() ; i++) {
			if ("accountInfo".equalsIgnoreCase(radiobutton.get(i).getAttribute("value"))) {
				radiobutton.get(i).click();
				break;
			}
		}
		
		WebElement element = driver.findElement(By.cssSelector("button"));
	    element.click();

		System.out.println("Page title: - "+strPageTitle);
		org.junit.Assert.assertTrue(strPageTitle.equalsIgnoreCase("TPP Test Tool Application"));
	}
	
	@Test(priority = 11)
	public void testaTppToolAccessTokenpage() {
		
		
		String strPageTitle = driver.getTitle();
		
		driver.findElement(By.name("customerIPAddress")).sendKeys("10.10.10.10");
		driver.findElement(By.name("acessToken")).sendKeys((new DataObjectMapping()).getRefreshToken());
		
		WebElement element = driver.findElement(By.cssSelector("button"));
	    element.click();

		System.out.println("Page title: - "+strPageTitle);
		org.junit.Assert.assertTrue(strPageTitle.equalsIgnoreCase("TPP Test Tool Application"));
	}
	
	@Test (priority=12)
	public void testdPsd2TppResultPage() {
		int counter = 0 ;
		//driver.navigate().to(currentURL);
		System.out.println("calling account selection");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		
		String strPageTitle = driver.getTitle();
		System.out.println("Page title: - "+strPageTitle);
		
		Select requestType = new Select(driver.findElement(By.id("requestType")));
		requestType.selectByIndex(1);
		Select account = new Select(driver.findElement(By.id("accounts")));
		account.selectByIndex(1);
		List<WebElement> radiobutton = driver.findElements(By.name("operation"));
		
		
		for (int i=0 ; i < radiobutton.size() ; i++) {
			radiobutton = driver.findElements(By.name("operation"));
			if ("GetAccounts".equalsIgnoreCase(radiobutton.get(i).getAttribute("value")) && counter == 0) {
				radiobutton.get(i).click();
				
				
			} else if ("GetAccountBalances".equalsIgnoreCase(radiobutton.get(i).getAttribute("value")) && counter == 1) {
				radiobutton.get(i).click();
				
				
			} else if ("GetAccountProduct".equalsIgnoreCase(radiobutton.get(i).getAttribute("value")) && counter == 2) {
				radiobutton.get(i).click();
				
				
			} else if ("GetAccountBeneficiaries".equalsIgnoreCase(radiobutton.get(i).getAttribute("value")) && counter == 3) {
				radiobutton.get(i).click();
				
				
			} else if ("GetAccountStandingOrders".equalsIgnoreCase(radiobutton.get(i).getAttribute("value")) && counter == 4) {
				radiobutton.get(i).click();
				
				
			} else if ("GetAccountTransactions".equalsIgnoreCase(radiobutton.get(i).getAttribute("value")) && counter == 5) {
				radiobutton.get(i).click();
			}
				
			WebElement element = driver.findElement(By.cssSelector("button"));
		    element.click();
		    counter ++;
		    try {
				Thread.sleep(3000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.history.go(-1)");
				Thread.sleep(2000);	
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
			WebElement element = driver.findElement(By.cssSelector("button"));
		    element.click();
		
		
	   
		System.out.println("Page title: - "+strPageTitle);
		//System.out.println("string : String1  :" +str +" : " +str1);
	}


	
	@AfterClass
	public void tearDown() {
		if(driver!=null) {
			System.out.println("Closing chrome browser");
			//driver.quit();
		}
	}*/
	
	
}