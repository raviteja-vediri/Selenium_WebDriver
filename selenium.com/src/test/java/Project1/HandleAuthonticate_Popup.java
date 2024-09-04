package Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAuthonticate_Popup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		   WebDriverManager.chromedriver().setup();
	       WebDriver driver = new ChromeDriver();
	       
		//driver.get("c");
		
		//we can't handle Authanticate Popups using switchto() cmd & ExplicitWait cmd
	       //only way to skip that popup using injecting URL
	       //SYNTEX :http://username:Password@the-internet.herokuapp.com/basic_auth
	       
	       driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
	      System.out.println( driver.getTitle());
	      System.out.println( driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credenti')]")).getText());
	       
	}

}
