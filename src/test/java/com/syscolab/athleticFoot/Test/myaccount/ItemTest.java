package com.syscolab.athleticFoot.Test.myaccount;

import com.syscolab.athleticFoot.functions.*;
import com.syscolab.athleticFoot.utils.BasePage;
import com.syscolab.athleticFoot.utils.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ItemTest extends TestBase {
    @BeforeMethod
    public void loginToSite()
    {
        AhleticHome.navigateToHomePage();
        AhleticHome.navigateToMyAccount();
        MyAccount.login("williamjacob802@gmail.com","abc123$$");
    }
    @AfterMethod
    public void guiteDriver()
    {
        BasePage.quiteDriver();
    }
    @Test
    public void testClearShoppingCart()
    {
        SoftAssert softAssert = new SoftAssert();
        //Clear shopping Cart
        ShoppingCart.clearCart();
        softAssert.assertFalse(ShoppingCart.isCartWithItem(),"Cart is not empty as expected");

        //add Item
        ItemMenu.selctMenuItem();
        Category.selectRandomCategory();
        Item.selectRandomItem();
        Item.clickRandomItem();
        Item.clickRandomSize();
        String itemName = Item.getItemName();
        System.out.println(itemName);
        String itemPrice = Item.getItemPrice();
        System.out.println(itemPrice);
        Item.addtoCart();

        //View item and verify the item
        ShoppingCart.clickViewCart();
        String cartItemPrice = ShoppingCart.getCartItemPrice();
        String cartItemName=ShoppingCart.getCartItemName();
        softAssert.assertEquals(itemName,cartItemName,"Cart item name is not matched with added item");
        softAssert.assertEquals(itemPrice,cartItemPrice,"Cart item price is not matched with added item");

        //Navigate to secureCheckOut
        ShoppingCart.clickSecureCheckOut();
        String userName=MyAccount.getUserName().toLowerCase();
        String firstName = SecureCheckOut.getFirstName().toLowerCase();
        String lastName=SecureCheckOut.getLastName().toLowerCase();
        softAssert.assertTrue(userName.equals(firstName+lastName),"name is not matched as expected");

        //
        softAssert.assertAll();
    }
}
