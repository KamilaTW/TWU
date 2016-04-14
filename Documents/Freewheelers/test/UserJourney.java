import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;

/**
 * Created by kserafim on 4/7/16.
 */
public class UserJourney {
    public WebDriver driver;
    private static WebElement element;
    ActionsOnPage actions ;
    LoginPage loginPage;
    Cart cart;
    Payment payment;
    ReserveConfirmation confirmation;

    @Before
    public void setUp() {

        driver = new FirefoxDriver();
        driver.get("http://qa-env.twu48proj1.freewheelers.bike/login");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        cart = new  Cart(driver);
        payment = new Payment(driver);
        confirmation = new ReserveConfirmation(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void AddItemToCart() throws InterruptedException {
        actions = new ActionsOnPage(driver);
        loginPage.login();
        cart.addProductAndCheckout();
        payment.Payment();
        confirmation.CheckReservation();

    }


}