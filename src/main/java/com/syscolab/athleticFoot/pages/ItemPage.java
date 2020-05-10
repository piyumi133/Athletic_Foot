package com.syscolab.athleticFoot.pages;

import com.syscolab.athleticFoot.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ItemPage extends BasePage {
    private By btnLoadMore = By.cssSelector("button.button.infinitescroll-button");
    private By lstItem=By.cssSelector(".sli_product > a");
    private By btnAddToCart=By.id("product-addtocart-button");
    private By lstSize=By.xpath("//*[@class='swatch-row -active']//*[@class='swatch-option text']");
    private By spanItemName=By.cssSelector(".page-title.product span.base");
    private By spanItemPrice =By.cssSelector(".product-info-main .price");
    private By dicountItemPrice =By.cssSelector(".product-info-main .price-final_price .special-price .price");



    public int getAllItemCount()
    {
        syscoLabUI.sleep(5);
        String btnText=syscoLabUI.getText(btnLoadMore);
        String allItemCountTxt = btnText.substring(btnText.indexOf('/')+1, btnText.indexOf("PRODUCT(S)"));
        return Integer.parseInt(allItemCountTxt.trim());
    }

    public int getCurrentItemCount()
    {
        syscoLabUI.sleep(5);
        String btnText=syscoLabUI.getText(btnLoadMore);
        String currentItemCountTxt = btnText.substring(btnText.indexOf('|')+1, btnText.indexOf('/'));
        return Integer.parseInt(currentItemCountTxt.trim());
    }

   public boolean isbtnLoadMoreEnable()
   {
       syscoLabUI.sleep(5);
       return syscoLabUI.isEnabled(btnLoadMore);
   }
   public  void clickBtnLoadMore()
   {
       syscoLabUI.sleep(5);
       syscoLabUI.click(btnLoadMore);
   }
   public boolean isBtnLoadMoreExists()
   {
       return syscoLabUI.isDisplayed(btnLoadMore);
   }
   public List<WebElement> getItemList()
   {
       return syscoLabUI.findElements(lstItem);
   }
   public void clickAddToCartButton()
   {
       syscoLabUI.click(btnAddToCart);
   }
   public List<WebElement> getSizeList()
   {
       return syscoLabUI.findElements(lstSize);
   }
   public String getItemName()
   {
       return syscoLabUI.getText(spanItemName);
   }
    public String getItemPrice()
    {
        if(syscoLabUI.isDisplayed(dicountItemPrice)) {
            return syscoLabUI.getText(dicountItemPrice);
        }
        return syscoLabUI.getText(spanItemPrice);

    }
}