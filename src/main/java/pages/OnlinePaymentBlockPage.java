package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class OnlinePaymentBlockPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    /* ---------- блок оплаты ---------- */
    private final By paymentBlock   = By.id("pay-section");
    private final By blockTitle     = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/h2");
    private final By paymentLogos   = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]//img");
    private final By moreInfoLink   = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/a");

    /* ---------- выпадающий список (select) ---------- */
    private final By serviceSelect = By.xpath("//*[@id='pay-section']//select");

    /* ---------- поля (точные id) ---------- */
    private final By phoneInput     = By.id("connection-phone");
    private final By sumInput       = By.id("connection-sum");
    private final By continueBtn    = By.xpath("//*[@id='pay-section']//button[contains(.,'Продолжить')]");

    private final By cookieButton   = By.id("cookie-agree");

    public OnlinePaymentBlockPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

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
        wait.until(d -> (Boolean) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].offsetHeight > 0", block));
    }

    /* ---------- базовый контент ---------- */
    public String getBlockTitleText() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(blockTitle))
                .getText().replaceAll("\\s+", " ").trim();
    }

    public boolean arePaymentLogosDisplayed() {
        return !wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(paymentLogos)).isEmpty();
    }

    public boolean isMoreInfoLinkDisplayed() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(moreInfoLink)).isDisplayed();
    }

    /* ---------- выбор варианта из dropdown ---------- */
    public void selectService(String visibleText) {
        WebElement select = wait.until(ExpectedConditions.presenceOfElementLocated(serviceSelect));
        new Select(select).selectByVisibleText(visibleText);
    }

    /* ---------- плейсхолдеры ---------- */
    public String getPhonePlaceholder() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(phoneInput))
                .getDomProperty("placeholder");
    }

    public String getSumPlaceholder() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(sumInput))
                .getDomProperty("placeholder");
    }

    /* ---------- заполнение и переход в панель ---------- */
    public void fillServicesForm(String phone, String sum) {
        WebElement phoneEl = wait.until(ExpectedConditions.presenceOfElementLocated(phoneInput));
        WebElement sumEl   = wait.until(ExpectedConditions.presenceOfElementLocated(sumInput));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].value=''; arguments[0].value=arguments[1]; " +
                        "arguments[0].dispatchEvent(new Event('input',{bubbles:true}));", phoneEl, phone);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].value=''; arguments[0].value=arguments[1]; " +
                        "arguments[0].dispatchEvent(new Event('input',{bubbles:true}));", sumEl, sum);

        WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(continueBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    }

    /* === ОДНА СТРОЧКА ДЛЯ ТЕСТА === */
    public void fillTestPaymentForm() {
        selectService("Услуги связи");
        fillServicesForm("297777777", "30.00");
    }
}