package generic;



	import java.io.FileInputStream;
	import java.util.Properties;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.BeforeMethod;

	public class Lib {
		public static String getproperty(String path ,String key){
			String value="";
			try{
				Properties p= new Properties();
				p.load(new FileInputStream(path));
				value=p.getProperty(key);
			}
			catch(Exception e){
			}
			
			return value;
		
		
	}
	
}
