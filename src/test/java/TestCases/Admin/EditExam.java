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
import Interfaces.InterfaceEditExam;
import Interfaces.InterfaceExamMnt;
import Interfaces.InterfaceLogin;

// Bảng Exam phải có ít nhất 3 bản ghi
// Tạo 1 Exam với code "2024-2025K1A" ở vị trí thứ 3
public class EditExam {
	private static WebDriver driver;
	private static int indexToEdit;
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
		indexToEdit = CommonFunction.getXpathCount(driver, InterfaceExamMnt.XPATH_RECORD);
		InterfaceExamMnt.openEditDialog(driver, Integer.toString(indexToEdit));
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
	public void SuaKyThi_01() throws Exception {
		InterfaceEditExam.edit(driver, "SuaKyThi_01", "Kiểm thử sửa kỳ thi", "Kiểm thử sửa kỳ thi", "100000", true, true, true, true, true);
	}
	
	@Test
	public void SuaKyThi_02() throws Exception {
		InterfaceEditExam.edit(driver, "", "Kiểm thử sửa kỳ thi", "Kiểm thử sửa kỳ thi", "100000", true, false, false, true, false);
	}
	
	@Test
	public void SuaKyThi_03() throws Exception {
		InterfaceEditExam.edit(driver, "         ", "Kiểm thử sửa kỳ thi", "Kiểm thử sửa kỳ thi", "100000", true, false, false, true, false);
	}
	
	@Test
	public void SuaKyThi_04() throws Exception {
		InterfaceEditExam.edit(driver, " SuaKyThi_04 ", "Kiểm thử sửa kỳ thi", "Kiểm thử sửa kỳ thi", "100000", true, false, false, true, true);
	}
	
	@Test
	public void SuaKyThi_05() throws Exception {
		InterfaceEditExam.edit(driver, "sc", "Kiểm thử sửa kỳ thi", "Kiểm thử sửa kỳ thi", "100000", true, false, false, true, false);
	}
	
	@Test
	public void SuaKyThi_06() throws Exception {
		InterfaceEditExam.edit(driver, "SuaKyThi_06", "", "Kiểm thử sửa kỳ thi", "100000", true, false, false, true, false);
	}
	
	@Test
	public void SuaKyThi_07() throws Exception {
		InterfaceEditExam.edit(driver, "SuaKyThi_07", "         ", "Kiểm thử sửa kỳ thi", "100000", true, false, false, true, false);
	}
	
	@Test
	public void SuaKyThi_08() throws Exception {
		InterfaceEditExam.edit(driver, "SuaKyThi_08", " Kiểm thử sửa kỳ thi ", "Kiểm thử sửa kỳ thi", "100000", true, false, false, true, true);
	}
	
	@Test
	public void SuaKyThi_09() throws Exception {
		InterfaceEditExam.edit(driver, "SuaKyThi_09", "Kiểm thử sửa kỳ thi", "Kiểm thử sửa kỳ thi", "", true, false, false, true, false);
	}
	
	@Test
	public void SuaKyThi_10() throws Exception {
		InterfaceEditExam.edit(driver, "SuaKyThi_10", "Kiểm thử sửa kỳ thi", "Kiểm thử sửa kỳ thi", "         ", true, false, false, true, false);
	}
	
	@Test
	public void SuaKyThi_11() throws Exception {
		InterfaceEditExam.edit(driver, "SuaKyThi_11", "Kiểm thử sửa kỳ thi", "Kiểm thử sửa kỳ thi", "1abc0", true, false, false, true, false);
	}
	
	@Test
	public void SuaKyThi_12() throws Exception {
		InterfaceEditExam.edit(driver, "SuaKyThi_12", "Kiểm thử sửa kỳ thi", "Kiểm thử sửa kỳ thi", "1@#$0", true, false, false, true, false);
	}
	
	@Test
	public void SuaKyThi_13() throws Exception {
		InterfaceEditExam.edit(driver, "SuaKyThi_13", "Kiểm thử sửa kỳ thi", "Kiểm thử sửa kỳ thi", "-1", true, false, false, true, false);
	}
	
	@Test
	public void SuaKyThi_14() throws Exception {
		InterfaceEditExam.edit(driver, "SuaKyThi_14", "Kiểm thử sửa kỳ thi", "Kiểm thử sửa kỳ thi", "0", true, false, false, true, true);
	}
	
	@Test
	public void SuaKyThi_15() throws Exception {
		InterfaceEditExam.edit(driver, "SuaKyThi_15", "Kiểm thử sửa kỳ thi", "Kiểm thử sửa kỳ thi", "2147483647", true, false, false, true, false);
	}
	
	@Test
	public void SuaKyThi_16() throws Exception {
		InterfaceEditExam.edit(driver, "SuaKyThi_16", "Kiểm thử sửa kỳ thi", "Kiểm thử sửa kỳ thi", " 100000 ", true, false, false, true, true);
	}
	
	@Test
	public void SuaKyThi_17() throws Exception {
		InterfaceEditExam.edit(driver, "SuaKyThi_17", "Kiểm thử sửa kỳ thi", "", "100000", true, false, false, true, true);
	}
	
	@Test
	public void SuaKyThi_18() throws Exception {
		InterfaceEditExam.edit(driver, "SuaKyThi_18", "Kiểm thử sửa kỳ thi", "         ", "100000", true, false, false, true, true);
	}
	
	@Test
	public void SuaKyThi_19() throws Exception {
		InterfaceEditExam.edit(driver, "SuaKyThi_19", "Kiểm thử sửa kỳ thi", " Kiểm thử sửa kỳ thi ", "100000", true, false, false, true, true);
	}
	
	@Test
	public void SuaKyThi_20() throws Exception {
		InterfaceEditExam.edit(driver, "SuaKyThi_20", "Kiểm thử sửa kỳ thi", "Kiểm thử sửa kỳ thi", "100000", false, false, false, true, true);
	}
	
	@Test
	public void SuaKyThi_21() throws Exception {
		InterfaceEditExam.edit(driver, "SuaKyThi_21", "Kiểm thử sửa kỳ thi", "Kiểm thử sửa kỳ thi", "100000", false, false, false, true, true);
	}
	
	@Test
	public void SuaKyThi_22() throws Exception {
		InterfaceEditExam.edit(driver, "SuaKyThi_22", "Kiểm thử sửa kỳ thi", "Kiểm thử sửa kỳ thi", "100000", false, false, false, true, true);
	}
	
	@Test
	public void SuaKyThi_23() throws Exception {
		InterfaceEditExam.edit(driver, "SuaKyThi_22", "Kiểm thử sửa kỳ thi", "Kiểm thử sửa kỳ thi", "100000", false, false, false, false, true);
	}
}
