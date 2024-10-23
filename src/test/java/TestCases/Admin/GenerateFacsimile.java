package TestCases.Admin;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;

import Commons.CommonFunction;
import Commons.Constant;
import Interfaces.InterfaceExamMnt;
import Interfaces.InterfaceGenerateFacsimile;
import Interfaces.InterfaceLogin;

// Bảng Exam phải có ít nhất 2 bản ghi
// Exam có trạng thái là false, đã được upload student và chưa được sinh phách
public class GenerateFacsimile {
	private static WebDriver driver;
	private static int indexToConfig;
	private String folder = this.getClass().getName();
	private String testcase;
	@Rule public TestName name = new TestName();
	
	@BeforeClass
	public static void setUpForClass() throws Exception {
		driver = CommonFunction.initWebDriver(Constant.URL_TEST);
		InterfaceLogin.login(driver, Constant.ADMIN_LEVEL);	
		indexToConfig = CommonFunction.getXpathCount(driver, InterfaceExamMnt.XPATH_RECORD);
		InterfaceExamMnt.openConfigScreen(driver, Integer.toString(indexToConfig));
	}
		
	@Before
	public void setUp() throws Exception {

	}
	
	@After
	public void tearDown() throws Exception {
		testcase = name.getMethodName();
		CommonFunction.captureScreen(driver, folder, testcase);
		CommonFunction.refreshScreen(driver);
	}
	
	@AfterClass
	public static void tearDownForClass() throws Exception {
		CommonFunction.shutDownDriver(driver);
	}

	@Test
	public void SinhPhach_01() throws Exception {
		InterfaceGenerateFacsimile.generate(driver, true);
	}
	
	@Test
	public void SinhPhach_02() throws Exception {
		InterfaceGenerateFacsimile.generate(driver, false);
	}
}
