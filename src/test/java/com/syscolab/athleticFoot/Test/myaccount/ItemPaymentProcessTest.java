package com.syscolab.athleticFoot.Test.myaccount;

import com.syscolab.athleticFoot.data.testdata.CardTestData;
import com.syscolab.athleticFoot.data.testdata.LoginTestData;
import com.syscolab.athleticFoot.data.testdata.SecureCheckoutData;
import com.syscolab.athleticFoot.functions.*;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

/*
Created By Piyumi
10/05/2021
*/

public class ItemPaymentProcessTest {


    @BeforeClass
    public void loginToSite() {
        AhleticHome.navigateToHomePage();
        AhleticHome.navigateToMyAccount();
        MyAccount.login(LoginTestData.VALID_EMAIL, LoginTestData.VALID_PASSWORD);
    }

    @AfterClass
    public void guiteDriver() {
        AhleticHome.quiteDriver();
    }

    @Test
    public void testItemPaymentProcess() {
        SoftAssert softAssert = new SoftAssert();
        //Clear shopping Cart
        ShoppingCart.clearCart();
        ShoppingCart.wait(2);
        softAssert.assertFalse(ShoppingCart.isCartWithItem(), "Cart is not empty as expected");


        //add Item
        ItemMenu.SelectMenuAndNavigateToCategory();
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
        ShoppingCart.wait(2);
        ShoppingCart.clickViewCart();
        String cartItemPrice = ShoppingCart.getCartItemPrice();
        String cartItemName = ShoppingCart.getCartItemName();
        softAssert.assertEquals(itemName, cartItemName, "Cart item name is not matched with added item");
        softAssert.assertEquals(itemPrice, cartItemPrice, "Cart item price is not matched with added item");

        //Navigate to secureCheckOut
        ShoppingCart.clickSecureCheckOut();
        String userName = MyAccount.getUserName().toLowerCase();
        String firstName = SecureCheckOut.getFirstName().toLowerCase();
        String lastName = SecureCheckOut.getLastName().toLowerCase();
        softAssert.assertTrue(userName.equals(firstName + lastName), "name is not matched as expected");

        //Validate mandetory field
        SecureCheckOut.clickSecureCheckOutButton();
        softAssert.assertEquals(SecureCheckOut.getAddress1Error(), SecureCheckoutData.ERROR_REQUIRED, "error message is not appered as expected[Address1]");
        softAssert.assertEquals(SecureCheckOut.getSuburbError(), SecureCheckoutData.ERROR_REQUIRED, "error message is not appered as expected[Suburb]");
        softAssert.assertEquals(SecureCheckOut.getStateError(), SecureCheckoutData.ERROR_REQUIRED, "error message is not appered as expected[State]");
        softAssert.assertEquals(SecureCheckOut.getPostalCodeError(), SecureCheckoutData.ERROR_REQUIRED, "error message is not appered as expected[PostalCode]");
        softAssert.assertEquals(SecureCheckOut.getPhoneError(), SecureCheckoutData.ERROR_REQUIRED, "error message is not appered as expected[Phone]");

        //Proceed secureCheckout
        SecureCheckOut.setAddress1(SecureCheckoutData.ADDRESS1);
        SecureCheckOut.setSbuburb();
        SecureCheckOut.setPhoneNumber(SecureCheckoutData.PHONE_NUMBEER);
        SecureCheckOut.clickSecureCheckOutButton();

        //Verify paymentDetails
        Payment.wait(2);
        softAssert.assertTrue(Payment.isPaypalRadioClickable(), "pay pal button is clickable");
        softAssert.assertTrue(Payment.isVisaRadioClickable(), "visa button is clickable");
        Payment.clickVisa();


        //Valid card details verification
        Payment.wait(3);
        Payment.setCreditCardNumber(CardTestData.VALID_VISA_CARD_NUMBER);
        Payment.setTxtExpiry(CardTestData.VALID_VISA_EXPIRY);
        Payment.setTxtCSV(CardTestData.VAILD_CVV);
        softAssert.assertFalse(Payment.isCardNumErrorDisplay(), "The card number is invalid");
        softAssert.assertFalse(Payment.isCardExpDateErrorDisplay(), "The card exp date is invalid");

        //Invalid card details verification
        Payment.setCreditCardNumber(CardTestData.INVVALID_VISA_CARD_NUMBER);
        Payment.setTxtExpiry(CardTestData.INVALID_VISA_EXPIRY);
        Payment.setTxtCSV(CardTestData.VAILD_CVV);
        softAssert.assertTrue(Payment.isCardNumErrorDisplay(), "The card number is valid");
        softAssert.assertTrue(Payment.isCardExpDateErrorDisplay(), "The card exp date is valid");
        softAssert.assertEquals(Payment.getInvalidCardNumMsg(), CardTestData.ERROR_INVALID_VISA_CARD_NUMBER, "Error message is not appeared as expected[card number]");
        softAssert.assertEquals(Payment.getIvalidCardExpMsg(), CardTestData.ERROR_INVALID_VISA_EXPIRY, "Error message is not appeared as expected[card exp date]");

        softAssert.assertAll();
    }


}
