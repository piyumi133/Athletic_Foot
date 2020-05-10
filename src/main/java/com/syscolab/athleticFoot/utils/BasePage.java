package com.syscolab.athleticFoot.utils;

import com.syscolab.qe.core.ui.SyscoLabUI;


public class BasePage {
    protected static SyscoLabUI syscoLabUI;

    public BasePage(){

    }
public static void quiteDriver()
{
    syscoLabUI.quit();
}

}
