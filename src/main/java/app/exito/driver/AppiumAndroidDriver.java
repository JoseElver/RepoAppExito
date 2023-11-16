package app.exito.driver;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
public class AppiumAndroidDriver {

    public static AndroidDriver driver;


    public static AppiumAndroidDriver appium() throws IOException {

        try{
            Properties properties = new Properties();
            InputStream inputStream = AppiumAndroidDriver.class.getClassLoader().getResourceAsStream("serenity.properties");
            properties.load(inputStream);

            UiAutomator2Options options = new UiAutomator2Options()
                    .setUdid(properties.getProperty("udid"))
                    .setAppPackage(properties.getProperty("appPackage"))
                    .setAppActivity(properties.getProperty("appActivity"))
                    .setDeviceName(properties.getProperty("deviceName"))
                    .setPlatformVersion(properties.getProperty("platformVersion"))
                    .setPlatformName(properties.getProperty("platformName"))
                    .setNoReset(true);

             driver = new AndroidDriver(
                    new URL("http://127.0.0.1:4723/wd/hub"), options
            );

        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        return new AppiumAndroidDriver();
    }

    public AndroidDriver on(){
        return driver;
    }
}
