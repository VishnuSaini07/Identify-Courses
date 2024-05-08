package utility;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import pageObject.BasePage;

public class ScreenShots extends BasePage {
	public ScreenShots(WebDriver driver) {
		super(driver);
	}

	//Whole Page Screenshot
	public String ScreenShot(String fileName) throws IOException {
		String path = "C:\\Users\\2317464\\eclipse-workspace\\HackathonProject\\screenshots\\" + fileName + ".png";
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(path);
		FileUtils.copyFile(src, trg);
		return path;
	}

}
