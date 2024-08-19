package Project1;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class formFill_AutoIT {
	WebDriver driver;
	String URL = "https://demo.guru99.com/";
	
	@BeforeClass
	public void beforeclass() {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		//options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		//options.addExtensions(new File("C:\\Users\\ravit\\OneDrive\\Documents\\adblocker.crx"));
		
		driver= new ChromeDriver(options);
		
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void test1() {
		System.out.println("Test1 Started......");
		
		WebElement FunctionList =driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]"));
		FunctionList.click();
		driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[1]/ul/li[13]/a")).click();
		
			
		
	}

}
