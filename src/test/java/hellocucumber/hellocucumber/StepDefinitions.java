package hellocucumber.hellocucumber;

import io.cucumber.java.en.*;
import junit.framework.Assert;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.table.DataTable;

@SuppressWarnings("unused")
public class StepDefinitions {
	private static WebDriver driver = null;

	@Given("^Open Chrome and navigate to a site$")
	public void open_chrome_and_navigate_to_site() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\dilan\\OneDrive\\Desktop\\SDET Classwork\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.thecranberryeagle.com/");

		System.out.println("This Step opens Chrome and navigates to a site");
	}

	@When("^Enter the email address and first name$")
	public void enter_the_Email_and_First_Name() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		js.executeScript("window.scrollTo(0,1200);");
		Assert.assertEquals("Cranberry Eagle – Serving the Cranberry Twp, Mars, Evans City, Zelienople areas",driver.getTitle());
		System.out.println("This section will scroll down the page.");
	}

	@Then("^Scrolls down the page and clicks on the link at the bottom$")
	public void Scroll_Down_The_Page(io.cucumber.datatable.DataTable dt) throws Throwable {
		
		List<Map<String, String>> userList = dt.asMaps(String.class, String.class);
		
		for (int i = 0; i < 4; i++) 
		{
			driver.manage().deleteAllCookies();
			WebElement fName = driver.findElement(By.id("mce-FNAME"));
			fName.clear();
			fName.sendKeys(userList.get(i).get("fName"));
			
			WebElement lName = driver.findElement(By.id("mce-LNAME"));
			lName.sendKeys(userList.get(i).get("lName"));
			
			WebElement uEmail = driver.findElement(By.id("mce-EMAIL"));
			uEmail.sendKeys(userList.get(i).get("userEmail"));

			driver.findElement(By.id("mc-embedded-subscribe")).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		System.out.println("This step enters the Email and First Name fields on the homepage.");

		driver.close();
	}

}