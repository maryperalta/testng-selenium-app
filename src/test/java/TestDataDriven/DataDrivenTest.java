package TestDataDriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class DataDrivenTest {

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

    @AfterMethod
    void teardown(){
        System.out.printf("Apres chaque test");
        driver.quit();
    }

/*    @Test(dataProvider = "loginDataProvider")
    void login(String userName, String password) {
        System.out.println(userName+" "+password);
    }

    @Test(dataProvider = "loginDataProvider")
    void loginValideTest(String userName, String password) {
        System.out.println(userName+" "+password);
    }*/

    // sauter un test : enabled=true
    @Test(dataProvider = "loginDataProvider")
    void loginInvalideTest(String userName, String pass) throws InterruptedException {

        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);

        String erreur = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).getText();
        Assert.assertEquals(erreur, "Invalid credentials");
    }

    @Test(dataProvider = "loginDataProvider", priority = 1)
    void loginValidateLogo(String userName, String pass) {
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
