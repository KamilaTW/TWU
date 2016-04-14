package pageObjects;

import org.openqa.selenium.WebDriver;

/**
 * Created by kserafim on 4/14/16.
 */
public class ReserveConfirmation {

    WebDriver driver;
    ActionsOnPage actions ;

        public ReserveConfirmation(WebDriver driver) {
        this.driver=driver;
        actions = new ActionsOnPage(driver);
    }

    public void CheckReservation(){
        actions.validateMessageByXpath("html/body/div[1]/div[2]/div[1]", "Item reserved !");
        actions.ClickByName("profile");
        actions.validateMessageByXpath("html/body/div[1]/div[2]/div[1]", "Your details");
    }


}
