package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class OnlinePaymentBlockPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    /* =================== LOCATORS (real XPath) =================== */
    private final By cookieButton   = By.id("cookie-agree");
    private final By paymentBlock   = By.id("pay-section");
    private final By blockTitle     = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/h2");
    private final By paymentLogos   = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li/img");
    private final By moreInfoLink   = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/a");
    private final By servicesTab    = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button");
    private final By phoneInput     = By.cssSelector("input[type='tel']");
    private final By continueBtn    = By.xpath("//button[contains(.,'Продолжить')]");

    /* =================== CTOR =================== */
    public OnlinePaymentBlockPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    /* =================== ACTIONS =================== */
    public void openMainPage() {
        driver.get("https://www.mts.by");
        driver.manage().window().maximize();
    }

    public void acceptCookiesIfPresent() {
        try {
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(cookieButton));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
            wait.until(ExpectedConditions.invisibilityOf(btn));
        } catch (TimeoutException ignored) {}
    }

    public void scrollToPaymentBlock() {
        WebElement block = wait.until(ExpectedConditions.presenceOfElementLocated(paymentBlock));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'center'});", block);
        wait.until(driver -> (Boolean) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].offsetHeight > 0", block));
    }

    /* =================== CHECKS =================== */
    public String getBlockTitleText() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(blockTitle))
                .getText()
                .replaceAll("\\s+"," ")
                .trim();
    }

    public boolean arePaymentLogosDisplayed() {
        List<WebElement> logos = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(paymentLogos));
        return !logos.isEmpty();
    }

    public boolean isMoreInfoLinkDisplayed() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(moreInfoLink))
                .isDisplayed();
    }

    /* =================== PAYMENT FLOW ================== */
    public void fillPhoneAndClickContinue() {
        // 1. Раскрываем список
        WebElement tab = wait.until(ExpectedConditions.presenceOfElementLocated(servicesTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tab);

        // 2. Ждём появления поля телефона (в текущем DOM)
        WebElement phone = wait.until(ExpectedConditions.presenceOfElementLocated(phoneInput));

        // 3. Вводим номер через JS (перекрытие не мешает)
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", phone);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='297777777';", phone);
        ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('input', {bubbles:true}));", phone);

        // 4. Кликаем «Продолжить» (в текущем DOM)
        WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(continueBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    }

    public boolean isPaymentFrameOpened() {
        // 5. Ждём появления ВТОРОГО поля телефона – значит панель открылась
        return (Boolean) wait.until(driver -> (Boolean) ((JavascriptExecutor) driver)
                .executeScript("return document.querySelectorAll('input[type=\"tel\"]').length >= 2"));
    }
}