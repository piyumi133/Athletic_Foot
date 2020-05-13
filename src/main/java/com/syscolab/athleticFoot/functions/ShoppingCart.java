package com.syscolab.athleticFoot.functions;

import com.syscolab.athleticFoot.pages.ShoppingCartPage;

/*
Created By Piyumi
10/05/2021
*/

public class ShoppingCart {
    public static ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    public static void navigateToShoppingCart() {
        shoppingCartPage.clickShoppingCart();
    }

    public static void clearCart() {
        boolean status = shoppingCartPage.isCartWithItems();
        if (status == true) {
            navigateToShoppingCart();
            shoppingCartPage.clearCart();
            shoppingCartPage.clickShoppingCart();
        }

    }

    public static boolean isCartWithItem() {
        return shoppingCartPage.isCartWithItems();
    }

    public static void clickViewCart() {
        shoppingCartPage.clickShoppingCart();
        shoppingCartPage.wait(2);
        shoppingCartPage.clickViewCart();
        shoppingCartPage.wait(3);
    }

    public static String getCartItemName() {
        return shoppingCartPage.getCartItemName();
    }

    public static String getCartItemPrice() {
        return shoppingCartPage.getCartItemPrice();
    }

    public static void clickSecureCheckOut() {
        shoppingCartPage.clickSecureCheckOut();
    }

    public static void wait(int num) {
        shoppingCartPage.wait(num);
    }


}
