package Tests.HW01_BasicNavig;

import jdk.internal.misc.FileSystemOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestCase07 {
    public static void main(String[] args) {
            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get("https://practice-cybertekschool.herokuapp.com");
            driver.findElement(By.linkText("Registration Form")).click();
            driver.findElement(By.name("email")).sendKeys("testers@email");
            BrowserUtils.wait(2);

            String expectedText="email address is not a valid";
           String actualText=driver.findElement(By.xpath("//*[@id='registrationForm']/div[4]/div/small[2]")).getText();

            String expectedText2 = "Email format is not correct";
            String actualText2=driver.findElement(By.xpath("//*[@id='registrationForm']/div[4]/div/small[3]")).getText();

            if(expectedText.equals(actualText)) {
                if (expectedText2.equals(actualText2)) {
                    System.out.println("Text available");
                } else {
                    System.out.println("Text is not available");
                    System.out.println("expected text: " + expectedText + " " + expectedText2);
                    System.out.println("actual text: " + actualText + " " + actualText2);
                }
            }
            driver.quit();

        }
    }


