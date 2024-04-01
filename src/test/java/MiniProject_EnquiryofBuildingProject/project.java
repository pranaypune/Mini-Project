package MiniProject_EnquiryofBuildingProject;


import java.io.File;

import java.io.IOException;
import java.time.Duration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class project {
	
	
	public static void PopUpHandel(WebDriver driver) {
		try {
		       driver.findElement(By.xpath("//a[@class='close-indicator']")).click();
	        }catch(Exception e) {
	        	
	        }
     	
     	  try {
               driver.findElement(By.xpath("//i[@class = 'eicon-close']")).click();
              }catch(Exception e) {
            	  
              }
   
     	  try {
     	      driver.findElement(By.xpath("//a[@id='livchat_close']")).click();	           
     	      }catch(Exception e) {
     	    		 
     	      }
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
        WebDriver driver=new ChromeDriver();
        
        
        /*Putting Implicit Wait*/
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        
        /*MAximizing web Page*/
        driver.manage().window().maximize();
        
        
        /*Go To Target Page*/
        driver.get("https://ishahomes.com/");
        
        
        JavascriptExecutor js=(JavascriptExecutor)driver;
        
        
        PopUpHandel(driver);
        	   
      	    	        
        /*Go To Completed Project Page*/
        driver.findElement(By.xpath("//li[@id='menu-item-25810']/a")).click();
        
     

        PopUpHandel(driver);
   
        /*NUMBER OF COMPLETED PROJECTS*/
        List<WebElement> list=driver.findElements(By.xpath("//div[@class='elementor-column elementor-col-100 elementor-top-column elementor-element elementor-element-3599bff']//div[@class='elementor-widget-wrap elementor-element-populated']/div/div/div/div/child::div"));
        System.out.println("Total Number of Completed Projects: "+list.size());
       
        
        
        System.out.println("The first five Projects are: \n");
        
        
        
        /*FIRST FIVE NAMES OF COMPLETED PROJECTS*/
        for(int i=0;i<list.size()-19;i++) {
        	System.out.println(list.get(i).getText());
        	System.out.println("\n");
        }
        
        
        
        /*Scroll to the end of the Page*/
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        
        
        /*VERIFY IF CONTACT US TEXT IS DISPLAYED ON THE PAGE*/
        boolean display=driver.findElement(By.xpath("//span[text()='Contact Us']")).isDisplayed();
        System.out.println("“Contact Us” text is displayed on the page :"+display);
        
        
        
        /*GO TO CONTACT US PAGE*/
        driver.findElement(By.linkText("Contact Us")).click();

        
	         	    
        PopUpHandel(driver); 

        /*PRINTING THE MAIL ID ON THE CONSOLE*/
        String mail=driver.findElement(By.xpath("//a[@href='mailto:marketing@ishahomes.com']")).getText();
        System.out.println("The Mail Id is :"+mail);
        
        
                
        /*SCROLL DOWN*/
        WebElement pos=driver.findElement(By.xpath("//div[@class='elementor-element elementor-element-9787a84 elementor-widget__width-inherit elementor-widget-mobile__width-inherit elementor-widget elementor-widget-heading']//h2[@class='elementor-heading-title elementor-size-default']"));
        js.executeScript("arguments[0].scrollIntoView();",pos);

		
		
        /*CAPTURE THE SCREENSHOT*/
        WebElement re=driver.findElement(By.xpath("//div[@class='elementor-element elementor-element-f61d2b7 elementor-widget elementor-widget-text-editor']"));
		File src=re.getScreenshotAs(OutputType.FILE);
		File trg=new File("C:\\Users\\2318211\\OneDrive - Cognizant\\Pictures\\Screenshots\\Result_page.jpg\\");
		Files.copy(src,trg);
		
		
		/*CLOSE THE BROWSER*/
		driver.quit();
        
        
        
	}

}
