package pl.b2b.eurobank.pages.homePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pl.b2b.eurobank.SingletonWebDriver;
import pl.b2b.eurobank.pages.savingsPage.MethodSavingsPage;

public class TestHomePage {

    private SingletonWebDriver singletonWebDriver;
    private WebDriver webDriver;
    private WebDriverWait wait;
    private MethodHomePage methodHomePage;
    private MethodSavingsPage methodSavingsPage;

    @BeforeClass
    public void setUp() {
        singletonWebDriver = SingletonWebDriver.getInstance();
        webDriver = singletonWebDriver.getWebDriver();
        wait = singletonWebDriver.getWait();
        methodHomePage = new MethodHomePage(webDriver, wait);
        methodSavingsPage = new MethodSavingsPage(webDriver,wait);
    };

    @Test
    public void goToRecipientList() {
        methodHomePage.goToRecipientPage();
        Assert.assertEquals(methodHomePage.getAssertion(), "\n" +
                "                            lista odbiorców\n" +
                "                        ");
    }

    @Test (dependsOnGroups = {"recipentGroup"})
    public void goToSavingsPage() {
        methodSavingsPage.goToSavingsPage();
        Assert.assertEquals(methodSavingsPage.goToSavingsPage().getAttribute("innerHTML"),"\n" +
                "                            oszczędności\n" +
                "                        ");
    }

}
