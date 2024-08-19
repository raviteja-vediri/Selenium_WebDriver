package Project1;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Switching_Windows {
	
	WebDriver driver;
	String URL ="https://demo.automationtesting.in/Windows.html";
	
	
	@BeforeClass
	public void beforeclass() {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions option= new ChromeOptions();
		option.addArguments("--start-maximized");
		option.addArguments("--disable-notifications");
		//option.addArguments("--headless");
		option.addArguments("--disable-gpu");
		
		driver= new ChromeDriver(option);
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@Test
	public void Test1() {
		driver.findElement(By.xpath("//a[contains(text(),'Open New Tabbed Windows')]")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		
		Set <String> windows=driver.getWindowHandles();
		for(String i : windows) {
			//System.out.println(driver.getTitle());
			String t= driver.switchTo().window(i).getTitle();
			//System.out.println(t);
			
			if(t.contains("Frames & windows")) {
				driver.close();
			}
		}
		
	}
}
