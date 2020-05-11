package com.syscolab.athleticFoot.pages;

import com.syscolab.athleticFoot.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/*
Created By Piyumi
10/05/2021
*/

public class ItemMenuPage extends BasePage {
    private By lstMenuItems = By.cssSelector(".navigation-wrapper .menu-wrapper  .item.-parent.-level1");
    private By lstCatgooryItems = By.cssSelector("ul>li>a[title='Categories']");

    public List<WebElement> getMenuItems() {
        return syscoLabUI.findElements(lstMenuItems);
    }

    public WebElement getListCategory() {
        return syscoLabUI.findElement(lstCatgooryItems);
    }

    public void clickCategory() {
        WebElement category;
        category = getListCategory();
        //syscoLabUI.sleep(10);
        if(category.isDisplayed()) {
            category.click();
        }
        else
        {
            category = getListCategory();
            category.click();
        }
    }

    public void wait(int num) {
        syscoLabUI.sleep(num);
    }

}
