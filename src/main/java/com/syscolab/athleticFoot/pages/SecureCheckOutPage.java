package com.syscolab.athleticFoot.pages;

import com.syscolab.athleticFoot.utils.BasePage;
import org.openqa.selenium.By;

public class SecureCheckOutPage extends BasePage {
    private By txtFirstName= By.cssSelector("#shipping-new-address-form > div > div >input[name='firstname']");
    private By txtLastName=By.cssSelector("#shipping-new-address-form > div > div >input[name='lastname']");
    private By btnContinue=By.xpath("//*[contains(@title, 'Continue')]");
    private By lblErrorAddress1 =By.xpath("//*[@class='field-error mage-error']");

    public String getFirstName()
    {
        return syscoLabUI.getValue(txtFirstName);
    }
    public String getLastName()
    {
        return syscoLabUI.getValue(txtLastName);
    }
    public void clickBtnContinue()
    {
      syscoLabUI.click(btnContinue);
    }
    public String getErrorAddress1()
    {
      return   syscoLabUI.getText(lblErrorAddress1);
    }
}
