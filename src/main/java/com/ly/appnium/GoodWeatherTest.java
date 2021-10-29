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
 * @data 2021/10/29 16:04
 */
public class GoodWeatherTest {
    AndroidDriver driver;
    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities des = new DesiredCapabilities();
//      des.setCapability("app", "c:\\");
        des.setCapability("deviceName", "127.0.0.1:7555");
        des.setCapability("appPackage", "com.llw.goodweather");
        //设置启动Activity
        des.setCapability("appActivity", "com.llw.goodweather.MainActivity");
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
    public void add() throws InterruptedException {
        driver.findElement(By.id("com.llw.goodweather:id/iv_add")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("com.llw.goodweather:id/tv_change_city")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[6]/android.widget.TextView")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[7]/android.widget.TextView")).click();
        Thread.sleep(1000);
        /*WebDriverWait wa = new WebDriverWait(driver,30);
        WebElement element = wa.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@text, '网络错误')]")));
        System.out.println(element.getText());*/
        try {
            String qk = driver.findElement(By.id("com.llw.goodweather:id/tv_title")).getText();
            Assert.assertEquals(qk,"浑南区");
        }catch (NoSuchElementException e){
            Assert.fail();
        }
    }
    @AfterClass
    public void after(){
        driver.quit();
    }
}
