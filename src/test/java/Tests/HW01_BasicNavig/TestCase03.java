package Tests.HW01_BasicNavig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestCase03 {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Multiple Buttons")).click();
        driver.findElement(By.xpath("//button [@onclick='button1()']")).click();
        BrowserUtils.wait(2);

        String expectedText = "Clicked on button one!";
        String actualText = driver.findElement(By.id("result")).getText();
        if(expectedText.equals(actualText)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("expected text: "+expectedText);
            System.out.println("actual text: "+actualText);
        }
        driver.quit();

    }
}
