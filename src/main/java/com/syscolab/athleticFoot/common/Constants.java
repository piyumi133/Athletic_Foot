package com.syscolab.athleticFoot.common;

public class Constants {
    public static final String APP_URL=System.getProperty("app.url","https://www.theathletesfoot.com.au/");
    public static final String TEST_ENV = System.getProperty("test.env", "");
    public static final String TEST_RELEASE = System.getProperty("test.release", "");
    public static final String TEST_PROJECT = System.getProperty("test.project", "");
    public static final boolean UPDATE_DASHBOARD = Boolean.parseBoolean(System.getProperty("update.dashboard", "true"));
}
