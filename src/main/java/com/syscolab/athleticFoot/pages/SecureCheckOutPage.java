package com.syscolab.athleticFoot.pages;

import com.syscolab.athleticFoot.utils.BasePage;
import org.openqa.selenium.By;

/*
Created By Piyumi
10/05/2021
*/

public class SecureCheckOutPage extends BasePage {
    private By txtFirstName = By.xpath("//*[@id='shipping-new-address-form']//input[@name='firstname']");
    private By txtLastName = By.xpath("//*[@id='shipping-new-address-form']//input[@name='lastname']");
    private By txtCompany = By.xpath("//*[@id='shipping-new-address-form']//input[@name='company']");
    private By txtSuburb = By.xpath("//*[@id='shipping-new-address-form']//input[@name='city']");
    private By txtPostCode = By.xpath("//*[@id='shipping-new-address-form']//input[@name='postcode']");
    private By txtState = By.xpath("//*[@id='shipping-new-address-form']//select[@name='region_id']");
    private By txtCountry = By.xpath("//*[@id='shipping-new-address-form']//select[@name='country_id'] ");
    private By txtAddress1 = By.xpath("//*[contains(@name,'shippingAddress.street.0')]/div/input");
    private By txtPhoneNumber = By.xpath("//*[contains(@name,'shippingAddress.telephone')]/div/div/div/input");
    private By btnContinue = By.xpath("//*[contains(@title, 'Continue')]");
    private By lblError = By.xpath("//*[@class='field-error mage-error']");
    private By drpDwnSubub = By.xpath("//*[@id='ui-id-1']/li/a");


    public String getFirstName() {
        return syscoLabUI.getValue(txtFirstName);
    }

    public String getLastName() {
        return syscoLabUI.getValue(txtLastName);
    }

    public void clickBtnContinue() {
        syscoLabUI.click(btnContinue);
    }

    public String getError() {
        return syscoLabUI.getText(lblError);
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
