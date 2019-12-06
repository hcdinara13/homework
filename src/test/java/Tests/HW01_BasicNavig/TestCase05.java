package Tests.HW01_BasicNavig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestCase05 {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.name("lastname")).sendKeys("123");
        BrowserUtils.wait(2);

        String expectedText="The last name can only consist of alphabetical letters and dash";
        String actualText = driver.findElement(By.xpath("//*[@id='registrationForm']/div[2]/div/small[3]")).getText();
        if(expectedText.equals(actualText)){
            System.out.println("Text is displayed");
        } else {
            System.out.println("Text is not displayed");
        }
        driver.quit();

    }
}
