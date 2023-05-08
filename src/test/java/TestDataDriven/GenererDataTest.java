package TestDataDriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.*;

public class GenererDataTest {

    WebDriver driver;

/*
//    @Test(invocationCount = 20, threadPoolSize = 5)
//    void genererDataTest(){
//        System.out.println("une donnee");
//    }
*/


/*    @BeforeClass
    void before(){
        System.out.println("Avant test");
    }*/

    @BeforeMethod
    void setup() throws InterruptedException {
//        System.out.println("Avant chaque test");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(1000);
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterMethod
    void teardown(){
        System.out.printf("Apres chaque test");
        driver.quit();
    }



    // sauter un test : enabled=true
    @Test(enabled = false,dataProvider = "loginDataProvider")
    void loginInvalideTest(String userName, String pass) throws InterruptedException {

        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);

        String erreur = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).getText();
        Assert.assertEquals(erreur, "Invalid credentials");
    }

    public static String monStr= "hola";
//    @FindBy(xpath=monStr)
    WebElement hola;

    @Test(invocationCount = 10, threadPoolSize = 0)
    void loginValidateLogo() {
        WebElement logo = driver.findElement(By.xpath("//img[@alt='company-branding']"));
        Assert.assertTrue(logo.isDisplayed());

    }

    @DataProvider(name = "loginDataProvider")
    public Object[][] getData(){
        Object[][] data = {
                {"user1", "passw1"},
                {"user2", "passw2"},
                {"user3", "passw3"}
        };
        return data;
    }
}
