package generic;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import IAutoConst.IAutoConst;



public class BaseTest implements IAutoConst {
	public WebDriver driver;
	static{
		System.setProperty(CHROME_KEY,CHROME_VALUE);
	
	}
	
	@BeforeMethod
	public void openApplication()
	throws MalformedURLException{
			 
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://52.201.90.154:9002/");
		String url=Lib.getproperty(CONFIG_PATH, "URL");
	}
	
	
	@AfterMethod
	public void closeApplication(){
		driver.quit();
	}
	
}
