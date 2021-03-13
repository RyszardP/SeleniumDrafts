package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TempMailOrgPage;



public class MainTest {
    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserRun() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
    @Test(description = "try get address")
    public void scenarioWithCopyingEmail()  {
        new TempMailOrgPage(this.driver)
                .openPage("https://temp-mail.org/")
                .getAddress();
    }

    @AfterMethod(alwaysRun = true)
    public void afterTestCompleted() {
        driver.quit();
        driver = null;
    }
}
