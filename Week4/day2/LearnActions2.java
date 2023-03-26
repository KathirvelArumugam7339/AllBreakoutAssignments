package Week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class LearnActions2 {
	public static void main(String[] args) throws IOException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*","--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Actions builder =new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//a[text()='Collections']"));
		builder.scrollToElement(ele).perform();
		
		File source =driver.getScreenshotAs(OutputType.FILE);
		File destination=new File("./snap/img2.png");
		FileUtils.copyFile(source, destination);
		
				
		
		
	}

}
