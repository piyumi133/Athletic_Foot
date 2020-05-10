package com.syscolab.athleticFoot.pages;

import com.syscolab.athleticFoot.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ItemMenuPage extends BasePage {
    private By listMenuItems = By.cssSelector(".navigation-wrapper .menu-wrapper  .item.-parent.-level1");


    public List<WebElement> getMenuItems()
    {
     return syscoLabUI.findElements(listMenuItems);
    }


}
