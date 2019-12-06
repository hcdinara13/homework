package Tests.HW01_BasicNavig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;


public class TestCase02 {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");

        int totalLinks = driver.findElements(By.xpath("//li [@class='list-group-item']")).size();
        if(totalLinks == 48) {
            System.out.println("Total Links: " + totalLinks);
        }else{
            System.out.println("Wrong data");
        }
        driver.quit();
    }
}
