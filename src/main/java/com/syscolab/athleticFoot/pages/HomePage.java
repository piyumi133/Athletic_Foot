package com.syscolab.athleticFoot.pages;

import com.syscolab.athleticFoot.common.Constants;
import com.syscolab.athleticFoot.utils.BasePage;
import com.syscolab.athleticFoot.utils.DriverSetUpUtil;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;

/*
Created By Piyumi
10/05/2021
*/

public class HomePage extends BasePage {
    //  protected static SyscoLabUI syscoLabUI;

    private By lnkLogin = By.xpath("//*[@class='authorization-link -notlogin']");

    public void navigateToAthleticWebPage() {
        DriverSetUpUtil.setToRunLocally();
        syscoLabUI = new SyscoLabWUI(null);
        syscoLabUI.navigateTo(Constants.APP_URL);
        syscoLabUI.driver.manage().window().maximize();

    }

    public static void quiteDriver() {
        syscoLabUI.quit();
    }

    public void clickLogin() {
        syscoLabUI.click(lnkLogin);
    }

    public void wait(int num) {
        syscoLabUI.sleep(num);
    }
}
