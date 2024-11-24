package testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_004_CaptureScreenshot {

	@Test
	public void verify_captureScreenshot() throws IOException {
		
			WebDriver driver = new ChromeDriver();
			driver.get("https://tutorialsninja.com/demo/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();

			TakesScreenshot  takeScreenshot=(TakesScreenshot) driver;
			File scrFile=takeScreenshot.getScreenshotAs(OutputType.FILE);
			File targetFile = new File(System.getProperty("user.dir") + "\\screenshots\\" + "fullpage" + ".png");
			scrFile.renameTo(targetFile);
		}
	
}
