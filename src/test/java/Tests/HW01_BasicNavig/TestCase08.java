package Tests.HW01_BasicNavig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestCase08 {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.name("phone")).sendKeys("5711234354");
        BrowserUtils.wait(2);

        String actualWarning = driver.findElement(By.xpath("//*[@id='registrationForm']/div[6]/div/small[2]")).getText();
        String expectedWarning = "Phone format is not correct";

        if(expectedWarning.equals(actualWarning)) {
                System.out.println("TEST PASSED");
            } else {
                System.out.println("TEST FAILED");
                System.out.println("expected text: " + expectedWarning);
                System.out.println("actual text: " + actualWarning);
            }
        driver.quit();
        }

    }

