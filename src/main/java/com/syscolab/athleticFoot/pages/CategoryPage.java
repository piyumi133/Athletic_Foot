package com.syscolab.athleticFoot.pages;

import com.syscolab.athleticFoot.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

/*
Created By Piyumi
10/05/2021
*/
public class CategoryPage extends BasePage {
    private By lstCategory = By.cssSelector(".cms-content > table > tbody > tr > td > a[target='_self']");


    public List<WebElement> getCatItems() {
        return syscoLabUI.findElements(lstCategory);
    }

    public void wait(int num) {
        syscoLabUI.sleep(num);
    }

}
