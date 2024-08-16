package Project1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DesiredCapabilities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		//options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		WebDriver driver = new ChromeDriver(options);
		 
		driver.get("https://www.google.co.in/");
		
		System.out.println("Test Passed");
		String title=driver.getTitle();
		System.out.println(title);
		

	}

}
