package model;

import org.openqa.selenium.WebDriver;

public class PaymentHelpPage extends BasePage {
    public PaymentHelpPage(WebDriver driver) {
        super(driver);
    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }
}
