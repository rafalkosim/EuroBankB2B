package pl.b2b.eurobank.pages.paymentPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MethodRecipient {

    private WebDriver webDriver;
    private WebDriverWait wait;

    public MethodRecipient(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
        PageFactory.initElements(webDriver, this);
    }

    @FindAll(@FindBy(xpath = DataRecipient.TABLE))
    private List<WebElement> recipients;

    @FindBy(xpath = DataRecipient.EDIT)
    private WebElement clickEdit;

    @FindBy(xpath = DataRecipient.ASSERTION)
    private WebElement assertion;

    @FindBy(xpath = DataRecipient.CLICK_NEXT)
    private WebElement clickNext;

    @FindBy(xpath = DataRecipient.TOKEN)
    private WebElement token;

    @FindBy(xpath = DataRecipient.CONFIRM)
    private WebElement confirm;

    @FindBy(xpath = DataRecipient.ASSERTION_EXIT)
    private WebElement assertionExit;

    public String editRecipient(){
        for (WebElement recipient : recipients) {
            String name = recipient.getAttribute("innerHTML");
            if(name.equals("\n" + "                                        Gosia\n" + "                                    ")){
                recipient.click();
                clickEdit.click();
                break;
            }
        }
        String result = assertion.getAttribute("innerHTML");
        return result;
    }

    private void clickNext(){
        wait.until(ExpectedConditions.visibilityOf(clickNext));
        clickNext.click();
    }
    private void token(String tokenNr){
        wait.until(ExpectedConditions.visibilityOf(token));
        token.sendKeys(tokenNr);
    }
    private void confirm(){
        wait.until(ExpectedConditions.visibilityOf(confirm));
        confirm.click();
    }

    public String exitEdit(String tokenNr){
        clickNext();
        token(tokenNr);
        confirm();
        String resutl = assertionExit.getAttribute("innerHTML");
        return resutl;
    }
}
