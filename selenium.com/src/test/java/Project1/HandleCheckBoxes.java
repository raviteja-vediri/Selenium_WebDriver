package Project1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckBoxes {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		 WebDriverManager.chromedriver().setup();
	       WebDriver driver = new ChromeDriver();
	       
	       driver.get("https://testautomationpractice.blogspot.com/");
	      // driver.manage().window().maximize();
		
	       //Select specific checkBox
	       driver.findElement(By.id("monday")).click();
		
	       //Select all checkBoxes
	     List<WebElement> checkbox=  driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
	     
	     for(int i=0; i<checkbox.size();i++) {
	    	 checkbox.get(i).click();
	    	 
	     }
	     
	    /* for(WebElement checkb: checkbox) {
	    	 checkb.click();
	     }*/
	     
	     //Select last 3 checkBoxes
	     //total no.of checkboxes- how many checkboxes want to select = starting index
	     //7-3=4 4 is the starting index
	     for(int i=4;i<checkbox.size(); i++) {
	    	 checkbox.get(i).click();
	    	 }
	     //select first 3 checkboxes
	     for(int i=0; i<3; i++) {
	    	 checkbox.get(i).click();
	     }
	     
	     //unselect checkboxes if they are selected
	     for(int i=0; i<3; i++) {
	    	 checkbox.get(i).click();
	     }
	     
	     Thread.sleep(4000);
	     for(int i=0; i<checkbox.size();i++) {
	    	 if(checkbox.get(i).isSelected()) {
	    	 checkbox.get(i).click();
	    	 }
	     }
	     
	     
	}

}
