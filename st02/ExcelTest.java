package st02;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ExcelTest {
	
	 private List<String> list;
     String baseUrl = "http://103.120.226.190/selenium-demo/git-repo";
	 private WebDriver driver;
	 private Map<String, Object> vars;
	 JavascriptExecutor js;
	 
	 @Before
	 public void setUp() {
		 String driverPath = System.getProperty("user.dir") + "/src/resources/driver/geckodriver.exe";
		 System.setProperty("webdriver.gecko.driver", driverPath);
	     driver = new FirefoxDriver();
	     js = (JavascriptExecutor) driver;
	     vars = new HashMap<String, Object>();
	 }
	 
	 @After
	 public void tearDown() {
	     driver.close();
	 }
	  
	 @Test
	 public void testweb() {
		 driver.get(baseUrl);
		 list = Excel.readExcel("src\\Selenium+Lab2020.xlsx");
	     for(int i = 0; i < list.size(); i+=2) {
	    	 String username = list.get(i);
             String password = list.get(i+1);
             System.out.println(username);
             driver.manage().window().setSize(new Dimension(550, 693));
    	     driver.findElement(By.name("user_number")).click();
    	     driver.findElement(By.name("user_number")).sendKeys(username);
    	     driver.findElement(By.name("password")).click();
    	     driver.findElement(By.name("password")).sendKeys(password);
    	     driver.findElement(By.cssSelector(".btn")).click();
    	     driver.findElement(By.cssSelector(".p-5")).click();
    	     assertThat(driver.findElement(By.cssSelector(".mb-2:nth-child(6) > code")).getText(), is(password));
    	     if(driver.findElement(By.cssSelector(".mb-2:nth-child(6) > code")).getText().equals(password)) {
    	    	 System.out.println(" ³É¹¦");
    	     }
    	     else {
    	    	 System.out.println("Ê§°Ü");
    	     }
	    } 
	    	
     }
}