package com.syscolab.athleticFoot.utils;

import com.syscolab.athleticFoot.common.Constants;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import com.syscolab.qe.core.reporting.SyscoLabQCenter;
import com.syscolab.qe.core.reporting.SyscoLabReporting;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

@Listeners(SyscoLabListener.class)
public class TestBase extends SyscoLabListener
{
    protected SoftAssert softAssert;
    private SyscoLabListener syscoLabListeners;
    private SyscoLabQCenter syscoLabQCenter;

    @BeforeMethod
    public void init() {
        softAssert = new SoftAssert();
        syscoLabListeners = new SyscoLabListener();
        syscoLabQCenter = new SyscoLabQCenter();
        System.out.println("Running "+this.getClass().toString());
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp(ITestContext iTestContext) {
        try {
            syscoLabQCenter.setProjectName(Constants.TEST_PROJECT);
            syscoLabQCenter.setEnvironment(Constants.TEST_ENV);
            syscoLabQCenter.setRelease(Constants.TEST_RELEASE);
            syscoLabQCenter.setModule(iTestContext.getAttribute("feature").toString());
            syscoLabQCenter.setFeature(iTestContext.getAttribute("feature").toString());
            syscoLabQCenter.setClassName(iTestContext.getClass().getName());
            if(Constants.UPDATE_DASHBOARD) {
                SyscoLabReporting.generateJsonFile(syscoLabListeners.getResults(), syscoLabQCenter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
