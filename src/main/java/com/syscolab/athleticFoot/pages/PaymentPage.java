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
    private By txtCardNumber = By.id("credit-card-number");
    private By txtCSV = By.id("cvv");
    private By txtExpiry = By.id("expiration");
    private By lblBillingAddress = By.xpath("//*[@class='billing-address-details']");
    private By lblErrorInvalid = By.xpath("//*[@class='hosted-error']/span");
    private By iframeCardNumber = By.xpath("//*[@id='braintree_cc_number']/iframe");
    private By iframeCVV = By.xpath("//*[@class='hosted-control hosted-cid']/iframe");
    private By iframeExpiry = By.xpath("//*[@id='braintree_expirationDate']/iframe");

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
        syscoLabUI.switchToFrame(syscoLabUI.findElement(iframeCardNumber));
        syscoLabUI.sendKeys(txtCardNumber, creditCardNumber);
    }

    public void setTxtExpiry(String date) {
        syscoLabUI.switchToDefaultFrame();
        syscoLabUI.switchToFrame(syscoLabUI.findElement(iframeExpiry));
        syscoLabUI.sendKeys(txtExpiry, date);
        // syscoLabUI.sendKeys(txtExpiry,date);
    }

    public void setTxtCSV(String csv) {
        syscoLabUI.switchToDefaultFrame();
        syscoLabUI.switchToFrame(syscoLabUI.findElement(iframeCVV));
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
