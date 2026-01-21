package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.OnlinePaymentBlockPage;
import pages.PaymentPanelPage;

import static org.junit.jupiter.api.Assertions.*;

public class OnlinePaymentBlockPoTest {

    private WebDriver driver;
    private OnlinePaymentBlockPage mainPage;
    private PaymentPanelPage panelPage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        mainPage  = new OnlinePaymentBlockPage(driver);
        panelPage = new PaymentPanelPage(driver);

        mainPage.openMainPage();
        mainPage.acceptCookiesIfPresent();
        mainPage.scrollToPaymentBlock();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    /* 1. базовый контент блока */
    @Test
    void checkBaseBlockContent() {
        assertEquals("Онлайн пополнение без комиссии", mainPage.getBlockTitleText());
        assertTrue(mainPage.arePaymentLogosDisplayed());
        assertTrue(mainPage.isMoreInfoLinkDisplayed());
    }

    /* 2. плейсхолдеры всех 4 вариантов оплаты (через dropdown) */
    @Test
    void checkPlaceholdersForAllServices() {
        String[] services = {"Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность"};
        for (String service : services) {
            mainPage.selectService(service);
            assertEquals("Номер телефона", mainPage.getPhonePlaceholder());
            assertEquals("Сумма", mainPage.getSumPlaceholder());
        }
    }

    /* 3. заполнение «Услуги связи» → проверка данных в панели оплаты */
    @Test
    void checkPaymentPanelContent() {
        mainPage.fillTestPaymentForm();   // ввод 375297777777 и 30.00

        panelPage.waitForDialogOpen();    // ждём НЕ mat-, а обычный div.modal

        String amount      = panelPage.getAmount();
        String description = panelPage.getDescription();

        assertEquals("30.00 BYN", amount);
        assertTrue(description.contains("Оплата: Услуги связи") &&
                        description.contains("375297777777"),
                "Описание не содержит 'Оплата: Услуги связи' и/или номер");
    }
}