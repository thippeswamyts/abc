package goibibo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
public class sampleTest {

	

		@Test
		public void sample() throws InterruptedException
		{
			String dmonth = "April 2024";
			int dday =26;
			
			String rmonth = "May 2024";
			int rday =30;
			
			
			WebDriver driver = null;
			
			String BROWSER = System.getProperty("browser");
			if(BROWSER.contains("chrome"))
			{
				driver = new ChromeDriver();
			}
			else if(BROWSER.contains("firefox"))
			{
				driver = new FirefoxDriver();
			}
			else if(BROWSER.contains("edge"))
			{
				driver = new EdgeDriver();
			}
			
			
	 		// String url = System.getProperty("url")
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get("https://www.goibibo.com/");
			
			driver.findElement(By.xpath("//span[@class ='logSprite icClose']")).click();
			WebElement ele1 = driver.findElement(By.xpath("//span[text() ='From']"));
		 
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		   wait.until(ExpectedConditions.elementToBeClickable(ele1));
		   ele1.click();
		   driver.findElement(By.xpath("//input[@type='text']")).sendKeys("bengalore");
		   driver.findElement(By.xpath("//span[contains(.,'Bengaluru')]")).click();
		   
		   WebElement ele2 = driver.findElement(By.xpath("//span[text() ='To']"));
		   driver.findElement(By.xpath("//input[@type='text']")).sendKeys("delhi");
		   driver.findElement(By.xpath("//span[contains(.,'Delhi')]")).click();
		   
		  driver.findElement(By.xpath("//span[.='Departure']")).click();
		  WebElement ddate = driver.findElement(By.xpath("//div[.='"+dmonth+"']/ancestor::div[@class='DayPicker-Month']//p[.='"+dday+"']"));
		  ddate.click();
		   
		  driver.findElement(By.xpath("//span[.='Return']")).click();
		 
		  WebElement rdate = driver.findElement(By.xpath("//div[.='"+rmonth+"']/ancestor::div[@class='DayPicker-Month']//p[.='"+rday+"']"));
		  Thread.sleep(10000);
		  rdate.click();
		   
		   
		}
		
	}


