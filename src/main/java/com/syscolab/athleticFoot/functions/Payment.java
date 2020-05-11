package com.syscolab.athleticFoot.functions;

import com.syscolab.athleticFoot.pages.PaymentPage;

/*
Created By Piyumi
11/05/2021
*/

public class Payment {
    public static PaymentPage paymentPage = new PaymentPage();

    public static String getTitleText() {
        return getTitleText();
    }

    public static void clickRadioPaypal() {
        paymentPage.clickRadioPaypal();
    }

    public static void clickVisa() {
        paymentPage.clickVisa();
    }

    public static void clickRadioAterPAy() {
        paymentPage.clickRadioAterPAy();
    }

    public static void setCreditCardNumber(String creditCardNumber) {
        paymentPage.setCreditCardNumber(creditCardNumber);
    }

    public static void setTxtExpiry(String date) {
        paymentPage.setTxtExpiry(date);
    }

    public static void setTxtCSV(String csv) {
        paymentPage.setTxtCSV(csv);
    }

    public static String getBilingAddress() {
        return paymentPage.getBilingAddress();
    }

    public static boolean isPaypalRadioClickable() {
        return paymentPage.isPaypalRadioClickable();
    }

    public static boolean isVisaRadioClickable() {
        return paymentPage.isVisaRadioClickable();
    }

    public static void wait(int num) {
        paymentPage.wait(num);
    }

    public static String getInvalidCardNumMsg() {
        return paymentPage.getInvalidCardNumMsg();
    }

    public static String getIvalidCardExpMsg() {
        return paymentPage.getInvalidCardExpMsg();
    }

    public static boolean isCardNumErrorDisplay() {
        return paymentPage.isCardNumErrorDisplay();
    }

    public static boolean isCardExpDateErrorDisplay() {
        return paymentPage.isCardExpDateErrorDisplay();
    }
}
