package com.syscolab.athleticFoot.pages;

import com.syscolab.athleticFoot.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/*
Created By Piyumi
10/05/2021
*/
public class ShoppingCartPage extends BasePage {
    private By lblShoppingCart = By.xpath("//*[@class='minicart-wrapper']");
    private By lblCartQty = By.xpath("//*[@class='counter qty']");
    private By lblEmptyCart = By.className("counter qty empty");
    private By lstShoppingCart = By.className("minicart-product");
    private By lblDeleteItem = By.xpath("//*[contains(@title, 'Remove item')]");
    private By lblCloseShoppingCart = By.xpath("//*[class='close']");
    private By lblTitle = By.id("modal-content-37");
    private By btnClose = By.xpath("//*[@class='action-secondary action-dismiss button -secondary']");
    private By btnOk = By.xpath("//*[@class='action-primary action-accept button -secondary']");
    private By btnViewCart = By.xpath("//*[@class='minicart-bottom']/div/a");
    private By divItemName = By.xpath("//*[@class='item-details']/strong");
    private By lblItemPrice = By.xpath("//*[@class='col price']//*[@class='price']");
    private By btnSecureCheckOut = By.xpath("//*[@class='action button -primary primary -expanded checkout']");

    public void clickShoppingCart() {
        syscoLabUI.click(lblShoppingCart);
        syscoLabUI.sleep(3);
    }

    public String getCartQty() {
        return syscoLabUI.getValue(lblCartQty);
    }

    public void closeShoppingCart() {
        syscoLabUI.click(lblCloseShoppingCart);
    }


    public boolean isCartWithItems() {
        return syscoLabUI.isDisplayed(lblCartQty);
    }

    public void clickOk() {
        syscoLabUI.click(btnOk);
    }

    public void clickClose() {
        syscoLabUI.click(btnClose);
    }

    public String getTitle() {
        return syscoLabUI.getText(lblTitle);
    }

    public void clearCart() {
        List<WebElement> itemList = syscoLabUI.findElements(lstShoppingCart);
        for (WebElement items : itemList) {
            if (syscoLabUI.isDisplayed(lblDeleteItem)) {
                syscoLabUI.click(lblDeleteItem);
                syscoLabUI.sleep(2);
                clickOk();
                syscoLabUI.sleep(4);
            }
        }


    }

    public void clickViewCart() {
        syscoLabUI.click(btnViewCart);

    }

    public String getCartItemName() {
        return syscoLabUI.getText(divItemName);
    }

    public String getCartItemPrice() {
        return syscoLabUI.getText(lblItemPrice);
    }

    public void clickSecureCheckOut() {
        syscoLabUI.click(btnSecureCheckOut);
    }

    public void wait(int num) {
        syscoLabUI.sleep(num);
    }
}
