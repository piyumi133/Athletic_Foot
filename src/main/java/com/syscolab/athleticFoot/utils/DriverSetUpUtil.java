package com.syscolab.athleticFoot.utils;

import java.util.logging.Logger;
import com.syscolab.qe.core.ui.SyscoLabCapabilityUtil;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class DriverSetUpUtil {

    DriverSetUpUtil()
    {

    }

    public static String chromeDriver = "webdriver.chrome.driver";

    public static void setToRunLocally()
    {
      System.setProperty(chromeDriver,"src/main/resources/chrome_driver/"+System.getProperty("os.arch")+"/chromedriver");
        Logger.getLogger(System.getProperty(chromeDriver));
    }
    public static Capabilities setToRunRemotely(String browser) {
        DesiredCapabilities capabilities;
        System.setProperty("hub.url", "http://10.1.19.213:4444/wd/hub");
        capabilities = SyscoLabCapabilityUtil.getPCCapabilities("WIN10", "firefox");
        if (BrowserType.CHROME.equalsIgnoreCase(browser)) {
            capabilities.setBrowserName(BrowserType.CHROME);
        } else if (BrowserType.FIREFOX.equalsIgnoreCase(browser)) {
            capabilities.setBrowserName(BrowserType.FIREFOX);
        }
        return capabilities;
    }
}
