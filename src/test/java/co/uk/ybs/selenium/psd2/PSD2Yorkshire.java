package co.uk.ybs.selenium.psd2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class PSD2Yorkshire {
	
	ExtentReports report;
	ExtentTest logger;
	
	static String driverPath = "C://Users//u70017//Downloads//chromedriver_win32 (1)//";
	
	public static WebDriver driver;
	public static DataObjectMapping dataMapping;
	public Map<String,String> data = new HashMap();
	public Map<String, String> retrievalMap = new HashMap();
	//public Map<String, String> dataMap = new HashMap<>();
	
	@BeforeTest
	public void setUp() {
		System.out.println("*******************");
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("chrome.switches","--disable-extensions");
		
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		
		
	}
	
	

	@Test (priority=1)
	public void testChelseaYoaApplication() {
		report=new ExtentReports("./Reports/TestReport1.html");
		logger=report.startTest("testaTppToolpage");
		
	
		driver.navigate().to(dataMap().get("URL").toString());
		logger.log(LogStatus.INFO, "tpp tool test started ");
		String strPageTitle = driver.getTitle();
	
		 
		//driver.findElement(By.id("clientId")).sendKeys("K25WCyzGhCC4tOE4Z1zEW2vBdqkjWwv1");
		//driver.findElement(By.id("clientSecretId")).sendKeys("OlbHrKCplGkABIZI");
		driver.findElement(By.name("clientId")).sendKeys(dataMap().get("clientId").toString());
		driver.findElement(By.name("clientSecretId")).sendKeys(dataMap().get("clientSecretId").toString());
		
		WebElement mySelectElement = driver.findElement(By.id("bankId"));
		Select dropdown= new Select(mySelectElement);
		//driver.findElement(By.id("bankId")).sendKeys("value", "YBS");
		dropdown.selectByVisibleText(dataMap().get("bankId").toString());
		

		WebElement oCheckBox = driver.findElement(By.cssSelector("input[value='ReadAccountsBasic']"));
		WebElement oCheckBox1 = driver.findElement(By.cssSelector("input[value='ReadBalances']")); 
		WebElement oCheckBox2 = driver.findElement(By.cssSelector("input[value='ReadAccountsDetail']"));
		WebElement oCheckBox3 = driver.findElement(By.cssSelector("input[value='ReadBeneficiariesDetail']"));
		WebElement oCheckBox4 = driver.findElement(By.cssSelector("input[value='ReadStandingOrdersBasic']"));
		WebElement oCheckBox5 = driver.findElement(By.cssSelector("input[value='ReadStandingOrdersDetail']"));
		WebElement oCheckBox6 = driver.findElement(By.cssSelector("input[value='ReadTransactionsDetail']"));
		WebElement oCheckBox7 = driver.findElement(By.cssSelector("input[value='ReadTransactionsCredits']"));
		WebElement oCheckBox8 = driver.findElement(By.cssSelector("input[value='ReadTransactionsDebits']"));
		WebElement oCheckBox9 = driver.findElement(By.cssSelector("input[value='ReadTransactionsBasic']"));
		WebElement oCheckBox10 = driver.findElement(By.cssSelector("input[value='ReadProducts']"));
		
		
		oCheckBox.click();
		oCheckBox1.click();
		oCheckBox2.click();
		oCheckBox3.click();
		oCheckBox4.click();
		oCheckBox5.click();
		oCheckBox6.click();
		oCheckBox7.click();
		oCheckBox8.click();
		oCheckBox9.click();
		oCheckBox10.click();
		
		//driver.findElement(By.cssSelector("button")).click();
		
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		  
	        // Wait for Alert to be present
	 
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button")));
	    element.click();
		//WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.pollingEvery(5, TimeUnit.SECONDS);
		/*testbPsd2Login1Page();
		testcPsd2Login2Page();
		testdPsd2AccountSelectionPage();
		testdPsd2AuthorisationRequestPage();
		testdPsd2AuthorisationTransactionServicePage();
		testdPsd2AuthorisationTransactionPasswordPage();
		testdPsd2AuthorisationSuccessPage();
		testdPsd2TppRetrurnPage();
		testdPsd2TppResultPage();
		testaTppToolAuthorisationpage();
		testaTppToolAccessTokenpage();
		testdPsd2TppResultPage();*/
	    //wait.until(ExpectedConditions.elementToBeClickable(Submit));
	    //btnNewSalesOrser.click();
		System.out.println("Page title: - "+strPageTitle);
		if ("TPP Test Tool Application".equalsIgnoreCase(strPageTitle)) {
			logger.log(LogStatus.PASS, "Test Verified - TPP Test Tool Application");
		} else {
			logger.log(LogStatus.FAIL, "Test Fail - TPP Test Tool Application");
		}
		//Assert.assertTrue(strPageTitle.equalsIgnoreCase("TPP Test Tool Application"));
		
	}
	
	@Test (priority=2)
	public void testbPsd2Login1Page() {
		System.out.println("calling testPsd2Login1Page");
		String currentURL = driver.getCurrentUrl();
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("uid")));
		String strPageTitle = driver.getTitle();
		System.out.println("Page title b: - "+strPageTitle);
