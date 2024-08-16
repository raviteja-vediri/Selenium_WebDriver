package Project1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutodownloadBrowser {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       
       driver.get("https://www.google.co.in/");
       driver.manage().window().maximize();
       
       System.out.println("Test Passed");
       driver.close();
	}

}
