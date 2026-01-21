package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.OnlinePaymentBlockPage;
import pages.PaymentPanelPage;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Онлайн-платежи")
@Feature("Блок «Онлайн пополнение без комиссии»")
public class OnlinePaymentBlockPoTest {

    private WebDriver driver;
    private OnlinePaymentBlockPage mainPage;
    private PaymentPanelPage panelPage;

    @BeforeEach
    @Step("Открыть сайт mts.by и принять куки")
    void setUp() {
        driver = new ChromeDriver();
        mainPage  = new OnlinePaymentBlockPage(driver);
        panelPage = new PaymentPanelPage(driver);

        mainPage.openMainPage();
        mainPage.acceptCookiesIfPresent();
        mainPage.scrollToPaymentBlock();
    }

    @AfterEach
    @Step("Закрыть браузер")
    void tearDown() {
        driver.quit();
    }
//1
    @Test
    @Story("Базовый контент блока оплаты")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка заголовка, логотипов и ссылки 'Подробнее'")
    void checkBaseBlockContent() {
        assertEquals("Онлайн пополнение без комиссии", mainPage.getBlockTitleText());
        assertTrue(mainPage.arePaymentLogosDisplayed(), "Логотипы не отображаются");
        assertTrue(mainPage.isMoreInfoLinkDisplayed(), "Ссылка 'Подробнее' не отображается");
    }
    //2
    @Test
    @Story("Плейсхолдеры полей")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка плейсхолдеров для всех 4 типов услуг")
    void checkPlaceholdersForAllServices() {
        String[] services = {"Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность"};
        for (String service : services) {
            mainPage.selectService(service);
            assertEquals("Номер телефона", mainPage.getPhonePlaceholder());
            assertEquals("Сумма", mainPage.getSumPlaceholder());
        }
    }
//3
    @Test
    @Story("Проверка данных в модальном окне оплаты")
    @Severity(SeverityLevel.CRITICAL)
    @Description("После ввода номера и суммы должны отображаться корректные значения в окне оплаты")
    void checkPaymentPanelContent() {
        mainPage.fillTestPaymentForm();          // 375297777777 / 30.00
        panelPage.waitForDialogOpen();

        String amount      = panelPage.getAmount();
        String description = panelPage.getDescription();

        assertEquals("30.00 BYN", amount);
        assertTrue(description.contains("Оплата: Услуги связи") &&
                        description.contains("375297777777"),
                "Описание не содержит ожидаемых данных");
    }
}