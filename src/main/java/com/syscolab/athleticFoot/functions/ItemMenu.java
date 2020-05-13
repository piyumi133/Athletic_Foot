package com.syscolab.athleticFoot.functions;

import com.syscolab.athleticFoot.pages.ItemMenuPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;
import java.util.Random;

/*
Created By Piyumi
10/05/2021
*/

public class ItemMenu {
    public static ItemMenuPage itemMenuPage = new ItemMenuPage();
    public static Random random = new Random();

    public static void SelectMenuAndNavigateToCategory() {

       List<WebElement> menuItems = itemMenuPage.getMenuItems();
        int randomInt = random.nextInt(menuItems.size() - 2);
        WebElement randomItem = menuItems.get(randomInt);
        randomItem.click();
        itemMenuPage.wait(2);
        itemMenuPage.clickCategory();


    }

    public static void wait(int num) {
        itemMenuPage.wait(num);
    }

}
