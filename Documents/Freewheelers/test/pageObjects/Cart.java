package pageObjects;

import org.openqa.selenium.WebDriver;

/**
 * Created by kserafim on 4/14/16.
 */
public class Cart {

    WebDriver driver;
    ActionsOnPage actions ;

    public Cart(WebDriver driver) {
        this.driver=driver;
        actions = new ActionsOnPage(driver);
    }

    private void addProductInCar(){
        actions.webDriverWait("html/body/div[1]/div[3]/table/tbody/tr[1]/td[7]/button");
        actions.ClickByXpath("html/body/div[1]/div[3]/table/tbody/tr[1]/td[7]/button");
    }

    private void accessCart(){
        actions.webDriverWaitVisibleElementLocated(".//*[@id='go-to-cart']");
        actions.ClickById("go-to-cart");
        actions.webDriverWaitVisibleElementLocated("html/body/div[1]/div[2]/div/span");
        actions.validateMessageByXpath("html/body/div[1]/div[2]/div/span", "Shopping Cart");

    }

    private void clickOnCheckout(){
        actions.ClickById("check_out_btn");

    }

    public void addProductAndCheckout(){
        addProductInCar();
        accessCart();
        clickOnCheckout();
    }
}

