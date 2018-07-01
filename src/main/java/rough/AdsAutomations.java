package rough;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AdsAutomations {
	
	public static AndroidDriver<MobileElement> driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
System.out.println("Starting the Appium server....");
		
		AppiumDriverLocalService service= AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder()
						
						.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
						.withAppiumJS(new File("C:\\Users\\Yogesh\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
						.withLogFile(new File("E:\\AppiumResources\\Logs\\appiumLogs.txt")));
		service.start();
		
		System.out.println("Appium server has started....");
		
			
				DesiredCapabilities capabilities = new DesiredCapabilities();
			
				capabilities.setCapability("deviceName", "Android");
			    //capabilities.setCapability("app", app.getAbsolutePath());
				
				
				capabilities.setCapability("appPackage", "com.cherry.advertizement");
				capabilities.setCapability("appActivity", ".view.loginmodule.view.LoginActivity");
			    
				driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			    
				
				
				
				
				driver.findElement(By.id("com.cherry.advertizement:id/edtUserName")).sendKeys("adsqa25@yopmail.com");
				
				driver.findElement(By.id("com.cherry.advertizement:id/edtPassword")).sendKeys("qwerty");
				
				driver.findElement(By.id("com.cherry.advertizement:id/btn_login")).click();

				
				Thread.sleep(5000);
				driver.quit();
				service.stop();
		
	}

}
