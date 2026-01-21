package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPanelPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    /* локаторы  */
    private final By iframe = By.cssSelector("iframe[allowpaymentrequest]");
    private final By amount = By.xpath("//span[contains(.,'30.00 BYN')]");
    private final By description = By.xpath("//span[contains(.,'Оплата:')]");

    public PaymentPanelPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void waitForDialogOpen() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
        wait.until(ExpectedConditions.visibilityOfElementLocated(amount));
    }

    public String getAmount() {
        return driver.findElement(amount).getText().trim();
    }

    public String getDescription() {
        return driver.findElement(description).getText().trim();
    }
}