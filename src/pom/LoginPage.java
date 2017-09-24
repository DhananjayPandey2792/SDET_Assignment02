package pom;

	import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.Reporter;

import generic.BasePage;

	public class LoginPage extends BasePage{
		@FindBy(linkText="LOGIN")
		private WebElement loginBTN;
		
		public void clickLogin(){
			loginBTN.click();
		}
		
		@FindBy(name="name")
		private WebElement unTB;
		
		@FindBy( name="password")
		private WebElement pwTB;
		
		@FindBy( xpath="//input[@type='submit']")
		private WebElement sign;
		@FindBy( id="searchBar")
		private WebElement Search;
		@FindBy( xpath="html/body/div[4]/section/div/div/button")
		private WebElement Searchkey;
		@FindBy( xpath=".//*[@id='content']/div/div[1]/div/form/div/div[1]/select")
		private WebElement Filter;
		@FindBy(linkText="Zolo Goodfellas for Men")
		private WebElement PGSEL;
		@FindBy(linkText="Schedule a Visit")
		private WebElement schedulevisit;
		
		@FindBy(xpath="//span[contains(.,'invalid')]")
		private WebElement errMsg;
		
		public LoginPage(WebDriver driver){
			super(driver);
			PageFactory.initElements(driver,this);
		}
		public void clicklogin(){
			WebElement Loginlink=driver.findElement(By.linkText("LOGIN"));
			Loginlink.click();
		}
		
		public void setUserName(String un){
			unTB.sendKeys(un);
			log.info("entering username"+un);
		}
		public void setPassword(String pw){
			pwTB.sendKeys(pw);
			log.info("entering username"+pw);
		}
		
		public void clicksign(){
			WebElement sign=driver.findElement(By.xpath("//input[@type='submit']"));
			sign.click();
		}
		
		public void SearchBar(){
			WebElement SearchBar=driver.findElement(By.id("searchBar"));
			SearchBar.sendKeys("Electronic City Phase II, Bengaluru, Karnataka, India");
		}
		public void Searchkey(){
			WebElement SearchKey=driver.findElement(By.xpath("html/body/div[4]/section/div/div/button"));
			SearchKey.click();
		}
		public void Filter(){
			WebElement Filterrate=driver.findElement(By.xpath(".//*[@id='content']/div/div[1]/div/form/div/div[1]/select"));
			Select s1=new Select(Filterrate);
			s1.selectByIndex(1);
		}
		public void PGSEL(){
			WebElement PGSEL=driver.findElement(By.linkText("Zolo Goodfellas for Men"));
			PGSEL.click();
		}
		public void ScheduleVisit(){
			WebElement ScheduleaVisit=driver.findElement(By.linkText("Schedule a Visit"));
			ScheduleaVisit.click();
		}
		public void verifyErrMsgIsDisplayed(WebDriver driver){
		  WebDriverWait wait=new WebDriverWait(driver,10);
		  try{
			 wait.until(ExpectedConditions.visibilityOf(errMsg));
			 Reporter.log("PASS: Error Msg Is Displayed",true);
		   }
		  catch(Exception e){
			 Reporter.log("FAIL: Error Msg Is NOT Displayed",true);
			 Assert.fail();
		  }
		}
	}










