package TestCases.Lecturer;

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
import Interfaces.InterfaceListExam;
import Interfaces.InterfaceLogin;
import Interfaces.InterfaceSearchExamBag;

// Bảng Exam phải có ít nhất 2 bản ghi
// Exam đã được upload student và sinh phách rồi
public class SearchExamBag {
	private static WebDriver driver;
	private static int index;
	private String folder = this.getClass().getName();
	private String testcase;
	@Rule public TestName name = new TestName();
	
	@BeforeClass
	public static void setUpForClass() throws Exception {
		driver = CommonFunction.initWebDriver(Constant.URL_TEST);
		InterfaceLogin.login(driver, Constant.LECTURE_LEVEL);	
		index = CommonFunction.getXpathCount(driver, InterfaceListExam.XPATH_RECORD);
		InterfaceListExam.openSearchExamBagScreen(driver, Integer.toString(index));
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
	public void TKTuiBaiThi_01() throws Exception {
		InterfaceSearchExamBag.search(driver, "", false, false);
	}
	
	@Test
	public void TKTuiBaiThi_02() throws Exception {
		InterfaceSearchExamBag.search(driver, "          ", false, false);
	}
	
	@Test
	public void TKTuiBaiThi_03() throws Exception {
		InterfaceSearchExamBag.search(driver, " 123 ", false, true);
	}
	
	@Test
	public void TKTuiBaiThi_04() throws Exception {
		InterfaceSearchExamBag.search(driver, "123", false, true);
	}
	
	@Test
	public void TKTuiBaiThi_05() throws Exception {
		InterfaceSearchExamBag.search(driver, "2", false, true);
	}
	
	@Test
	public void TKTuiBaiThi_06() throws Exception {
		InterfaceSearchExamBag.search(driver, "555", false, false);
	}
	
	@Test
	public void TKTuiBaiThi_07() throws Exception {
		InterfaceSearchExamBag.search(driver, "23", true, true);
	}
}
