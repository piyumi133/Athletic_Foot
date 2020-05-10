package com.syscolab.athleticFoot.functions;

import com.syscolab.athleticFoot.pages.HomePage;

public class AhleticHome  {
    public static HomePage homePage= new HomePage();


    public static void navigateToHomePage()
    {
        homePage.navigateToAthleticWebPage();
    }
    public static void navigateToMyAccount(){homePage.clickLogin();}
    public static void quiteDriver()
    {
        homePage.quiteDriver();
    }
}
