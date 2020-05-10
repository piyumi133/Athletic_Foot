package com.syscolab.athleticFoot.Test.myaccount;

import com.syscolab.athleticFoot.functions.AhleticHome;
import com.syscolab.athleticFoot.functions.ItemMenu;
import com.syscolab.athleticFoot.functions.MyAccount;
import com.syscolab.athleticFoot.functions.ShoppingCart;
import com.syscolab.athleticFoot.pages.MyAccountPage;
import com.syscolab.athleticFoot.utils.TestBase;
import org.testng.annotations.*;
import org.springframework.context.annotation.DependsOn;
import org.testng.asserts.SoftAssert;

public class UserLoginTest extends TestBase {

   @Test
   public void testMyAccountNavigation()
   {
       SoftAssert softAssert = new SoftAssert();
       //Navigate to Account Page
       AhleticHome.navigateToHomePage();
       AhleticHome.navigateToMyAccount();
       softAssert.assertTrue(MyAccount.isLoginButtonAvailble(),"Login button is not exists");
       softAssert.assertAll();
   }

    @Test(alwaysRun = true,dependsOnMethods="testMyAccountNavigation")
    public void testLoginValidation()
    {
        SoftAssert softAssert = new SoftAssert();

        //Login Validation 1 - Click Login button with  empty values
        MyAccount.login("","");
        softAssert.assertEquals(MyAccount.getEmailErrorMsg(),"THIS IS A REQUIRED FIELD.","email error message is not matched as expected");
        softAssert.assertEquals(MyAccount.getPasswordErrorMsg(),"THIS IS A REQUIRED FIELD.","password error message is not matched as expected");
        MyAccount.refresh();

        //Login Validation 2 - invlaid userName
        MyAccount.login("abc@gmail.com","abc123$$");
        softAssert.assertEquals(MyAccount.getErrorMsgForInvalidCredentials(),"YOU DID NOT SIGN IN CORRECTLY OR YOUR ACCOUNT IS TEMPORARILY DISABLED.","Invalid error message for invalid user credentials");
        MyAccount.refresh();

        //Login Validation 3 - invlaid password
        MyAccount.login("williamjacob802@gmail.com","111");
        softAssert.assertEquals(MyAccount.getErrorMsgForInvalidCredentials(),"YOU DID NOT SIGN IN CORRECTLY OR YOUR ACCOUNT IS TEMPORARILY DISABLED.","Invalid error message for invalid user credentials");
        MyAccount.refresh();

        //Login Validation 4 -invalid format valiidation(email validation)
        MyAccount.login("abc@","abc123$$");
        softAssert.assertEquals(MyAccount.getErrorMsgInvlaidEmailPattern(),"PLEASE ENTER A VALID EMAIL ADDRESS (EX: JOHNDOE@DOMAIN.COM).","Invalid error message for invalid email pattern");
        MyAccount.refresh();

        //Login Validation 5 -invalid username and password
        MyAccount.login("abc@gmail.com","ab123$$");
        softAssert.assertEquals(MyAccount.getErrorMsgForInvalidCredentials(),"YOU DID NOT SIGN IN CORRECTLY OR YOUR ACCOUNT IS TEMPORARILY DISABLED.","Invalid error message for invalid user credentials");
        MyAccount.refresh();
        softAssert.assertAll();
    }
    @Test(alwaysRun = true,dependsOnMethods="testLoginValidation")
    public void testSuccessfullLogin()
    {
        SoftAssert softAssert=new SoftAssert();
        MyAccount.login("williamjacob802@gmail.com","abc123$$");
        softAssert.assertEquals(MyAccount.getUserName(),"WILLIAM JACOB","user name is not matched as expected");
        softAssert.assertAll();

    }
}
