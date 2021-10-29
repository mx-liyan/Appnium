package com.ly.appnium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author 李岩
 * @data 2021/10/29 10:29
 */
public class TestDemo {

    AndroidDriver driver;
    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities des = new DesiredCapabilities();
//      des.setCapability("app", "c:\\");
        des.setCapability("deviceName", "127.0.0.1:7555");
        des.setCapability("appPackage", "com.ly.mipos.debug");
        //设置启动Activity
        des.setCapability("appActivity", "com.ly.mipos.MainActivity");
        des.setCapability("platformName", "Android");
        //设置测试的安卓系统版本
        des.setCapability("platformVersion", "6.0.1");
        des.setCapability("udid", "127.0.0.1:7555");
        des.setCapability("unicodeKeyboard", "True");
        des.setCapability("resetKeyboard", "True");
        des.setCapability("newCommandTimeout", "15");
        des.setCapability("nosign", "True");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),des);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void add(){
        driver.findElement(By.id("com.ly.mipos.debug:id/btn_1")).click();
        /*WebDriverWait wa = new WebDriverWait(driver,30);
        WebElement element = wa.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@text, '网络错误')]")));
        System.out.println(element.getText());*/
        try {
            String qk = driver.findElement(By.id("com.ly.mipos.debug:id/txt_clear")).getText();
            Assert.assertEquals(qk,"清空");
        }catch (NoSuchElementException e){
            Assert.fail();
        }
    }
    @AfterClass
    public void after(){
        driver.quit();
    }
}
