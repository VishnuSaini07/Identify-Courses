package pageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class IdentifyCourses extends BasePage {
	
	// constructor
	public IdentifyCourses(WebDriver driver) {
		super(driver);
	}


	// Locators
	
	@FindBy(xpath="//input[@class='react-autosuggest__input']")
	WebElement searchBox;
	
	// englishLanguage
	@FindBy(xpath="//*[@id='cds-react-aria-17-label-text']")
	WebElement englishOption;
	
	@FindBy(xpath="//*[@id='cds-react-aria-45-label-text']")
	WebElement beginnerOption;
	
	@FindBy(xpath="//*[@class='cds-CommonCard-clickArea']")
	List<WebElement> listOfCourses;
	
	@FindBy(xpath="//*[@class='cds-CommonCard-title css-6ecy9b']")
	List<WebElement> courseTitle;
	
	@FindBy(xpath="//p[@class='css-2xargn']")
	List<WebElement> rating;
		
	@FindBy(xpath="//*[@class='cds-CommonCard-metadata']")
	List<WebElement> duration;
	
	Actions act = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	// Actions

	
	public void searchCourse() {
		searchBox.sendKeys("web development courses");
		act.keyDown(Keys.ENTER).perform();
	}
	
	
	public void filterCourse() throws InterruptedException {
		englishOption.click();
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,900)");
		
		beginnerOption.click();
		
		js.executeScript("window.scrollBy(0,-900)");
		Thread.sleep(2000);
	}
	
	public void getCourseDetails() {		
		for(int i=0; i<2; i++) {
			System.out.println("Course Name : " + courseTitle.get(i).getText());
			
			// Beginner · Professional Certificate · 3 - 6 Months
			String temp = duration.get(i).getText();
			String[] str = temp.split("·");
			System.out.println("Course Duration : " + str[2]);
			System.out.println("Course Rating : " + rating.get(i).getText());
			System.out.println();
			
		}
	}
	
}
