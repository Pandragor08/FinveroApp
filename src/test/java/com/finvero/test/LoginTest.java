package com.finvero.test;

import com.finvero.base.BaseActions;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseActions {

    @BeforeMethod
    public void setUp() {
        setUpDriver();
    }

    @Test
    @Story("Login App Finvero")
    @Description("Prueba exitosa")
    @Severity(SeverityLevel.NORMAL)
    public void testLoginCorrecto() {
        System.out.println("✅ Test: Main correcto");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        tearDownDriver(result);
    }
}
