package rough;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.android.AndroidDriver;

public class DropDownAppiumDemo {
	
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
		
		driver.get("https://www.wikipedia.org/");
		
		WebElement lang=driver.findElement(By.id("searchLanguage"));
		
		Select select=new Select(lang);
		select.selectByValue("da");
		
		/*List<WebElement> values = driver.findElements(By.tagName("option"));
		
		System.out.println(values.size());
		
		for(WebElement value:values) {
			
			System.out.println(value.getAttribute("lang"));
			
		}*/
		
		List<WebElement> links =driver.findElements(By.tagName("a"));
		
		System.out.println("Total links are: "+links.size());
		
		for(WebElement link:links) {
			
			System.out.println(link.getAttribute("href")+"-------"+link.getText());
			
		}
		
		driver.quit();
		
	}

}
