package org.code;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Covid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Muzzamil\\eclipse-workspace\\SeleniumProject\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.covid19india.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 WebElement element = driver.findElement(By.xpath("//div[@class=('table fadeInUp')]"));
         String text = element.getText();
         System.out.println(text);

        List<WebElement> allrow = element.findElements(By.xpath("//div[@class='row']"));
         for (int i = 0; i < allrow.size(); i++) {
			WebElement row = allrow.get(i);
			/*List<WebElement> allcolm = row.findElements(By.tagName("td"));
		for (int j = 0; j < allcolm.size(); j++) {

			WebElement colm = allcolm.get(j);*/
			System.out.println(row.getText());
		}
         
         
         }
         
	}

