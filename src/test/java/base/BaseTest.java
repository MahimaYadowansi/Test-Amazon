package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public static Properties config=new Properties();
	public static Properties or=new Properties();
	public static FileInputStream fis;
	public static FileInputStream fis1;
	public static WebDriverWait wait;
	public static final Logger logger = LogManager.getLogger(BaseTest.class);
	 public static final AtomicInteger counter = new AtomicInteger(1);
	 
	 @BeforeSuite()
	 public void setup() throws IOException
	 {
		 if(driver==null)
		 {//get browser
			 fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
			 config.load(fis);
			 
			 //get element xpath
			 
			 fis1 = new FileInputStream(
					  System.getProperty("user.dir") + "\\src\\test\\resources\\or.properties");
					or.load(fis1);
		 }
		 if(config.getProperty("browser").equals("chrome"))
		 {
			 WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
		 }
		 else if (config.getProperty("browser").equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (config.getProperty("browser").equals("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
		 driver.manage().window().maximize();
		 logger.info("Browser launched and maximized.");
			driver.get(config.getProperty("BaseUrl"));
			
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	 }
	 @AfterSuite
		public void tearDown() throws InterruptedException {
			if (driver != null) {
				Thread.sleep(10000);
				driver.quit();
				 logger.info("Browser closed.");
			}

}
}
