package com.syscolab.athleticFoot.functions;

import com.syscolab.athleticFoot.pages.SecureCheckOutPage;
/*
Created By Piyumi
10/05/2021
*/

public class SecureCheckOut {
    public static SecureCheckOutPage secureCheckOutPage = new SecureCheckOutPage();

    public static String getFirstName() {
        return secureCheckOutPage.getFirstName();
    }

    public static String getLastName() {
        return secureCheckOutPage.getLastName();
    }

    public static void clickSecureCheckOutButton() {
        secureCheckOutPage.clickBtnContinue();
    }

    public static String getError() {
        return secureCheckOutPage.getError();
    }

    public static void setAddress1(String address1) {
        secureCheckOutPage.setTxtAddress1(address1);
    }

    public static void setSbuburb() {
        secureCheckOutPage.setSuburb();
    }

    public static void setPhoneNumber(String phoneNumber) {
        secureCheckOutPage.setTxtPhoneNumber(phoneNumber);
    }

    public static void wait(int num) {
        secureCheckOutPage.wait(num);
    }

}
