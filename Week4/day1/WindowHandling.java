package Week4.day1;

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

public class WindowHandling {
	public static void main(String[]args) throws IOException {
		
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		String title = driver.getTitle();
		System.out.println("Parent:"+title);
		//click on open button
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		
		System.out.println(windowHandles.size());
		
		List<String> newWindow=new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(newWindow.get(1));
		File source =driver.getScreenshotAs(OutputType.FILE);
		File destination=new File("./snap/img.png");
		FileUtils.copyFile(source, destination);
		
				
		String title2 = driver.getTitle();
		System.out.println("Child:"+title2);

		
		
		
		
	}

}
