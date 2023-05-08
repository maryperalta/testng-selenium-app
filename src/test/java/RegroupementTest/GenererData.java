package RegroupementTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class GenererData {

    WebDriver driver;

    @BeforeClass
    void before(){
        System.out.println("Avant test");
    }

    @BeforeMethod
    void setup() throws InterruptedException {
//        System.out.println("Avant chaque test");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(1000);
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test()
    void genererDataTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.findElement(By.id("FirstName")).sendKeys("");
        driver.findElement(By.id("LastName")).sendKeys("");
        driver.findElement(By.id("Email")).sendKeys("");
        driver.findElement(By.id("Password")).sendKeys("");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("");
        driver.findElement(By.id("Register-button")).click();
    }

/*    @Test(invocationCount = 20, threadPoolSize = 5)
    void genererDataTest(){
        System.out.println("une donnee");
    }*/

}


