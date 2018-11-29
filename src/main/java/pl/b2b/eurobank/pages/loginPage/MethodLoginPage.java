package pl.b2b.eurobank.pages.loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MethodLoginPage {

    private WebDriver webDriver;
    private WebDriverWait wait;

    public MethodLoginPage(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = DataLoginPage.LOGIN)
    private WebElement login;

    @FindBy(xpath = DataLoginPage.LOGIN_NEXT)
    private WebElement loginNext;

    @FindBy(xpath = DataLoginPage.PASSWORD)
    private WebElement password;

    @FindBy(xpath = DataLoginPage.SIG_IN)
    private WebElement sigIn;

    @FindBy(xpath = DataLoginPage.ASSERTION_LOGIN)
    private WebElement assertion;

    private void sendLogin(String strLogin) {
        wait.until(ExpectedConditions.visibilityOf(login));
        login.sendKeys(strLogin);
    }

    private void clickNext() {
        wait.until(ExpectedConditions.visibilityOf(loginNext));
        loginNext.click();
    }

    private void sendPassword(String strPassword) {
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(strPassword);
    }

    private void clickSingIn() {
        wait.until(ExpectedConditions.visibilityOf(sigIn));
        sigIn.click();
    }

    public String login(String strLogin, String strPassword){
        sendLogin(strLogin);
        clickNext();
        sendPassword(strPassword);
        clickSingIn();
        return assertion.getAttribute("innerHTML");
    }

}
