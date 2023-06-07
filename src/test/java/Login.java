import config.env_target;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

public class Login extends env_target {
    @Test
    public void main(){
        //Set driverlocation path
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\drivers\\chromedriver.exe");
        //Maximize driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Set Url
        driver.get(baseurl);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(
                        "//input[@type='submit'][@data-test='login-button']"))
        );
        driver.findElement(By.name ("user-name")).sendKeys("standard_user");
        driver.findElement(By.id ("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath ("//input[@type='submit'][@data-test='login-button']")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(
                        "//span[@class='title'][contains(text(),'Products')]"))
        );

    }
}
