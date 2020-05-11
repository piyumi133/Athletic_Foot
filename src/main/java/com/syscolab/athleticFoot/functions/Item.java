package com.syscolab.athleticFoot.functions;

import com.syscolab.athleticFoot.pages.ItemPage;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

/*
Created By Piyumi
10/05/2021
*/

public class Item {
    public static ItemPage itemPage = new ItemPage();
    public static Random random = new Random();

    public static void selectRandomItem() {
        if (itemPage.isBtnLoadMoreExists()) {
            int allItemCount = itemPage.getAllItemCount();
            int currentItemCount = itemPage.getCurrentItemCount();


            while (allItemCount > itemPage.getCurrentItemCount() && itemPage.isbtnLoadMoreEnable()) {
                int randomNum = random.nextInt(10);
                System.out.println(randomNum);
                if (randomNum % 2 == 0) {
                    break;
                }
                itemPage.wait(5);
                itemPage.clickBtnLoadMore();
                itemPage.wait(5);
            }
        }
    }

    public static void clickRandomItem() {
        List<WebElement> itemList = itemPage.getItemList();
        int randomNum = random.nextInt(itemList.size());
        WebElement randomItem = itemList.get(randomNum);
        randomItem.click();

    }

    public static void clickRandomSize() {
        List<WebElement> sizeList = itemPage.getSizeList();
        int randomNum = random.nextInt(sizeList.size());
        WebElement randomSize = sizeList.get(randomNum);
        randomSize.click();
    }

    public static void wait(int num) {
        itemPage.wait(num);
    }

    public static void addtoCart() {
        itemPage.clickAddToCartButton();
    }

    public static String getItemName() {
        return itemPage.getItemName().trim();
    }

    public static String getItemPrice() {
        return itemPage.getItemPrice().trim();
    }
}
