package com.syscolab.athleticFoot.pages;

import com.syscolab.athleticFoot.utils.BasePage;
import org.openqa.selenium.By;

/*
Created By Piyumi
11/05/2021
*/
public class PaymentPage extends BasePage {
    private By lblpaymentTitle = By.xpath("//*[@class='legend']/span");
    private By rdBtnPaypal = By.xpath("//*[@id='payment-method-braintree-paypal']/div[1]/label");
    private By rdBtnVisa = By.xpath("//*[@id='checkout-payment-method-load']/div/div/div[3]/div[1]/label");
    private By rdBtnAfterpay = By.id("afterpaypayovertime");
    private By txtCardNumber = By.cssSelector("#credit-card-number");
    private By txtCSV = By.cssSelector("#cvv");
    private By txtExpiry = By.cssSelector("#expiration");
    private By lblBillingAddress = By.xpath("//*[@class='billing-address-details']");
    private By lblErrorInvalid = By.cssSelector(".hosted-error > span");
    private By iframeCardDetails = By.cssSelector(".hosted-control > iframe");

    public String getTitleText() {
        return syscoLabUI.getText(lblpaymentTitle);
    }

    public void clickRadioPaypal() {
        syscoLabUI.click(rdBtnPaypal);
    }

    public void clickVisa() {

        syscoLabUI.click(rdBtnVisa);
    }

    public void clickRadioAterPAy() {
        syscoLabUI.click(rdBtnAfterpay);
    }

    public void setCreditCardNumber(String creditCardNumber) {
        syscoLabUI.switchToDefaultFrame();
        syscoLabUI.switchToFrame(syscoLabUI.findElements(iframeCardDetails).get(0));
        syscoLabUI.sendKeys(txtCardNumber, creditCardNumber);
    }

    public void setTxtExpiry(String date) {
        syscoLabUI.switchToDefaultFrame();
        syscoLabUI.switchToFrame(syscoLabUI.findElements(iframeCardDetails).get(1));
        syscoLabUI.sendKeys(txtExpiry, date);
        // syscoLabUI.sendKeys(txtExpiry,date);
    }

    public void setTxtCSV(String csv) {
        syscoLabUI.switchToDefaultFrame();
        syscoLabUI.switchToFrame(syscoLabUI.findElements(iframeCardDetails).get(2));
        syscoLabUI.sendKeys(txtCSV, csv);
        //  syscoLabUI.sendKeys(txtCSV,csv);
    }

    public String getBilingAddress() {
        return syscoLabUI.getText(lblBillingAddress);
    }

    public boolean isVisaRadioClickable() {
        return syscoLabUI.isClickable(rdBtnVisa);
    }

    public boolean isPaypalRadioClickable() {
        return syscoLabUI.isClickable(rdBtnPaypal);
    }

    public void wait(int num) {
        syscoLabUI.sleep(num);
    }

    public String getInvalidCardNumMsg() {
        syscoLabUI.switchToDefaultFrame();
        return syscoLabUI.findElements(lblErrorInvalid).get(0).getText();
    }

    public String getInvalidCardExpMsg() {
        syscoLabUI.switchToDefaultFrame();
        return syscoLabUI.findElements(lblErrorInvalid).get(1).getText();
    }

    public boolean isCardNumErrorDisplay() {
        syscoLabUI.switchToDefaultFrame();
        return syscoLabUI.findElements(lblErrorInvalid).get(0).isDisplayed();
    }

    public boolean isCardExpDateErrorDisplay() {
        syscoLabUI.switchToDefaultFrame();
        return syscoLabUI.findElements(lblErrorInvalid).get(1).isDisplayed();
    }
}
