package pl.b2b.eurobank.pages.homePage;

import com.sun.jna.platform.unix.X11;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MethodHomePage {

    private WebDriver webDriver;
    private WebDriverWait wait;

    public MethodHomePage(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = DataHomePaage.PAYMENT)
    private WebElement payment;

    @FindBy(xpath = DataHomePaage.RECIPIENT)
    private WebElement recipient;

    @FindBy(xpath = DataHomePaage.ASSERTION_RECIPIENT)
    private WebElement assertionRecipient;

    @FindBy(xpath = DataHomePaage.SAVINGS)
    private WebElement savings;

    private void clickPayment() {
        wait.until(ExpectedConditions.elementToBeClickable(payment));
        payment.click();
    }

    private void clickRecipient() {
        wait.until(ExpectedConditions.elementToBeClickable(recipient));
        recipient.click();
    }

    public void clickSavings(){
        wait.until(ExpectedConditions.elementToBeClickable(savings));
        savings.click();
    }

    public void goToRecipientPage(){
        clickPayment();
        clickRecipient();
    }

    public String getAssertion(){
        return assertionRecipient.getAttribute("innerHTML");
    }

}
