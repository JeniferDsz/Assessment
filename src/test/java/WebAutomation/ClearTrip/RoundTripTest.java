package WebAutomation.ClearTrip;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Resources.Base;

public class RoundTripTest extends Base {

	@Test
	public void launch() throws IOException, InterruptedException {
		WebDriver driver = initializedriver();
		RoundTrip rt = new RoundTrip(driver);
		Thread.sleep(5000);
		rt.roundtripclick().click();
		rt.scroll();
		rt.fromclick().sendKeys("Bangalore");
		Thread.sleep(5000);
		rt.selectfrom();
		rt.toclick().sendKeys("Mumbai");
		rt.selectTo();
		rt.departure().click();
		rt.selectDate();
		Thread.sleep(2000);
		rt.returnDate();
		Thread.sleep(2000);
	}

	@AfterTest
	public void closebrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		// making the driver object as null to save the memory;
		driver = null;
	}
}
