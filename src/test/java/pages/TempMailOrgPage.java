package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.regex.Pattern;

public class TempMailOrgPage extends AbstractPage {
    String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
    Pattern pattern = Pattern.compile(regex);

    public TempMailOrgPage(WebDriver driver) {
        super(driver);
    }

    public TempMailOrgPage openPage(String url) {
        return this;
    }
    @FindBy(xpath = "//input[@id='mail']")
    WebElement mailField;

    public TempMailOrgPage getAddress() {
        //new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElement(mailField, regex));
        new WebDriverWait(driver, 10).until(ExpectedConditions.textMatches((By) mailField, pattern));
        System.out.println(mailField.getAttribute("value"));
        return this;
    }
}
