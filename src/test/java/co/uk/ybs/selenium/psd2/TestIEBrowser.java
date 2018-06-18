package co.uk.ybs.selenium.psd2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestIEBrowser {
	
/*	//static String driverPath = "C://Users//u70017//Downloads//chromedriver_win32_new//";
	static String driverPath = "C://Users//u70017//Downloads//IEDriverServer_x64_3.8.0//";
	public static WebDriver driver;
	public static DataObjectMapping dataMapping;
	public static Map dataMap = new HashMap();
	
	
	@BeforeClass
	public static void setUp() {
		System.out.println("*******************");
		System.out.println("launching chrome browser");
		
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		 
		 //Method and Description - void setCapability(java.lang.String capabilityName, boolean value)
		 capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, false);
		
		 //DesiredCapabilities ieCapabilities=DesiredCapabilities.internetExplorer();
		 capabilities.setCapability("nativeEvents",false); 
		 capabilities.setCapability("unexpectedAlertBehaviour","accept");
		 capabilities.setCapability("ignoreProtectedModeSettings",true);
		 capabilities.setCapability("disable-popup-blocking",true);
		 capabilities.setCapability("PersistentHover",false);
		 capabilities.setCapability("RequireWindowFocus ", true);
		 //capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGN ORING_SECURITY_DOMAINS,true); 
		 capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		//System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		System.setProperty("webdriver.ie.driver", driverPath+"IEDriverServer.exe");
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("chrome.switches","--disable-extensions");
		
		 
		//driver = new ChromeDriver(options);
		driver = new InternetExplorerDriver(capabilities);
		driver.manage().window().maximize();
		dataMapping = new DataObjectMapping();
		dataMap = dataMapping.dataExcelRead().get(1);
		
	}
	
	@Test (priority=1)
	public void test1TppToolpage() {
		
		WebDriverWait wait = new WebDriverWait(driver, 120);
	     //WebElement element = wait.until(ExpectedConditions.(locator));
	   wait.until(ExpectedConditions.(element));
		driver.navigate().to(dataMap.get("URL").toString());
		
		String strPageTitle = driver.getTitle();
		
		driver.findElement(By.id("clientId")).sendKeys("K25WCyzGhCC4tOE4Z1zEW2vBdqkjWwv1");
		driver.findElement(By.id("clientSecretId")).sendKeys("OlbHrKCplGkABIZI");
		driver.findElement(By.id("clientId")).sendKeys(dataMap.get("clientId").toString());
		driver.findElement(By.id("clientSecretId")).sendKeys(dataMap.get("clientSecretId").toString());
		
		WebElement mySelectElement = driver.findElement(By.id("bankId"));
		Select dropdown= new Select(mySelectElement);
		//driver.findElement(By.id("bankId")).sendKeys("value", "YBS");
		dropdown.selectByVisibleText(dataMap.get("bankId").toString());
		

		WebElement oCheckBox = driver.findElement(By.cssSelector("input[value='ReadAccountsBasic']"));
		WebElement oCheckBox1 = driver.findElement(By.cssSelector("input[value='ReadBalances']")); 
		oCheckBox.click();
		oCheckBox1.click();
		
		driver.findElement(By.cssSelector("button")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.pollingEvery(10, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS);
	    //wait.until(ExpectedConditions.elementToBeClickable(Submit));
	    //btnNewSalesOrser.click();
		System.out.println("Page title: - "+strPageTitle);
		org.junit.Assert.assertTrue("Page title doesn't match", strPageTitle.equalsIgnoreCase("TPP Test Tool Application"));
	}
	
	@Test (priority=2)
	public void testbPsd2Login1Page() {
		System.out.println("calling testPsd2Login1Page");
		String currentURL = driver.getCurrentUrl();
		//driver.navigate().to(currentURL);
		
		String strPageTitle = driver.getTitle();
		System.out.println("Page title: - "+strPageTitle);
		driver.findElement(By.name("uid")).sendKeys(dataMap.get("uid").toString());
				
		WebElement submit = driver.findElement(By.cssSelector("input[value='Continue']"));
		submit.click();
		
		
	   
		System.out.println("Page title: - "+strPageTitle);
		org.junit.Assert.assertTrue("Page title doesn't match", strPageTitle.equalsIgnoreCase("Yorkshire Building Society - User Login"));
	}
	
	@Test (priority=3)
	public void testcPsd2Login2Page() {
		//driver.navigate().to(currentURL);
		System.out.println("calling testPsd2Login2Page");
				
		List<String> memoInfoList = new ArrayList<String>();
		String strPageTitle = driver.getTitle();
		System.out.println("Page title: - "+strPageTitle);
		WebElement mySelectDay = driver.findElement(By.name("dateOfBirth.day"));
		WebElement mySelectMonth = driver.findElement(By.name("dateOfBirth.month"));
		WebElement mySelectYear = driver.findElement(By.name("dateOfBirth.year"));
		
		Select dropdownDay= new Select(mySelectDay);
		Select dropdownMonth= new Select(mySelectMonth);
		Select dropdownYear= new Select(mySelectYear);
		dropdownDay.selectByVisibleText(dataMap.get("dateOfBirth.day").toString());
		dropdownMonth.selectByVisibleText(dataMap.get("dateOfBirth.month").toString());
		dropdownYear.selectByVisibleText(dataMap.get("dateOfBirth.year").toString());
	
		String str = driver.findElement(By.xpath("//div[1][@class='v-answer pwd-chars']/div")).getText();
		driver.findElement(By.id("char1-ID")).sendKeys(memoMap().get(str));
		String str1 = driver.findElement(By.xpath("//div[2][@class='v-answer pwd-chars']/div")).getText();
		driver.findElement(By.id("char2-ID")).sendKeys(memoMap().get(str1));
		String str2 = driver.findElement(By.xpath("//div[3][@class='v-answer pwd-chars']/div")).getText();
		
		driver.findElement(By.id("char3-ID")).sendKeys(memoMap().get(str2));
		
		
				
		WebElement submit = driver.findElement(By.cssSelector("input[value='Continue']"));
		submit.click();
		
		
	   
		System.out.println("Page title: - "+strPageTitle);
		//System.out.println("string : String1  :" +str +" : " +str1);
		org.junit.Assert.assertTrue("Page title doesn't match", strPageTitle.equalsIgnoreCase("Yorkshire Building Society - User Login"));
	}
	
	public Map<String, String> memoMap() {
		Map<String, String> memoInfoMap = new HashMap<String, String>();
		memoInfoMap.put("1st", "p");
		memoInfoMap.put("2nd", "a");
		memoInfoMap.put("3rd", "5");
		memoInfoMap.put("4th", "5");
		memoInfoMap.put("5th", "w");
		memoInfoMap.put("6th", "o");
		memoInfoMap.put("7th", "r");
		memoInfoMap.put("8th", "d");
		
		return memoInfoMap;
	}
	
	
	@AfterClass
	public static void tearDown() {
		if(driver!=null) {
			System.out.println("Closing chrome browser");
			//driver.quit();
		}
	}*/
	
}