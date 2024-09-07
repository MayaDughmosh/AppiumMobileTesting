import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class myClass extends Parameter {
	DesiredCapabilities caps=new DesiredCapabilities();
	AndroidDriver driver;
	
	
	@BeforeTest 
	public void mysetUp() {
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "device");
		File myapplication=new File ("src/myApplication/calculator.apk");
		caps.setCapability(MobileCapabilityType.APP, myapplication.getAbsolutePath());
	
	}
	@Test(enabled = false)
	public void clickOnAllButtons() throws MalformedURLException {
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		List <WebElement> allButtons=driver.findElements(By.className("android.widget.ImageButton"));
		for(int i=0;i<allButtons.size();i++) {
			allButtons.get(i).click();
			
		}
		WebElement Result=driver.findElement(By.id("com.google.android.calculator:id/result_preview"));
		String ActualResult=Result.getText();
		String ExpectedResult="Format error";
		Assert.assertEquals(ActualResult, ExpectedResult);
	}
	@Test 
	public void clickOnAllNumbers() throws IOException {
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		String ExpectedValue="7894561230";
		String ActualValue="";
		List <WebElement> allButtons=driver.findElements(By.className("android.widget.ImageButton"));
		for(int i=0;i<allButtons.size();i++) {
			if(allButtons.get(i).getAttribute("resource-id").contains("digit")){
					
			allButtons.get(i).click();
		}
		WebElement fourmla=driver.findElement(By.id("com.google.android.calculator:id/formula"))	;
		String Actual=fourmla.getText();
		ActualValue= Actual;
		}
		Assert.assertEquals(ActualValue, ExpectedValue);
		
takeScreenShotFunction(driver);

		
	}
	

}
