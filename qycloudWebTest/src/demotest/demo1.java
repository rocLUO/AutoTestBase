package demotest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import com.webTestBase.WebBase;


public class demo1 {
	
	WebDriver driver;
	
  @BeforeClass
  public void beforeClass() {
      System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
      driver =new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }  	
	
  @Test
  public void f() {
	  
	  driver.navigate().to("http://www.baidu.com");
	  
  }


  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  
}
