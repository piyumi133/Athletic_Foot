package com.syscolab.athleticFoot.pages;

import com.syscolab.athleticFoot.utils.BasePage;
import org.openqa.selenium.By;

public class MyAccountPage extends BasePage {


    private By btnLoign = By.id("send2");
    private By txtEmail =By.id("email");
    private By txtPassword =By.id("pass");
    private By lblUserName=By.xpath("//*[@class='greet welcome']");
    private By lblEmailErrorMsg=By.id("email-error");
    private By lblPasswordErrorMsg=By.id("pass-error");
    private By divErrorDiv=By.xpath("//*[@class='page messages']");

    public  boolean isBtnLoginExists()
    {
       return syscoLabUI.isDisplayed(btnLoign);
    }

    public void setEmail(String email)
    {
        syscoLabUI.sendKeys(txtEmail,email);
    }
    public void setPassword(String password)
    {
        syscoLabUI.sendKeys(txtPassword,password);
    }
    public void clickLogin()
    {
        syscoLabUI.click(btnLoign);
        syscoLabUI.sleep(2);
    }
    public void refresh()
    {
        syscoLabUI.refreshBrowser();
        syscoLabUI.sleep(3);
    }
    public String getUserName()
    {
       return syscoLabUI.getText(lblUserName);
    }
    public  String getEmailErrorMsg()
    {
        return syscoLabUI.getText(lblEmailErrorMsg);
    }
    public  String getPasswordErrorMsg()
    {
        return syscoLabUI.getText(lblPasswordErrorMsg);
    }
    public  String getErrorMsgInvalidCredentials()
    {
        return syscoLabUI.getText(divErrorDiv);
    }
    public  String getErrorMsgInvlaidEmailPattern()
    {
        return syscoLabUI.getText(lblEmailErrorMsg);
    }
}
