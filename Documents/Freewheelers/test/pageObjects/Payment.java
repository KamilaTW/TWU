package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by kserafim on 4/14/16.
 */
public class Payment {
    WebDriver driver;
    ActionsOnPage actions ;

    public Payment(WebDriver driver) {
        this.driver=driver;
        actions = new ActionsOnPage(driver);
    }

    private void ChooseCreditCardOption(){
        actions.selectOption("payment_option", "Credit Card");

    }

    private void FillTheFields(){
        actions.selectOption("payment_option", "Credit Card");
        actions.fillByName("name","Kamila credit card");
        actions.fillByName("ccNumber", "4111111111111111");
        actions.fillByName("expiry", "11-2020");
        actions.fillByName("csc", "534");
        actions.ClickById("payment_button");

    }

    private void ConfirmPayment(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.urlContains("reserve"));

    }

    private void ClosePopUp(){
        String handle = driver.getWindowHandle();
        driver.switchTo().window(handle);
    }

    public void Payment(){
        ChooseCreditCardOption();
        FillTheFields();
        ConfirmPayment();
        ClosePopUp();
    }

}



