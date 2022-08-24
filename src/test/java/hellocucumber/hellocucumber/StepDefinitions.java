package hellocucumber.hellocucumber;

import io.cucumber.java.en.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@SuppressWarnings("unused")
public class StepDefinitions {
	private static WebDriver driver = null;

	@Given("^Open Chrome and navigate to a site$")
	public void open_chrome_and_navigate_to_site() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:chromedriver.exe"); //Edit path to chromedriver.exe here
		driver = new ChromeDriver();
		driver.get("http://www.thecranberryeagle.com/");

		System.out.println("This Step opens Chrome and navigates to a site");
	}

	@When("^Enter the email address and first name$")
	public void scrollDownPage() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		js.executeScript("window.scrollTo(0,1500);");
		System.out.println("This section will scroll down the page.");
	}

	@Then("^Scrolls down the page and clicks on the link at the bottom$")
	public void userActionsHere() throws Throwable {
		
		System.out.println("This step does actions.");
		
		//driver.close(); 
		//Above line commented out to show finial actions of test, uncomment to close testing window automatically.
	}

}
