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
import Interfaces.InterfaceConfirmDeleteExam;
import Interfaces.InterfaceExamMnt;
import Interfaces.InterfaceLogin;

// Bảng Exam phải có ít nhất 2 bản ghi
public class DeleteExam {
	private static WebDriver driver;
	private static int indexToDelete;
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
		indexToDelete = CommonFunction.getXpathCount(driver, InterfaceExamMnt.XPATH_RECORD);
	}
	
	@After
	public void tearDown() throws Exception {
		testcase = name.getMethodName();
		CommonFunction.captureScreen(driver, folder, testcase);
	}
	
	@AfterClass
	public static void tearDownForClass() throws Exception {
		CommonFunction.shutDownDriver(driver);
	}

	@Test
	public void XoaKyThi_01() throws Exception {
		InterfaceConfirmDeleteExam.delete(driver, Integer.toString(indexToDelete), true);
	}
	
	@Test
	public void XoaKyThi_02() throws Exception {
		InterfaceConfirmDeleteExam.delete(driver, Integer.toString(indexToDelete), false);
	}
}
