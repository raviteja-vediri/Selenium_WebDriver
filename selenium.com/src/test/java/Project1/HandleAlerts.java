package Project1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
	       WebDriver driver = new ChromeDriver();
	       
	       driver.get("https://testautomationpractice.blogspot.com/");
	      // driver.manage().window().maximize();
	       
	       //ALERT is not a WEBElement to handle ALERTs we need to switch in to ALERT window to handle
	       
	       //Normal Alert with OK Button
	       driver.findElement(By.xpath("//button[normalize-space()='Alert']")).click();
	       
	       Alert myalert= driver.switchTo().alert();
	       System.out.println(myalert.getText());
	       myalert.accept();
	       
	       Thread.sleep(2000);
	       //Confirmation Alert OK/dismiss
	       driver.findElement(By.xpath("//button[normalize-space()='Confirm Box']")).click();
	       Thread.sleep(2000);
	      // driver.switchTo().alert().accept(); //Close alert using OK button
	     driver.switchTo().alert().dismiss(); //Close alert using Dismiss Button
	     
	     //Prompt Alert - having Input BOX
	     driver.findElement(By.xpath("//button[normalize-space()='Prompt']")).click();
	     Alert Myalert= driver.switchTo().alert();
	     Myalert.sendKeys("Welcome");
	     Myalert.accept();
	}

}
