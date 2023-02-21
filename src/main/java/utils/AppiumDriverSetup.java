package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static testdata.TestData.*;

public class AppiumDriverSetup {

    protected static AppiumDriver appiumDriver; // singleton

    public AppiumDriver getDriver() {
        return appiumDriver;
    }

    public void setAppiumDriver(String platformName, String deviceName, String browserName, String app) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory Android capabilities
        capabilities.setCapability(platformNameCapability, platformName);
        capabilities.setCapability(deviceNameCapability, deviceName);

        if (app.endsWith(androidAppExt)) capabilities.setCapability(appCapability, (new File(app)).getAbsolutePath());

        capabilities.setCapability(browserNameCapability, browserName);
//        capabilities.setCapability("chromedriverDisableBuildCheck","true");

        try {
            appiumDriver = new AppiumDriver(new URL(System.getProperty(appiumSystemProperty)), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Timeouts tuning
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
}
