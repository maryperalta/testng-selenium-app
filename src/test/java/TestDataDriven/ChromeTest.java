package TestDataDriven;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeTest {
	
	   private WebDriver driver;

	    @BeforeClass
	    public static void setupClass() {
	    	WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    }

	    @Before
	    public void setupTest() {
	        driver = new ChromeDriver();
	    }

	    @After
	    public void teardown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }

	    @Test
	    public void test() {
	        // Your test code here
	    }

}
