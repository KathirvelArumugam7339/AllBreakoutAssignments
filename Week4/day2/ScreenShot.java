package Week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ScreenShot {
	public static void main(String[] args) throws IOException {
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--remote-allow-origins=*","--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> newWindow=new ArrayList<String>(windowHandles);
		driver.switchTo().window(newWindow.get(1));
		File source =driver.getScreenshotAs(OutputType.FILE);
		File destination=new File("./snap/flights.png");
		FileUtils.copyFile(source, destination);
		String title = driver.getTitle();
		System.out.println(title);
	}

}
