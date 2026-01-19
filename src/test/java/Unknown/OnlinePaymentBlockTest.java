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

    @Test
    void checkBlockTitle() {
        assertEquals("Онлайн пополнение без комиссии", page.getBlockTitleText());
    }

    @Test
    void checkPaymentLogos() {
        assertTrue(page.arePaymentLogosDisplayed());
    }

    @Test
    void checkMoreInfoLink() {
        assertTrue(page.isMoreInfoLinkDisplayed());
    }

    @Test
    void checkContinueButtonOpensPayment() {
        page.fillPhoneAndClickContinue();
        assertTrue(page.isPaymentFrameOpened());
    }
}