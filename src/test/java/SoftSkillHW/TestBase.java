package SoftSkillHW;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class TestBase {
    protected static WebDriver driver ;

    @BeforeTest
    public void loginTo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://campus.techno.study/user-courses");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement acceptCookies = driver.findElement(By.xpath("//*[@id=\"cconsent-bar\"]/div/div[2]/div/button"));
        acceptCookies.click();
        WebElement userName = driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]"));
        userName.sendKeys("aaaaaa.com");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]"));
        password.sendKeys("111111111");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[2]/form/button/span[1]"));
        loginButton.click();

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
