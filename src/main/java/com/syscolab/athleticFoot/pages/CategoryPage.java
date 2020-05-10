package com.syscolab.athleticFoot.pages;

import com.syscolab.athleticFoot.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

public class CategoryPage extends BasePage {
    private By listCategory =By.cssSelector(".cms-content > table > tbody > tr > td > a[target='_self']");


    public List<WebElement> getCatItems()
    {
        return syscoLabUI.findElements(listCategory);
    }

}
