package rough;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Appium_Test {
	
	public static AndroidDriver<WebElement> driver;

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability("device", "Android");
		cap.setCapability("deviceName", "Coolpad Note 5");
		cap.setCapability("platformVersion", "6.0.1");
		cap.setCapability("platformName", "Android");
		
		driver=new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("Hello Appium!");
		driver.findElement(By.xpath("//button[@class='Tg7LZd']")).click();
		driver.quit();
		
	}
	
}
