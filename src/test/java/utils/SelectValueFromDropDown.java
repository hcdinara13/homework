package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectValueFromDropDown {

    public static void selectValueFromDropDown (WebElement element, String value){

        Select select = new Select(element);
        select.selectByVisibleText(value);
    }
}
