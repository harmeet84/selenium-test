package co.uk.ybs.selenium.psd2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Hello world!
 *
 */
public class App 
{
	/*static String driverPath = "C://Users//u70017//Downloads//chromedriver_win32//";
	public static WebDriver driver;*/
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    	/*System.out.println("*******************");
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("chrome.switches","--disable-extensions");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
	driver.navigate().to("https://ybsg-nonprod-uat.apigee.net/web/authorizationPage");
		
		String strPageTitle = driver.getTitle();
		
		driver.findElement(By.id("clientId")).sendKeys("K25WCyzGhCC4tOE4Z1zEW2vBdqkjWwv1");
		driver.findElement(By.id("clientSecretId")).sendKeys("OlbHrKCplGkABIZI");
		driver.findElement(By.id("clientId")).sendKeys("0OlG1oX7pJVO6LyA3EAh6VYCNMsp1G5V");
		driver.findElement(By.id("clientSecretId")).sendKeys("80cv7TbiFn1ZdB3h");
		
		WebElement mySelectElement = driver.findElement(By.id("bankId"));
		Select dropdown= new Select(mySelectElement);
		//driver.findElement(By.id("bankId")).sendKeys("value", "YBS");
		dropdown.selectByVisibleText("YBS");
		

		WebElement oCheckBox = driver.findElement(By.cssSelector("input[value='ReadAccountsBasic']"));
		WebElement oCheckBox1 = driver.findElement(By.cssSelector("input[value='ReadBalances']")); 
		oCheckBox.click();
		oCheckBox1.click();
		
		driver.findElement(By.cssSelector("button")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
	    wait.pollingEvery(4, TimeUnit.SECONDS);*/
    }
}
