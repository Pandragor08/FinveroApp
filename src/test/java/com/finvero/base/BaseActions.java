package com.finvero.base;

import com.finvero.utils.AllureUtils;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;

import java.net.URL;

public class BaseActions {
    static AndroidDriver driver;

    public static DesiredCapabilities getCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "Samsung");
        caps.setCapability("appium:udid", "3438465658313498");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:appPackage", "com.finvero");
        caps.setCapability("appium:appActivity", ".MainActivity");
        caps.setCapability("appium:noReset", true);
        return caps;
    }

    public static void handleError(Exception e) {
        System.err.println("Error al iniciar sesión:");
        System.err.println("Mensaje: " + e.getMessage());
        AllureUtils.saveTextLog("Error al iniciar WebDriver: " + e.getMessage());
    }

    public static void setUpDriver() {
        try {
            driver = new AndroidDriver(
                    new URL("http://127.0.0.1:4723"),
                    getCapabilities()
            );
            System.out.println("Sesión creada exitosamente!");
            Allure.step("Inicializar driver y configuraciones base");
        } catch (Exception e) {
            handleError(e);
        }
    }

    public static void tearDownDriver(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            AllureUtils.saveTextLog("Fallo: " + result.getThrowable().getMessage());
        }
        if (driver != null) {
            driver.quit();
        }
    }
}
