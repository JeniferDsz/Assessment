package WebAutomation.ClearTrip;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RoundTrip {

	public WebDriver driver;
	public WebDriverWait d;

	public RoundTrip(WebDriver driver) {
		this.driver = driver;
	}

	By roundtrip = By.xpath("//input[@id='RoundTrip']");
	By from = By.xpath("//input[@id='FromTag']");
	By autosuggest = By.xpath("//li[@class='list']//a");
	By to = By.xpath("//input[@id='ToTag']");
	By departdate = By.xpath("//input[@id='DepartDate']");
	// By alldates = By.xpath("//td[@data-handler='selectDay']");
	By month_first = By.xpath("//div[@id='ui-datepicker-div']//div//table//tbody//tr//td");
	By month_last = By.xpath("//div[@id='ui-datepicker-div']//div[2]//table//tbody//tr//td");

	public WebElement roundtripclick() {
		d = new WebDriverWait(driver, 10);
		d.until(ExpectedConditions.elementToBeClickable(roundtrip));
		return driver.findElement(roundtrip);
	}

	public WebElement fromclick() {
		return driver.findElement(from);
	}

	// Code to handle autosuggestive dropdown
	public void selectfrom() {
		d = new WebDriverWait(driver, 20);
		d.until(ExpectedConditions.elementToBeClickable(autosuggest));
		List<WebElement> options = driver.findElements(autosuggest);
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("Bangalore")) {
				option.click();
				break;
			}
		}
	}

	public WebElement toclick() {
		return driver.findElement(to);
	}

	public void selectTo() {
		d = new WebDriverWait(driver, 20);
		d.until(ExpectedConditions.invisibilityOfElementLocated(autosuggest));
		List<WebElement> options = driver.findElements(autosuggest);
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("Mumbai")) {
				option.click();
				break;
			}
		}
	}

	// Below code is to scroll down the scroll bar
	public void scroll() throws InterruptedException {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(5000);
		a.click(driver.findElement(departdate)).perform();
	}

	public WebElement departure() {
		return driver.findElement(departdate);
	}

	public void selectDate() {
		List<WebElement> dates = driver.findElements(month_first);
		for (WebElement date : dates) {
			if (date.getText().equalsIgnoreCase("20")) {
				date.click();
				break;
			}

		}
	}

	public void returnDate() {
		List<WebElement> dates = driver.findElements(month_last);
		for (WebElement date : dates) {
			if (date.getText().equalsIgnoreCase("25")) {
				date.click();
				System.out.println(date.getText());
				break;
			}

		}
	}
}
