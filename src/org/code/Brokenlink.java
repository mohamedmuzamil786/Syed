package org.code;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Brokenlink {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Muzzamil\\eclipse-workspace\\SeleniumProject\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> list = driver.findElements(By.tagName("a"));
		int size = list.size();
		System.out.println(size);

		for (WebElement x : list) {
			String attribute = x.getAttribute("href");
			URL u = new URL(attribute);
			URLConnection o = u.openConnection();
			HttpURLConnection h = (HttpURLConnection) o;
			int responseCode = h.getResponseCode();
			if (responseCode != 200) {
			
				System.out.println(attribute);
				
			}

		}

	}

}
