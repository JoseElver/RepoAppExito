package com.co.choucair.stepdefinitions;

import com.co.choucair.drivers.DriverHolder;
import com.epam.healenium.SelfHealingDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;

import static com.co.choucair.drivers.DriverFactory.*;
import static com.co.choucair.drivers.DriverHolder.*;
import static com.co.choucair.utils.Global.*;
import static net.serenitybdd.core.Serenity.getDriver;

public class Hooks {
    @Before
    public void setup() {
        WebDriver reportsDriver = createWebDriver(BROWSER);
        setDriverForScreenshots(reportsDriver);
        WebDriver selfHealingDriver = SelfHealingDriver.create(reportsDriver);
        OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(selfHealingDriver)));
    }
    @AfterClass
    public static void close() {
        getDriver().close();
    }
}
