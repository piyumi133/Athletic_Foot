package com.syscolab.athleticFoot.pages;

import com.syscolab.athleticFoot.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage extends BasePage {
    private By divShoppingCart = By.xpath("//*[@class='minicart-wrapper']");
    private By divCartQty = By.xpath("//*[@class='counter qty']");
    private By spanEmptyCart=By.className("counter qty empty");
    private By listShoppingCart=By.className("minicart-product");
    private By lblDeleteItem=By.xpath("//*[contains(@title, 'Remove item')]");
    private By divCloseShoppingCart=By.xpath("//*[class='close']");
    private By divTitle =By.id("modal-content-37");
    private By btnClose=By.xpath("//*[@class='action-secondary action-dismiss button -secondary']");
    private By btnOk =By.xpath("//*[@class='action-primary action-accept button -secondary']");
    private By btnViewCart=By.cssSelector(".minicart-bottom .actions a.button");
    private By divItemName=By.cssSelector(".item-details strong.name");
    private By divItemPrice=By.cssSelector(".col.price .cart-price");
    private By btnSecureCheckOut=By.xpath("//*[@class='action button -primary primary -expanded checkout']");
 public void clickShoppingCart()
    {
        syscoLabUI.click(divShoppingCart);
        syscoLabUI.sleep(3);
    }
    public String getCartQty()
    {
      return syscoLabUI.getValue(divCartQty);
    }
    public void closeShoppingCart()
    {
        syscoLabUI.click(divCloseShoppingCart);
    }


    public boolean isCartWithItems()
    {
        return syscoLabUI.isDisplayed(divCartQty);
    }
    public void clickOk()
    {
        syscoLabUI.click(btnOk);
    }
    public void clickClose()
    {
        syscoLabUI.click(btnClose);
    }
    public String getTitle()
    {
        return  syscoLabUI.getText(divTitle);
    }
    public void clearCart()
    {
            List<WebElement> itemList = syscoLabUI.findElements(listShoppingCart);
                for (WebElement items : itemList) {
                    if (syscoLabUI.isDisplayed(lblDeleteItem)) {
                        syscoLabUI.click(lblDeleteItem);
                        syscoLabUI.sleep(2);
                        clickOk();
                        syscoLabUI.sleep(4);
                    }
                }


    }
    public void clickViewCart(){
     syscoLabUI.click(btnViewCart);

    }
    public String getCartItemName()
    {
     return syscoLabUI.getText(divItemName);
    }
    public String getCartItemPrice()
    {
        return syscoLabUI.getText(divItemPrice);
    }
    public void clickSecureCheckOut()
    {
        syscoLabUI.click(btnSecureCheckOut);
    }
}
