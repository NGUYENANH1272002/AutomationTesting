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
import Interfaces.InterfaceCreateExam;
import Interfaces.InterfaceExamMnt;
import Interfaces.InterfaceLogin;

// Vào DB xóa hết data của bảng Exam
// Tạo 1 Exam với code "2024-2025K1A"
public class CreateExam {
	private static WebDriver driver;
	private String folder = this.getClass().getName();
	private String testcase;
	@Rule public TestName name = new TestName();
	
	@BeforeClass
	public static void setUpForClass() throws Exception {
		driver = CommonFunction.initWebDriver(Constant.URL_TEST);
		InterfaceLogin.login(driver, Constant.ADMIN_LEVEL);
	}
		
	@Before
	public void setUp() throws Exception {
		InterfaceExamMnt.openCreateNewScreen(driver);
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
	public void ThemKyThi_01() throws Exception {
		InterfaceCreateExam.create(driver, "ThemKyThi_01", "Kiểm thử thêm kỳ thi", "Kiểm thử thêm kỳ thi", "100000", true, true);
	}
	
	@Test
	public void ThemKyThi_02() throws Exception {
		InterfaceCreateExam.create(driver, "", "Kiểm thử thêm kỳ thi", "Kiểm thử thêm kỳ thi", "100000", true, false);
	}
	
	@Test
	public void ThemKyThi_03() throws Exception {
		InterfaceCreateExam.create(driver, "         ", "Kiểm thử thêm kỳ thi", "Kiểm thử thêm kỳ thi", "100000", true, false);
	}
	
	@Test
	public void ThemKyThi_04() throws Exception {
		InterfaceCreateExam.create(driver, " ThemKyThi_04 ", "Kiểm thử thêm kỳ thi", "Kiểm thử thêm kỳ thi", "100000", true, true);
	}
	
	@Test
	public void ThemKyThi_05() throws Exception {
		InterfaceCreateExam.create(driver, "2024-2025K1A", "Kiểm thử thêm kỳ thi", "Kiểm thử thêm kỳ thi", "100000", true, false);
	}
	
	@Test
	public void ThemKyThi_06() throws Exception {
		InterfaceCreateExam.create(driver, "ThemKyThi_06", "", "Kiểm thử thêm kỳ thi", "100000", true, false);
	}
	
	@Test
	public void ThemKyThi_07() throws Exception {
		InterfaceCreateExam.create(driver, "ThemKyThi_07", "         ", "Kiểm thử thêm kỳ thi", "100000", true, false);
	}
	
	@Test
	public void ThemKyThi_08() throws Exception {
		InterfaceCreateExam.create(driver, "ThemKyThi_08", " Kiểm thử thêm kỳ thi ", "Kiểm thử thêm kỳ thi", "100000", true, true);
	}
	
	@Test
	public void ThemKyThi_09() throws Exception {
		InterfaceCreateExam.create(driver, "ThemKyThi_09", "Kiểm thử thêm kỳ thi", "Kiểm thử thêm kỳ thi", "", true, false);
	}
	
	@Test
	public void ThemKyThi_10() throws Exception {
		InterfaceCreateExam.create(driver, "ThemKyThi_10", "Kiểm thử thêm kỳ thi", "Kiểm thử thêm kỳ thi", "         ", true, false);
	}
	
	@Test
	public void ThemKyThi_11() throws Exception {
		InterfaceCreateExam.create(driver, "ThemKyThi_11", "Kiểm thử thêm kỳ thi", "Kiểm thử thêm kỳ thi", "1abc0", true, false);
	}
	
	@Test
	public void ThemKyThi_12() throws Exception {
		InterfaceCreateExam.create(driver, "ThemKyThi_12", "Kiểm thử thêm kỳ thi", "Kiểm thử thêm kỳ thi", "1@#$0", true, false);
	}
	
	@Test
	public void ThemKyThi_13() throws Exception {
		InterfaceCreateExam.create(driver, "ThemKyThi_13", "Kiểm thử thêm kỳ thi", "Kiểm thử thêm kỳ thi", "-1", true, false);
	}
	
	@Test
	public void ThemKyThi_14() throws Exception {
		InterfaceCreateExam.create(driver, "ThemKyThi_14", "Kiểm thử thêm kỳ thi", "Kiểm thử thêm kỳ thi", "0", true, false);
	}
	
	@Test
	public void ThemKyThi_15() throws Exception {
		InterfaceCreateExam.create(driver, "ThemKyThi_15", "Kiểm thử thêm kỳ thi", "Kiểm thử thêm kỳ thi", "2147483647", true, false);
	}
	
	@Test
	public void ThemKyThi_16() throws Exception {
		InterfaceCreateExam.create(driver, "ThemKyThi_16", "Kiểm thử thêm kỳ thi", "Kiểm thử thêm kỳ thi", " 100000 ", true, true);
	}
	
	@Test
	public void ThemKyThi_17() throws Exception {
		InterfaceCreateExam.create(driver, "ThemKyThi_17", "Kiểm thử thêm kỳ thi", "", "100000", true, true);
	}
	
	@Test
	public void ThemKyThi_18() throws Exception {
		InterfaceCreateExam.create(driver, "ThemKyThi_18", "Kiểm thử thêm kỳ thi", "         ", "100000", true, true);
	}
	
	@Test
	public void ThemKyThi_19() throws Exception {
		InterfaceCreateExam.create(driver, "ThemKyThi_19", "Kiểm thử thêm kỳ thi", " Kiểm thử thêm kỳ thi ", "100000", true, true);
	}
	
	@Test
	public void ThemKyThi_20() throws Exception {
		InterfaceCreateExam.create(driver, "ThemKyThi_20", "Kiểm thử thêm kỳ thi", "Kiểm thử thêm kỳ thi", "100000", false, true);
	}
}
