package TestCases.Admin;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;

import Commons.CommonFunction;
import Commons.Constant;
import Interfaces.InterfaceExamMnt;
import Interfaces.InterfaceLogin;
import Interfaces.InterfaceUploadStudent;

// Bảng Exam phải có ít nhất 2 bản ghi
// Exam đã được upload student rồi
// Vào upload_student folder, copy file valid_file to deleted_valid_file
public class UploadStudent {
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
	public void UploadDSThiSinh_01() throws Exception {
		InterfaceUploadStudent.upload(driver, "valid_file.xlsx", InterfaceUploadStudent.SUCCESS_MSG);
	}
	
	@Test
	public void UploadDSThiSinh_02() throws Exception {
		InterfaceUploadStudent.upload(driver, "", InterfaceUploadStudent.CHOOSE_FILE_MSG);
	}
	
	@Test
	public void UploadDSThiSinh_03() throws Exception {
		InterfaceUploadStudent.upload(driver, "deleted_valid_file.xlsx", InterfaceUploadStudent.DATA_ERROR_MSG);
	}
	
	@Test
	public void UploadDSThiSinh_04() throws Exception {
		InterfaceUploadStudent.upload(driver, "max_name_file_123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678.xlsx", InterfaceUploadStudent.SUCCESS_MSG);
	}
	
	@Test
	public void UploadDSThiSinh_05() throws Exception {
		InterfaceUploadStudent.upload(driver, "name_contain_special_characters_file_@#$%^&()_+={}[];'.,!~`.xlsx", InterfaceUploadStudent.SUCCESS_MSG);
	}
	
	@Test
	public void UploadDSThiSinh_06() throws Exception {
		InterfaceUploadStudent.upload(driver, "rename_to_excel_file.xlsx.csv", InterfaceUploadStudent.MUST_CHOOSE_EXCEL_FILE_MSG);
	}
	
	@Test
	public void UploadDSThiSinh_07() throws Exception {
		InterfaceUploadStudent.upload(driver, "not_excel_file.csv", InterfaceUploadStudent.MUST_CHOOSE_EXCEL_FILE_MSG);
	}
	
	@Ignore
	@Test
	public void UploadDSThiSinh_08() throws Exception {
		InterfaceUploadStudent.upload(driver, "not_read_permission_file.xlsx", InterfaceUploadStudent.CHOOSE_FILE_MSG);
	}
	
	@Test
	public void UploadDSThiSinh_09() throws Exception {
		InterfaceUploadStudent.upload(driver, "wrong_format_file.xlsx", InterfaceUploadStudent.DATA_ERROR_MSG);
	}
	
	@Test
	public void UploadDSThiSinh_10() throws Exception {
		InterfaceUploadStudent.upload(driver, "empty_file.xlsx", InterfaceUploadStudent.DATA_ERROR_MSG);
	}
}
