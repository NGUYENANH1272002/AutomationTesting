package TestCases.Employee;

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
import Interfaces.InterfaceInputAbsenteeList;
import Interfaces.InterfaceListExam;
import Interfaces.InterfaceLogin;
import Interfaces.InterfaceSearchExamBag;

// Bảng Exam phải có ít nhất 2 bản ghi
// Exam đã được upload student và sinh phách rồi
public class SearchStudent {
	private static WebDriver driver;
	private static int index;
	private String folder = this.getClass().getName();
	private String testcase;
	@Rule public TestName name = new TestName();
	
	@BeforeClass
	public static void setUpForClass() throws Exception {
		driver = CommonFunction.initWebDriver(Constant.URL_TEST);
		InterfaceLogin.login(driver, Constant.EMPLOYEE_LEVEL);	
		index = CommonFunction.getXpathCount(driver, InterfaceListExam.XPATH_RECORD);
		InterfaceListExam.openSearchExamBagScreen(driver, Integer.toString(index));
	}
		
	@Before
	public void setUp() throws Exception {
		InterfaceSearchExamBag.search(driver, "123", true, true);
		InterfaceSearchExamBag.openInputAbsenteeListDialog(driver);
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
	public void TKSinhVien_01() throws Exception {
		InterfaceInputAbsenteeList.searchStudent(driver, "", false, true);
	}
	
	@Test
	public void TKSinhVien_02() throws Exception {
		InterfaceInputAbsenteeList.searchStudent(driver, "          ", false, true);
	}
	
	@Test
	public void TKSinhVien_03() throws Exception {
		InterfaceInputAbsenteeList.searchStudent(driver, " 2021070156 ", false, true);
	}
	
	@Test
	public void TKSinhVien_04() throws Exception {
		InterfaceInputAbsenteeList.searchStudent(driver, "2021070156", false, true);
	}
	
	@Test
	public void TKSinhVien_05() throws Exception {
		InterfaceInputAbsenteeList.searchStudent(driver, "2021070", false, true);
	}
	
	@Test
	public void TKSinhVien_06() throws Exception {
		InterfaceInputAbsenteeList.searchStudent(driver, "2021070555", false, false);
	}
	
	@Test
	public void TKSinhVien_07() throws Exception {
		InterfaceInputAbsenteeList.searchStudent(driver, "70", true, true);
	}
}
