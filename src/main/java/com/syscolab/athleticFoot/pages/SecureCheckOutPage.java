package com.syscolab.athleticFoot.pages;

import com.syscolab.athleticFoot.utils.BasePage;
import org.openqa.selenium.By;

/*
Created By Piyumi
10/05/2021
*/

public class SecureCheckOutPage extends BasePage {
    private By txtFirstName = By.cssSelector("#shipping-new-address-form > div > div >input[name='firstname']");
    private By txtLastName = By.cssSelector("#shipping-new-address-form > div > div >input[name='lastname']");
    private By txtCompany = By.cssSelector("#shipping-new-address-form > div > div > input[name='company']");
    private By txtSuburb = By.cssSelector("#shipping-new-address-form > div > div > input[name='city']");
    private By txtPostCode = By.cssSelector("#shipping-new-address-form > div > div > input[name='postcode']");
    private By txtState = By.cssSelector("#shipping-new-address-form > div > div  > select[name='region_id'] ");
    private By txtCountry = By.cssSelector("#shipping-new-address-form > div > div  > select[name='country_id'] ");
    private By txtAddress1 = By.cssSelector("div[name='shippingAddress.street.0'] > div > input");
    private By txtPhoneNumber = By.cssSelector("div[name='shippingAddress.telephone'] > div > div > div > input");
    private By btnContinue = By.xpath("//*[contains(@title, 'Continue')]");
    private By lblErrorAddress1 = By.xpath("//*[@class='field-error mage-error']");
    private By lblErrorSubRub = By.xpath("//*[@class='field-error mage-error']");
    private By lblErrorState = By.xpath("//*[@class='field-error mage-error']");
    private By lblErrorPostCode = By.xpath("//*[@class='field-error mage-error']");
    private By lblErrorPhone = By.xpath("//*[@class='field-error mage-error']");
    private By drpDwnSubub = By.cssSelector("#ui-id-1 > li > a");


    public String getFirstName() {
        return syscoLabUI.getValue(txtFirstName);
    }

    public String getLastName() {
        return syscoLabUI.getValue(txtLastName);
    }

    public void clickBtnContinue() {
        syscoLabUI.click(btnContinue);
    }

    public String getErrorAddress1() {
        return syscoLabUI.getText(lblErrorAddress1);
    }

    public String getErrorSuburb() {
        return syscoLabUI.getText(lblErrorSubRub);
    }

    public String getErrorState() {
        return syscoLabUI.getText(lblErrorState);
    }

    public String getErrorPostalCode() {
        return syscoLabUI.getText(lblErrorPostCode);
    }

    public String getErrorPhone() {
        return syscoLabUI.getText(lblErrorPhone);
    }

    public void setTxtAddress1(String address1) {
        syscoLabUI.sendKeys(txtAddress1, address1);
    }

    public void setSuburb() {
        syscoLabUI.sendKeys(txtSuburb, "AUSTRALIAN NATIONAL UNIVERSITY");
        syscoLabUI.sleep(3);
        syscoLabUI.click(drpDwnSubub);
        syscoLabUI.sleep(3);

    }

    public void setTxtPhoneNumber(String phoneNumber) {
        //syscoLabUI.clear(txtPhoneNumber);
        syscoLabUI.sendKeys(txtPhoneNumber, phoneNumber);
    }

    public void wait(int num) {
        syscoLabUI.sleep(num);
    }
}
