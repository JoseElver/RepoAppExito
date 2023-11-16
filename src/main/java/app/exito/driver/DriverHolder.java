package com.co.choucair.drivers;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebDriver;



public class DriverHolder {

    private static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();
    public static void setDriver(WebDriver driver) {
        DriverHolder.THREAD_LOCAL.set(driver);
    }

    public static void setDriverForScreenshots(WebDriver driver) {
        setDriver(driver);
        Serenity.getWebdriverManager().setCurrentDriver(driver);
    }

}
