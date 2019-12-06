package Tests.HW01_BasicNavig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestCase06 {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.name("username")).sendKeys("user");
        BrowserUtils.wait(2);

        String expectedText="The username must be more than 6 and less than 30 characters long";
        String actualText = driver.findElement(By.xpath("//*[@id='registrationForm']/div[3]/div/small[2]")).getText();
        if(expectedText.equals(actualText)){
            System.out.println("Text is displayed");
        } else {
            System.out.println("Text is not displayed");
        }
        driver.quit();



    }
}
