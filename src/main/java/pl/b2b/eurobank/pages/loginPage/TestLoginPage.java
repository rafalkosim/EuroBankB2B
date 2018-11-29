package pl.b2b.eurobank.pages.loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pl.b2b.eurobank.SingletonWebDriver;

public class TestLoginPage {

    private SingletonWebDriver singletonWebDriver;
    private WebDriver webDriver;
    private WebDriverWait wait;
    private MethodLoginPage methodLoginPage;

    @BeforeClass
    public void setUp() {
        singletonWebDriver = SingletonWebDriver.getInstance();
        webDriver = singletonWebDriver.getWebDriver();
        wait = singletonWebDriver.getWait();
        methodLoginPage = new MethodLoginPage(webDriver, wait);
    }

    @Test
    @Parameters({"login", "password"})
    public void openHomePageTest(@Optional("login12345")String login, @Optional("12345678")String password) {
        webDriver.get(DataLoginPage.EUROBANK_URL);
        Assert.assertEquals( methodLoginPage.login(login, password), "eurobank na co dzień");
    }

}
