package script;

	import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
	import pom.LoginPage;
	import generic.BaseTest;
	import generic.Lib;

	public class ValidLogin extends BaseTest{
		@Test(priority=1)
		public void testValidLogin(){
			
			
			
			LoginPage l= new LoginPage(driver);
			l.clicklogin();
			l.setUserName("7777773001");
			l.setPassword("123456");
		
			l.clicksign();
			l.SearchBar();
			l.Searchkey();
			l.Filter();
			l.PGSEL();
			l.ScheduleVisit();
			
		
			
		}
		
		public void signin(){
			
		}
}
