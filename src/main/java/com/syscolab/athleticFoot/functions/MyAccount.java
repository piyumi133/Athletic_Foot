package com.syscolab.athleticFoot.functions;

import com.syscolab.athleticFoot.pages.MyAccountPage;

/*
Created By Piyumi
10/05/2021
*/

public class MyAccount {
    public static MyAccountPage myAccountPage = new MyAccountPage();


    public static boolean isLoginButtonAvailble() {
        return myAccountPage.isBtnLoginExists();
    }

    public static void navigateToAccountPage() {
        AhleticHome.navigateToHomePage();
        AhleticHome.navigateToMyAccount();
    }

    public static void login(String email, String password) {
        myAccountPage.setEmail(email);
        myAccountPage.setPassword(password);
        myAccountPage.clickLogin();
    }

    public static String getUserName() {
        return myAccountPage.getUserName();
    }

    public static String getEmailErrorMsg() {
        return myAccountPage.getEmailErrorMsg();
    }

    public static String getPasswordErrorMsg() {
        return myAccountPage.getPasswordErrorMsg();
    }

    public static String getErrorMsgForInvalidCredentials() {
        return myAccountPage.getErrorMsgInvalidCredentials();
    }

    public static String getErrorMsgInvlaidEmailPattern() {
        return myAccountPage.getErrorMsgInvlaidEmailPattern();
    }

    public static void refresh() {
        myAccountPage.refresh();
    }

    public static void wait(int num) {
        myAccountPage.wait(num);
    }

}
