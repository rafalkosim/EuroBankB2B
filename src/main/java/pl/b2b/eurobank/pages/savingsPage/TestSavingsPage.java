package pl.b2b.eurobank.pages.savingsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pl.b2b.eurobank.SingletonWebDriver;

public class TestSavingsPage {

    private SingletonWebDriver singletonWebDriver;
    private WebDriver webDriver;
    private WebDriverWait wait;
    private MethodSavingsPage methodSavingsPage;

    @BeforeClass
    public void setUp() {
        singletonWebDriver = SingletonWebDriver.getInstance();
        webDriver = singletonWebDriver.getWebDriver();
        wait = singletonWebDriver.getWait();
        methodSavingsPage = new MethodSavingsPage(webDriver, wait);
    }

}
