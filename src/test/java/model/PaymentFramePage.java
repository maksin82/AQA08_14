package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentFramePage extends BasePage{

    public PaymentFramePage(WebDriver driver) {
        super(driver);
    }

    public String getPaymentDescriptionText() {
        WebElement element = getWait5().until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@class='pay-description__text']/span"))));
        return element.getText();
    }
}
