package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by kserafim on 4/13/16.
 */
public class ActionsOnPage {
    WebDriver driver;

    public ActionsOnPage(WebDriver driver) {
        this.driver=driver;
    }


    public void fillByName(String element, String value) {
        driver.findElement(By.name(element)).sendKeys(value);
    }

    protected void fillByXpath(String element, String value) {
        driver.findElement(By.xpath(element)).sendKeys(value);
    }

    public void ClickByName(String element) {
        driver.findElement(By.name(element)).click();
    }

    public void ClickByXpath(String element) {
        driver.findElement(By.xpath(element)).click();
    }

    public void ClickByLink(String element) {
        driver.findElement(By.linkText(element)).click();
    }

    public void ClickById(String element) {
        driver.findElement(By.id(element)).click();
    }

    public void ClickByCss(String element) {
        driver.findElement(By.cssSelector(element)).click();
    }

    public void webDriverWaitVisibleElementLocated(String element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
    }

    public void webDriverWaitVisibleElementLocated1(String element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(element)));
    }

    protected void webDriverWait(String element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(element))));
    }

    public void validateMessageByXpath(String element, String Message) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(element))));
        Assert.assertTrue(driver.findElement(By.xpath(element)).getText().contains(Message));
    }

    public void selectOption(String element, String message){
        new Select(driver.findElement(By.id(element))).selectByVisibleText(message);
    }
}
