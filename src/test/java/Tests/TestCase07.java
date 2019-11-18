package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestCase07 {
    public static void main(String[] args) {
        public static void main(String[] args) {
            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get("https://practice-cybertekschool.herokuapp.com");
            driver.findElement(By.linkText("Registration Form")).click();
            driver.findElement(By.name("email")).sendKeys("testers@email");
            BrowserUtils.wait(2);

            String expectedText="email address is not a valid";
            String actualText=driver.findElement(By.xpath())

            String expectedText2 = "Email format is not correct";

            String actualText = driver.findElement(By.xpath("//*[@id='registrationForm']/div[3]/div/small[2]")).getText();
            if(expectedText.equals(actualText)){
                System.out.println("Text available");
            } else {
                System.out.println("Text is not available");
            }
            driver.quit();

        }
    }
    }
}
