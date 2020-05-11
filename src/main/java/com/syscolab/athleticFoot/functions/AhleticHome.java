package com.syscolab.athleticFoot.functions;

import com.syscolab.athleticFoot.pages.HomePage;
/*
Created By Piyumi
10/05/2021
*/
public class AhleticHome {
    public static HomePage homePage = new HomePage();


    public static void navigateToHomePage() {
        homePage.navigateToAthleticWebPage();
    }

    public static void navigateToMyAccount() {
        homePage.clickLogin();
    }

    public static void quiteDriver() {
        homePage.quiteDriver();
    }

    public static void wait(int num) {
        homePage.wait(num);
    }
}
