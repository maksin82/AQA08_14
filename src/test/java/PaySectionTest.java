import jdk.jfr.Description;
import model.PaySection;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class PaySectionTest extends BaseTest {
    private static final String PHONE_DATA = "297777777";
    private static final String AMOUNT_DATA = "297";

    @Test
    @Description("Проверить название блока")
    public void verifyNoFeeOnlineTopUpSection() {
        final String expectedHeading = "Онлайн пополнение" + "\n" + "без комиссии";

        String actualHeading = new PaySection(driver)
                .getSectionName();

        Assert.assertEquals(actualHeading, expectedHeading);
    }

    @Description("Проверить наличие логотипов платёжных систем")
    @Test
    public void verifyPaymentSystemLogosDisplayed() {
        final List<String> expectedElements = Arrays.asList(
                "Visa",
                "Verified By Visa",
                "MasterCard",
                "MasterCard Secure Code",
                "Белкарт"
        );

        List<String> actualElements = new PaySection(driver)
                .getPaymentSystemList();

        Assert.assertEquals(actualElements, expectedElements);
    }

    @Description("Проверить работу ссылки «Подробнее о сервисе»")
    @Test
    public void verifyServiceDetailsLink() {
        final String expectedURL = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";

        String link = new PaySection(driver)
                .clickAboutServiceLink()
                .getCurrentUrl();

        Assert.assertEquals(link, expectedURL);
    }


    @Description("Проверить работу кнопки «Продолжить»")
    @Test
    public void verifyContinueButtonWorks() {
        String actDataText = new PaySection(driver)
                .fillPhone(PHONE_DATA)
                .fillSum(AMOUNT_DATA)
                .clickContinue()
                .switchToIframe()
                .getPaymentDescriptionText();

        Assert.assertEquals(actDataText, "Оплата: Услуги связи Номер:" + "375" + PHONE_DATA);
    }
}
