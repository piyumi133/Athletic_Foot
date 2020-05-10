package com.syscolab.athleticFoot.functions;

import com.syscolab.athleticFoot.pages.SecureCheckOutPage;

public class SecureCheckOut {
    public static SecureCheckOutPage secureCheckOutPage =new SecureCheckOutPage();

    public static String getFirstName()
    {
      return   secureCheckOutPage.getFirstName();
    }
    public static String getLastName()
    {
        return secureCheckOutPage.getLastName();
    }
    public static void clickSecureCheckOutButton()
    {
        secureCheckOutPage.clickBtnContinue();
    }
    public static String getAddress1Error()
    {
        return secureCheckOutPage.getErrorAddress1();
    }


}
