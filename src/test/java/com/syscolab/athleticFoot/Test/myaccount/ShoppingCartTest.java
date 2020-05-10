package com.syscolab.athleticFoot.Test.myaccount;

import com.syscolab.athleticFoot.functions.AhleticHome;
import com.syscolab.athleticFoot.functions.MyAccount;
import com.syscolab.athleticFoot.functions.ShoppingCart;
import com.syscolab.athleticFoot.utils.TestBase;
import org.junit.Before;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ShoppingCartTest extends TestBase {

    @BeforeMethod
    public void loginToSite()
    {
        AhleticHome.navigateToHomePage();
        AhleticHome.navigateToMyAccount();
        MyAccount.login("williamjacob802@gmail.com","abc123$$");
    }
    @Test
    public void testClearShoppingCart()
    {
        SoftAssert softAssert = new SoftAssert();
        ShoppingCart.clearCart();
        softAssert.assertFalse(ShoppingCart.isCartWithItem(),"Cart is not empty as expected");
        softAssert.assertAll();
    }
}
