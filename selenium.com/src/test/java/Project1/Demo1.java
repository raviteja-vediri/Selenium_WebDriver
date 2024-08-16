package Project1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo1 {
	WebDriver driver;
	
	@Test
    public void test1() {
		System.out.println("Test Passed.........");
	}
	
	@BeforeClass
	public void beforeclass() {
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\ravit\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		driver= new EdgeDriver();
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(1000, null)
	}
	
	@AfterClass
		public void afterclass() {
		driver.close();
	}

}
