package Week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnAlerts {
	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("(//span[text()='Show'])[2]")).click();
		Alert alert=driver.switchTo().alert();
		String msg=alert.getText();
		alert.accept();
		System.out.println(msg);
		String verify =driver.findElement(By.id("result")).getText();
		if(verify.contains("User Clicked : OK")) {
			System.out.println("Alert is Handled");
		}
		else {
			System.out.println("Aler is Not handled");
		}

		
		
		
	}
}