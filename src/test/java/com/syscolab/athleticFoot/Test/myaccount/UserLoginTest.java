package com.syscolab.athleticFoot.Test.myaccount;

import com.syscolab.athleticFoot.data.testdata.LoginTestData;
import com.syscolab.athleticFoot.functions.AhleticHome;
import com.syscolab.athleticFoot.functions.MyAccount;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

/*
Created By Piyumi
10/05/2021
*/

public class UserLoginTest {

    @Test
    public void testMyAccountNavigation() {
        SoftAssert softAssert = new SoftAssert();
        //Navigate to Account Page
        AhleticHome.navigateToHomePage();
        AhleticHome.navigateToMyAccount();
        softAssert.assertTrue(MyAccount.isLoginButtonAvailble(), "Login button is not exists");
        softAssert.assertAll();
    }

    @Test(alwaysRun = true, dependsOnMethods = "testMyAccountNavigation")
    public void testLoginValidation() {
        SoftAssert softAssert = new SoftAssert();

        //Login Validation 1 - Click Login button with  empty values
        MyAccount.login("", "");
        softAssert.assertEquals(MyAccount.getEmailErrorMsg(), LoginTestData.ERROR_REQUIRED_CREDTIAL, "email error message is not matched as expected");
        softAssert.assertEquals(MyAccount.getPasswordErrorMsg(), LoginTestData.ERROR_REQUIRED_CREDTIAL, "password error message is not matched as expected");
        MyAccount.refresh();

        //Login Validation 2 - invlaid userName
        MyAccount.login(LoginTestData.INVALD_EMAIL, LoginTestData.VALID_PASSWORD);
        softAssert.assertEquals(MyAccount.getErrorMsgForInvalidCredentials(), LoginTestData.ERROR_INVALID_CREDTIAL, "Invalid error message for invalid user credentials");
        MyAccount.refresh();

        //Login Validation 3 - invlaid password
        MyAccount.login(LoginTestData.VALID_EMAIL, LoginTestData.INVALID_PASSWORD);
        softAssert.assertEquals(MyAccount.getErrorMsgForInvalidCredentials(), LoginTestData.ERROR_INVALID_CREDTIAL, "Invalid error message for invalid user credentials");
        MyAccount.refresh();

        //Login Validation 4 -invalid format valiidation(email validation)
        MyAccount.login(LoginTestData.INVALID_EMAIL_FORMAT, LoginTestData.VALID_PASSWORD);
        softAssert.assertEquals(MyAccount.getErrorMsgInvlaidEmailPattern(), LoginTestData.ERROR_INVALID_EMAIL_FORMAT, "Invalid error message for invalid email pattern");
        MyAccount.refresh();

        //Login Validation 5 -invalid username and password
        MyAccount.login(LoginTestData.INVALD_EMAIL, LoginTestData.INVALID_PASSWORD);
        softAssert.assertEquals(MyAccount.getErrorMsgForInvalidCredentials(), LoginTestData.ERROR_INVALID_CREDTIAL, "Invalid error message for invalid user credentials");
        MyAccount.refresh();
        softAssert.assertAll();
    }

    @Test(alwaysRun = true, dependsOnMethods = "testLoginValidation")
    public void testSuccessfullLogin() {
        SoftAssert softAssert = new SoftAssert();
        MyAccount.login(LoginTestData.VALID_EMAIL, LoginTestData.VALID_PASSWORD);
        softAssert.assertEquals(MyAccount.getUserName(), LoginTestData.USER_NAME, "user name is not matched as expected");
        softAssert.assertAll();

    }
}