//		driver.findElement(By.name("uid")).sendKeys(dataMap.get("uid").toString());
		element.sendKeys(dataMap().get("uid").toString());		
		WebElement submit = driver.findElement(By.cssSelector("input[value='Continue']"));
		submit.click();
		
		
	   
		System.out.println("Page title b: - "+strPageTitle);
		if ("Yorkshire Building Society - User Login".equalsIgnoreCase(strPageTitle)) {
			logger.log(LogStatus.PASS, "Test Verified - login1 page");
		} else {
			logger.log(LogStatus.FAIL, "Test Fail - login1 page");
		}
		//Assert.assertTrue(strPageTitle.equalsIgnoreCase("Chelsea Building Society - User Login"));
	}
	
	@Test (priority=3)
	public void testcPsd2Login2Page() {
		
		//driver.navigate().to(currentURL);
		System.out.println("calling testPsd2Login2Page");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		
		String strPageTitle = driver.getTitle();
		System.out.println("Page title: - "+strPageTitle);
		WebElement mySelectDay = driver.findElement(By.name("dateOfBirth.day"));
		WebElement mySelectMonth = driver.findElement(By.name("dateOfBirth.month"));
		WebElement mySelectYear = driver.findElement(By.name("dateOfBirth.year"));
		
		Select dropdownDay= new Select(mySelectDay);
		Select dropdownMonth= new Select(mySelectMonth);
		Select dropdownYear= new Select(mySelectYear);
		dropdownDay.selectByVisibleText(dataMap().get("dateOfBirth.day").toString());
		dropdownMonth.selectByVisibleText(dataMap().get("dateOfBirth.month").toString());
		dropdownYear.selectByVisibleText(dataMap().get("dateOfBirth.year").toString());
		
		String str = driver.findElement(By.xpath("//div[1][@class='v-answer pwd-chars']/div")).getText();
		driver.findElement(By.id("char1-ID")).sendKeys(memoMap().get(str));
		String str1 = driver.findElement(By.xpath("//div[2][@class='v-answer pwd-chars']/div")).getText();
		driver.findElement(By.id("char2-ID")).sendKeys(memoMap().get(str1));
		String str2 = driver.findElement(By.xpath("//div[3][@class='v-answer pwd-chars']/div")).getText();
		System.out.print("Values of str : str1 : str2 = " +str +":" + str1 + ":" +str2);
		driver.findElement(By.id("char3-ID")).sendKeys(memoMap().get(str2));
		
		
				
		WebElement submit = driver.findElement(By.cssSelector("input[value='Continue']"));
		submit.click();
		
		
	   
		System.out.println("Page title: - "+strPageTitle);
		if ("Yorkshire Building Society - User Login".equalsIgnoreCase(strPageTitle)) {
			logger.log(LogStatus.PASS, "Test Verified - login2 page");
		} else {
			logger.log(LogStatus.FAIL, "Test Fail - login2 page");
		}
		//Assert.assertTrue(strPageTitle.equalsIgnoreCase("Chelsea Building Society - User Login"));
	}
	
	@Test (priority=4)
	public void testdPsd2AccountSelectionPage() {
		
		//driver.navigate().to(currentURL);
		System.out.println("calling account selection");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		
		String strPageTitle = driver.getTitle();
		System.out.println("Page title: - "+strPageTitle);
			
		List <WebElement> li= driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println(li.size());
        if (li.size() > 0) {
        	li.get(0).click();
        	WebElement submit = driver.findElement(By.cssSelector("input[value='Confirm']"));
    		submit.click();
        } else {
		WebElement submit = driver.findElement(By.cssSelector("input[value='Confirm']"));
		submit.click();
        }
		
		
	   
		System.out.println("Page title: - "+strPageTitle);
		if ("Yorkshire Building Society - Authorisation accounts".equalsIgnoreCase(strPageTitle)) {
			logger.log(LogStatus.PASS, "Test Verified - Authorisation accounts");
		} else {
			logger.log(LogStatus.FAIL, "Test Fail - Authorisation accounts");
		}
		//Assert.assertTrue(strPageTitle.equalsIgnoreCase("Chelsea Building Society - Authorisation accounts"));
	}
	
	@Test (priority=5)
	public void testdPsd2AuthorisationRequestPage() {
		
		//driver.navigate().to(currentURL);
		System.out.println("calling account selection");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		String strPageTitle = driver.getTitle();
		System.out.println("Page title: - "+strPageTitle);
			
				
		WebElement submit = driver.findElement(By.cssSelector("input[value='Confirm']"));
		submit.click();
		
		
	   
		System.out.println("Page title: - "+strPageTitle);
		if ("Yorkshire Building Society - Authorisation request".equalsIgnoreCase(strPageTitle)) {
			logger.log(LogStatus.PASS, "Test Verified - Authorisation request");
		} else {
			logger.log(LogStatus.FAIL, "Test Fail - Authorisation request");
		}
		//Assert.assertTrue(strPageTitle.equalsIgnoreCase("Chelsea Building Society - Authorisation request"));
	}
	
	@Test (priority=6)
	public void testdPsd2AuthorisationTransactionServicePage() {
		
		//driver.navigate().to(currentURL);
		System.out.println("calling account selection");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		
		String strPageTitle = driver.getTitle();
		System.out.println("Page title: - "+strPageTitle);
		
		List<WebElement> radiobutton = driver.findElements(By.name("telNumber"));
		for (int i=0 ; i <= radiobutton.size() ; i++) {
			if ("work".equalsIgnoreCase(radiobutton.get(i).getAttribute("value"))) {
				radiobutton.get(i).click();
				break;
			}
		}
				
		WebElement submit = driver.findElement(By.cssSelector("input[value='Call me now']"));
		submit.click();
		
		System.out.println("Page title: - "+strPageTitle);
		if ("Yorkshire Building Society - Transaction Confirmation service".equalsIgnoreCase(strPageTitle)) {
			logger.log(LogStatus.PASS, "Test Verified - Transaction Confirmation service");
		} else {
			logger.log(LogStatus.FAIL, "Test Fail - Transaction Confirmation service");
		}
		//Assert.assertTrue(strPageTitle.equalsIgnoreCase("Chelsea Building Society - Transaction Confirmation service"));
	}
	
	@Test (priority=7)
	public void testdPsd2AuthorisationTransactionPasswordPage() {
		
		//driver.navigate().to(currentURL);
		System.out.println("calling account selection");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		
		String strPageTitle = driver.getTitle();
		System.out.println("Page title: - "+strPageTitle);
		
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Phone call completed']")));
		//element.click();
		try {
			Thread.sleep(40000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement submit = driver.findElement(By.cssSelector("input[value='Phone call completed']"));
		submit.click();
		
		System.out.println("Page title: - "+strPageTitle);
		if ("Yorkshire Building Society -".equalsIgnoreCase(strPageTitle)) {
			logger.log(LogStatus.PASS, "Test Verified - Transaction Password service");
		} else {
			logger.log(LogStatus.FAIL, "Test Fail - Transaction Password service");
		}
		//Assert.assertTrue(strPageTitle.equalsIgnoreCase("Chelsea Building Society -"));
	}
	
	@Test (priority=8)
	public void testdPsd2AuthorisationSuccessPage() {
		
		//driver.navigate().to(currentURL);
		System.out.println("calling account selection");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		
		String strPageTitle = driver.getTitle();
		System.out.println("Page title: - "+strPageTitle);
		
		
		
		WebElement submit = driver.findElement(By.cssSelector("input[value='Return']"));
		submit.click();
		
		
	   
		System.out.println("Page title: - "+strPageTitle);
		if ("Yorkshire Building Society - Authorisation accounts".equalsIgnoreCase(strPageTitle)) {
			logger.log(LogStatus.PASS, "Test Verified - Authorisation accounts");
		} else {
			logger.log(LogStatus.FAIL, "Test Fail - Authorisation accounts");
		}
		//Assert.assertTrue(strPageTitle.equalsIgnoreCase("Chelsea Building Society - Authorisation accounts"));
	}
	
	@Test (priority=9)
	public void testdPsd2TppRetrurnPage() {
		
		//driver.navigate().to(currentURL);
		System.out.println("calling account selection");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		
		String strPageTitle = driver.getTitle();
		System.out.println("Page title: - "+strPageTitle);
		driver.findElement(By.name("clientId")).sendKeys(dataMap().get("clientId").toString());
		driver.findElement(By.name("clientSecret")).sendKeys(dataMap().get("clientSecretId").toString());
		
		
		WebElement element = driver.findElement(By.cssSelector("button"));
	    element.click();
		
		
	   
		System.out.println("Page title: - "+strPageTitle);
		
		//Assert.assertTrue(strPageTitle.equalsIgnoreCase("TPP Test Tool Application"));
	}
	
	@Test (priority=10)
	public void testdPsd2TppAccessTokenPage() {
		
		//driver.navigate().to(currentURL);
		System.out.println("calling account selection");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		
		String strPageTitle = driver.getTitle();
		System.out.println("Page title: - "+strPageTitle);
		String url = driver.getCurrentUrl();
		System.out.println("current url : " +url);
		DataObjectMapping objectMapping = new DataObjectMapping();
		
		String token[] = url.split("=", 2);
		String token1[] = token[1].split("&", 2);
		objectMapping.setRefreshToken(token1[0].toString());
		/*Select requestType = new Select(driver.findElement(By.id("requestType")));
		requestType.selectByIndex(1);
		Select account = new Select(driver.findElement(By.id("accounts")));
		account.selectByIndex(1);
		//driver.findElement(By.name("requestType")).sendKeys(dataMap().get("clientId").toString());
		//driver.findElement(By.name("accounts")).sendKeys(dataMap().get("clientSecretId").toString());
		List<WebElement> radiobutton = driver.findElements(By.name("operation"));
		for (int i=0 ; i <= radiobutton.size() ; i++) {
			if ("GetAccounts".equalsIgnoreCase(radiobutton.get(i).getAttribute("value"))) {
				radiobutton.get(i).click();
				break;
			}
		}
		
			WebElement element = driver.findElement(By.cssSelector("button"));
		    element.click();*/
		
		
	   
		System.out.println("Page title: - "+strPageTitle);
		//System.out.println("string : String1  :" +str +" : " +str1);
		//org.junit.Assert.assertTrue("Page title doesn't match", strPageTitle.equalsIgnoreCase("Yorkshire Building Society - Authorisation request"));
	}
	
	@Test(priority = 11)
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
		//org.junit.Assert.assertTrue(strPageTitle.equalsIgnoreCase("TPP Test Tool Application"));
	}
	
	@Test(priority = 12)
	public void testaTppToolAccessTokenpage() {
		
		
		String strPageTitle = driver.getTitle();
		
		driver.findElement(By.name("customerIPAddress")).sendKeys("10.10.10.10");
		driver.findElement(By.name("acessToken")).sendKeys((new DataObjectMapping()).getRefreshToken());
		
		WebElement element = driver.findElement(By.cssSelector("button"));
	    element.click();

		System.out.println("Page title: - "+strPageTitle);
		//org.junit.Assert.assertTrue(strPageTitle.equalsIgnoreCase("TPP Test Tool Application"));
	}
	
	@Test (priority=13)
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
		
			/*WebElement element = driver.findElement(By.cssSelector("button"));
		    element.click();*/
		
		
	   
		System.out.println("Page title: - "+strPageTitle);
		//System.out.println("string : String1  :" +str +" : " +str1);
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
	public void tearDown() {
		if(driver!=null) {
			System.out.println("Closing chrome browser");
			
			//report.endTest(logger);
			report.flush();
			//driver.quit();
		}
	}
	
	@AfterMethod
	public void tearDownMethod() {
		
			report.endTest(logger);
			//report.flush();
			//driver.quit();
		
	}
	
	
	public Map<String, String> dataMap() {	
	dataMapping = new DataObjectMapping();
	retrievalMap = dataMapping.dataExcelRead().get(2);
	/*	int size = dataMap().size();
		for (int i=0; i < size ; i++) {
			data.putAll(callDataRetrieve().get(i));
		}
		// TODO Auto-generated method stub*/
		return retrievalMap;
	
	}
	
	/*private Map<Integer, Map<String,String>> callDataRetrieve() {
		dataMapping = new DataObjectMapping();
		retrievalMap = dataMapping.dataExcelRead();
		return retrievalMap;
	}
	*/
	
}