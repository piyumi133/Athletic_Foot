package com.syscolab.athleticFoot.functions;

import com.syscolab.athleticFoot.pages.ConfirmationOverlay;
import com.syscolab.athleticFoot.pages.ShoppingCartPage;

public class ShoppingCart {
public static ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
public static ConfirmationOverlay confirmationOverlay = new ConfirmationOverlay();



    public static void navigateToShoppingCart()
    {
        shoppingCartPage.clickShoppingCart();
    }
    public static void clearCart()
    {
        boolean status =shoppingCartPage.isCartWithItems();
        if(status == true) {
            navigateToShoppingCart();
            shoppingCartPage.clearCart();
            shoppingCartPage.clickShoppingCart();
        }

    }
    public static boolean isCartWithItem()
    {
        return shoppingCartPage.isCartWithItems();
    }
    public static void clickViewCart()
    {
        shoppingCartPage.clickShoppingCart();
        shoppingCartPage.clickViewCart();
    }
    public static String getCartItemName()
    {
     return shoppingCartPage.getCartItemName();
    }
    public static String getCartItemPrice()
    {
        return shoppingCartPage.getCartItemPrice();
    }
    public static void clickSecureCheckOut()
    {
      shoppingCartPage.clickSecureCheckOut();
    }

}
