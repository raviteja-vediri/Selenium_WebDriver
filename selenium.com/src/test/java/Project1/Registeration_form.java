package Project1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Registeration_form {
	
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
	public void Test1() throws IOException {
		
		
		//Text Box
		driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("John");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("wick");
		driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys("xyz,  abc, 1001");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("xyz@gmail.com");
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("9876543210");
		
		//RadioButton & checkbox
		System.out.println(driver.findElement(By.name("radiooptions")).isSelected());
		driver.findElement(By.name("radiooptions")).click();
		driver.findElement(By.id("checkbox1")).click();
		driver.findElement(By.id("checkbox2")).click();
		
		System.out.println("radiobutton done");
		
		//Dropdown
		 WebElement multiSelectDropdown = driver.findElement(By.id("msdd"));
		 Select select = new Select(multiSelectDropdown);
		 
		 // Check if the dropdown supports multiple selections
	        if(select.isMultiple()) {
	            // Select multiple options by visible text
		 select.selectByVisibleText("English");
		 select.selectByVisibleText("Japanese");
		 select.selectByVisibleText("Hindi");
		 
		// Print all selected options
         for (WebElement selectedOption : select.getAllSelectedOptions()) {
             System.out.println("Selected option: " + selectedOption.getText());
         }
	        }else {
	        	System.out.println("The dropdown does not support multiple selections.");
	        }
	        
	     WebElement skill= driver.findElement(By.xpath("//select[@id='Skills']"));
	     Select select1 = new Select(skill);
		 select1.selectByIndex(27);
		 
		 WebElement country= driver.findElement(By.xpath("//select[@id='countries']"));
		 Select select2 = new Select(country);
		 select2.selectByIndex(0);
		
		 WebElement con= driver.findElement(By.xpath("//span[@class='select2-selection select2-selection--single']"));
		 Select select3= new Select(country);
		 select3.selectByIndex(0);
		 
		 WebElement year= driver.findElement(By.id("yearbox"));
		 WebElement Month =driver.findElement(By.xpath("//select[@placeholder='Month']"));
		 WebElement Date =driver.findElement(By.id("daybox"));
		 
		 Select y= new Select(year);
		 y.selectByValue("1996");
		 Select m = new Select(Month);
		 m.selectByValue("September");
		 Select d= new Select(Date);
		 d.selectByValue("9");
		 
		 driver.findElement(By.id("firstpassword")).sendKeys("King@123");
		 driver.findElement(By.id("secondpassword")).sendKeys("King@123");
		 
		 //Screenshot
		 File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 File destination = new File("screenshot.png");
		 FileUtils.copyFile(screenshot, destination);
	}

}
