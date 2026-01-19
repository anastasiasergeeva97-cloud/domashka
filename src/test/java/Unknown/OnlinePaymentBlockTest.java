package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.OnlinePaymentBlockPage;

import static org.junit.jupiter.api.Assertions.*;

public class OnlinePaymentBlockTest {

    private WebDriver driver;
    private OnlinePaymentBlockPage page;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        page  = new OnlinePaymentBlockPage(driver);
        page.openMainPage();
        page.acceptCookiesIfPresent();
        page.scrollToPaymentBlock();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
//тест 1
    @Test
    void checkBlockTitle() {
        assertEquals("Онлайн пополнение без комиссии", page.getBlockTitleText());
    }
//тест 2
    @Test
    void checkPaymentLogos() {
        assertTrue(page.arePaymentLogosDisplayed());
    }
//тест 3
    @Test
    void checkMoreInfoLink() {
        assertTrue(page.isMoreInfoLinkDisplayed());
    }
//тест 4
    @Test
    void checkContinueButtonOpensPayment() {
        page.fillPhoneAndClickContinue();
        assertTrue(page.isPaymentFrameOpened());
    }
}