package com.syscolab.athleticFoot.functions;

import com.syscolab.athleticFoot.pages.ItemMenuPage;
import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;
import java.util.Random;

public class ItemMenu {

    public static ItemMenuPage itemMenuPage = new ItemMenuPage();
    public static SyscoLabUI syscoLabUI=new SyscoLabUI();
   public static  Random random = new Random();

    public static void selctMenuItem()
    {

        List<WebElement> menuItems=itemMenuPage.getMenuItems();
        int randomInt = random.nextInt(menuItems.size()-2);
        WebElement randomItem = menuItems.get(randomInt);
        randomItem.click();
        ((RemoteWebElement) randomItem).findElementByCssSelector("ul>li>a[title='Categories']").click();

    }

}
