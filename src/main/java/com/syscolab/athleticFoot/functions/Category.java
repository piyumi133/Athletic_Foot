package com.syscolab.athleticFoot.functions;

import com.syscolab.athleticFoot.pages.CategoryPage;
import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class Category {
    public static CategoryPage categoryPage = new CategoryPage();
    public static SyscoLabUI syscoLabUI=new SyscoLabUI();
    public static Random random = new Random();

    public static void selectRandomCategory() {

            syscoLabUI.sleep(4);
            List<WebElement> cat = categoryPage.getCatItems();
            WebElement catItem = cat.get(random.nextInt(cat.size()));
            catItem.click();
    }
}
