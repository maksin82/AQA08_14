package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class PaySection extends BasePage {

    @FindBy(xpath = "//div[@class='pay__wrapper']/h2")
    private WebElement actualHeading;

    @FindBy(xpath = "//div[@class='pay__partners']//img")
    private List<WebElement> paymentSystemLogos;

    @FindBy(linkText = "Подробнее о сервисе")
    private WebElement linkToService;

    @FindBy(id = "connection-phone")
    private WebElement phoneNumber;
    @FindBy(id = "connection-sum")
    private WebElement sumOfPayment;

    @FindBy(xpath = "//form[@id='pay-connection']//button[contains(text(),'Продолжить')]")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='pay-description__text']/span")
    private WebElement payDescription;


    public PaySection(WebDriver driver) {
        super(driver);
    }


    public String getSectionName() {
        return actualHeading.getText();
    }


    public List<String> getPaymentSystemList() {
        List<String> paymentsList = new ArrayList<>();
        for (WebElement element : paymentSystemLogos) {
            paymentsList.add(element.getAttribute("alt"));
        }

        return paymentsList;
    }


    public PaymentHelpPage clickAboutServiceLink() {
        linkToService.click();

        return new PaymentHelpPage(driver);
    }


    public PaySection fillPhone(String text) {
        phoneNumber.sendKeys(text);

        return this;
    }


    public PaySection fillSum(String text) {
        sumOfPayment.sendKeys(text);

        return this;
    }


    public PaySection clickContinue() {
        continueButton.click();
        return this;
    }


    public PaymentFramePage switchToIframe() {
        WebElement iframeElement = getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='bepaid-iframe']")));
        driver.switchTo().frame(iframeElement);
        return new PaymentFramePage(driver);
    }
}
