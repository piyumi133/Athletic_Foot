package com.syscolab.athleticFoot.pages;

import com.syscolab.athleticFoot.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
/*
Created By Piyumi
10/05/2021
*/

public class ItemPage extends BasePage {

    private By btnLoadMore = By.xpath("//*[@id='ewave-layerednavigation-product-list']//button");
    private By lstItem = By.xpath("//*[@class='sli_product']/a");
    private By btnAddToCart = By.id("product-addtocart-button");
    private By lstSize = By.xpath("//*[@class='swatch-row -active']//*[@class='swatch-option text']");
    private By lblItemName = By.xpath("//*[@class='page-title  product']//span");
    private By lblItemPrice = By.xpath("//*[@class='product-info-price']//*[@class='price']");
    private By lbldicountItemPrice = By.xpath("//*[@class='special-price']//*[@class='price']");

    public int getAllItemCount() {
        syscoLabUI.sleep(5);
        String btnText = syscoLabUI.getText(btnLoadMore);
        String allItemCountTxt = btnText.substring(btnText.indexOf('/') + 1, btnText.indexOf("PRODUCT(S)"));
        return Integer.parseInt(allItemCountTxt.trim());
    }

    public int getCurrentItemCount() {
        syscoLabUI.sleep(5);
        String btnText = syscoLabUI.getText(btnLoadMore);
        String currentItemCountTxt = btnText.substring(btnText.indexOf('|') + 1, btnText.indexOf('/'));
        return Integer.parseInt(currentItemCountTxt.trim());
    }

    public boolean isbtnLoadMoreEnable() {
        syscoLabUI.sleep(5);
        return syscoLabUI.isEnabled(btnLoadMore);
    }

    public void clickBtnLoadMore() {
        syscoLabUI.sleep(5);
        syscoLabUI.click(btnLoadMore);
    }

    public boolean isBtnLoadMoreExists() {
        return syscoLabUI.isDisplayed(btnLoadMore);
    }

    public List<WebElement> getItemList() {
        return syscoLabUI.findElements(lstItem);
    }

    public void clickAddToCartButton() {
        syscoLabUI.click(btnAddToCart);
    }

    public List<WebElement> getSizeList() {
        return syscoLabUI.findElements(lstSize);
    }

    public String getItemName() {
        return syscoLabUI.getText(lblItemName);
    }

    public String getItemPrice() {
        if (syscoLabUI.isDisplayed(lbldicountItemPrice)) {
            return syscoLabUI.getText(lbldicountItemPrice);
        }
        return syscoLabUI.getText(lblItemPrice);

    }

    public void wait(int num) {
        syscoLabUI.sleep(num);
    }
}