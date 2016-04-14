package pageObjects;

import org.openqa.selenium.WebDriver;

/**
 * Created by kserafim on 4/13/16.
 */
public class LoginPage {
    WebDriver driver;
    ActionsOnPage actions ;

    public LoginPage(WebDriver driver) {
        this.driver=driver;
        actions = new ActionsOnPage(driver);
    }

    private void enterUserName(){
        actions.fillByName("j_username","ze");

    }

    private void enterPassword(){
        actions.fillByName("j_password", "abc123@A");

    }

    private void clickOnSubmitI(){
        actions.ClickByName("submit");

    }

    public void login(){
        enterUserName();
        enterPassword();
        clickOnSubmitI();
    }


}
