package com.syscolab.athleticFoot.functions;

import com.syscolab.athleticFoot.pages.CategoryPage;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

/*
Created By Piyumi
10/05/2021
*/
public class Category {
    public static CategoryPage categoryPage = new CategoryPage();

    public static Random random = new Random();

    public static void selectRandomCategory() {

        categoryPage.wait(4);
        List<WebElement> cat = categoryPage.getCatItems();
        WebElement catItem = cat.get(random.nextInt(cat.size()));
        catItem.click();
    }

    public static void wait(int num) {
        categoryPage.wait(num);
    }
}
