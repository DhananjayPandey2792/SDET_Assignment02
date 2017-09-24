package generic;

	import org.apache.log4j.Logger;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;

import IAutoConst.IAutoConst;

	public class BasePage implements IAutoConst {
		public WebDriver driver;
		public long lngETO;
		public Logger log;
		public WebDriverWait wait;

		@FindBy(id="logoutLink")
		private WebElement logoutLNK;
	public BasePage(WebDriver driver){
		this.driver=driver;
		String strETO=AutoUtility.getPropertyValue(CONFIG_PATH, "ETO");
		 lngETO = Long.parseLong(strETO);
		 wait=new WebDriverWait(driver, lngETO);
		 log=Logger.getLogger(this.getClass());
		 PageFactory.initElements(driver, this);
	}
	public void clickLogout(){
		AutoUtility.sleep(2);
		logoutLNK.click();
	}
	public void verifyTitle(String eTitle){
		log.info("Expected Title:"+eTitle);
		try{
			wait.until(ExpectedConditions.titleIs(eTitle));
			log.info("title is matching");
		}
		catch(Exception e){
			String aTitle=driver.getTitle();
			log.info("ActualTitle:"+aTitle);
			log.info("Title is not matching");
			Assert.fail();
			
			
		}
		}
	public void verifyElementPresent(WebElement element){
		try{
			wait.until(ExpectedConditions.visibilityOf(element));
				log.info("Element is present");
			}
			catch(Exception e){
				log.info("Element is not present");
				Assert.fail();
			}
		

	}
}
