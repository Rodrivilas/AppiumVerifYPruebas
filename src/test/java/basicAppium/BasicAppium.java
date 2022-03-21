package basicAppium;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BasicAppium {

    private AppiumDriver appiumDriver;

    @BeforeEach
    public void openApplication() throws MalformedURLException {
        DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setCapability("deviceName","Rods");
        capabilities.setCapability("platformVersion","11");
        capabilities.setCapability("appPackage","com.miui.calculator");
        capabilities.setCapability("appActivity",".cal.CalculatorActivity");
        capabilities.setCapability("platformName","Android");

        appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        // implicit
        appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterEach
    public void closeApplication(){
        appiumDriver.quit();
    }

    @Test
    public void verifyCalculator() throws InterruptedException {
        appiumDriver.findElement(By.id("android:id/button1")).click();
        //click 2 id com.miui.calculator:id/btn_2_s - xpath //android.widget.TextView[@text="2"]
        appiumDriver.findElement(By.id("com.miui.calculator:id/btn_2_s")).click();

        // click +  id com.miui.calculator:id/btn_plus_s //android.widget.ImageView[@resource-id='com.miui.calculator:id/btn_plus_s']
        appiumDriver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.miui.calculator:id/btn_plus_s']")).click();
        // click 5  id com.miui.calculator:id/btn_5_s - xpath //android.widget.TextView[@text="5"]
        appiumDriver.findElement(By.id("com.miui.calculator:id/btn_5_s")).click();
        //
        // click = id com.miui.calculator:id/btn_equal_s
        appiumDriver.findElement(By.id("com.miui.calculator:id/btn_equal_s")).click();
        Thread.sleep(2000);
        // verificar que la suma 7 id com.miui.calculator:id/result
        String expectedResult="= 7";
        String actualResult=appiumDriver.findElement(By.id("com.miui.calculator:id/result")).getText();

        Assertions.assertEquals(expectedResult,actualResult,"ERROR la suma es incorrecta");

    }
}