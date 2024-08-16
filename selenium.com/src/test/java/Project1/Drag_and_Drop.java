package Project1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drag_and_Drop {
	
	WebDriver driver;
	
	@BeforeClass
	public void beforeclass() {
		WebDriverManager.chromedriver().setup();
	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		//options.addArguments("--headless");
		options.addArguments("--disable-gpu");

		
		driver = new ChromeDriver(options);
		
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void Drag_Drop() throws InterruptedException {
		System.out.println("Test Started.....");
		
		WebElement sourceElement = driver.findElement(By.xpath("//*[@id=\"credit2\"]/a")); //draggableElement
		
		WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"bank\"]/li")); //dropped element
		
		// Create an instance of the Actions class
		Actions actions = new Actions(driver);
	    
		Thread.sleep(2000);
		// Perform the drag-and-drop action
		actions.dragAndDrop(sourceElement, targetElement).perform();
		
		WebElement amount = driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
		WebElement targetAmount = driver.findElement(By.xpath("//*[@id=\"amt7\"]/li"));
	
		// Perform drag-and-drop action using clickAndHold and moveToElement
		actions.clickAndHold(amount).moveToElement(targetAmount).release().perform();
		     
		String DebitMovement = driver.findElement(By.xpath("//*[@id=\"t7\"]")).getText();
		if (DebitMovement.equals("5000")) {
            System.out.println("Drag and drop operation was successful.");
        } else {
            System.out.println("Drag and drop operation failed.");
        }     
		
		WebElement CreditAccount = driver.findElement(By.xpath("//*[@id=\"credit1\"]/a"));
		WebElement DroppedAccount = driver.findElement(By.xpath("//*[@id=\"loan\"]/li"));
		
		WebElement CreditAmount = driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
		WebElement DroppedAmount = driver.findElement(By.xpath("//*[@id=\"amt8\"]/li"));
		
		actions.dragAndDrop(CreditAccount, DroppedAccount).perform();
		actions.dragAndDrop(CreditAmount, DroppedAmount).perform();
		
		String CreditMovement = driver.findElement(By.xpath("//*[@id=\"t8\"]")).getText();
		if (CreditMovement.equals("5000")) {
            System.out.println("Drag and drop operation was successful.");
        } else {
            System.out.println("Drag and drop operation failed.");
        }     
		
		System.out.println("Drag&Drop Status.....:"+driver.findElement(By.xpath("//*[@id=\"equal\"]/a")).getText());
		
		driver.close();
		
		
		
	}
}
