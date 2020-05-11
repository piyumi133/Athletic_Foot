package com.syscolab.athleticFoot.pages;

import com.syscolab.athleticFoot.utils.BasePage;
import org.openqa.selenium.By;

/*
Created By Piyumi
10/05/2021
*/

public class ConfirmationOverlay extends BasePage {
    private By lblTitle = By.id("modal-content-37");
    private By btnClose = By.xpath("//*[class='action-secondary action-dismiss button -secondary']");
    private By btnOk = By.xpath("//*[class='action-primary action-accept button -secondary']");

    public void clickOk() {
        syscoLabUI.click(btnOk);
    }

    public void clickClose() {
        syscoLabUI.click(btnClose);
    }

    public String getTitle() {
        return syscoLabUI.getText(lblTitle);
    }

    public void wait(int num) {
        syscoLabUI.sleep(num);
    }
}
