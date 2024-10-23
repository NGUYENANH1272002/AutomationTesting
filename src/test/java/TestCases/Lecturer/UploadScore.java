package TestCases.Lecturer;

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
import Interfaces.InterfaceListExam;
import Interfaces.InterfaceLogin;
import Interfaces.InterfaceSearchExamBag;
import Interfaces.InterfaceUploadScore;

// Vào upload_score folder, copy file valid_file to deleted_valid_file
public class UploadScore {
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
		InterfaceSearchExamBag.search(driver, "123", true, true);
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
	public void NhapDiemTuFileExcel_01() throws Exception {
		InterfaceUploadScore.upload(driver, "valid_file.xlsx", InterfaceUploadScore.SUCCESS_MSG);
	}
	
	@Test
	public void NhapDiemTuFileExcel_02() throws Exception {
		InterfaceUploadScore.upload(driver, "", InterfaceUploadScore.CHOOSE_FILE_MSG);
	}
	
	@Test
	public void NhapDiemTuFileExcel_03() throws Exception {
		InterfaceUploadScore.upload(driver, "deleted_valid_file.xlsx", InterfaceUploadScore.DATA_ERROR_MSG);
	}
	
	@Test
	public void NhapDiemTuFileExcel_04() throws Exception {
		InterfaceUploadScore.upload(driver, "max_name_file_123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678.xlsx", InterfaceUploadScore.SUCCESS_MSG);
	}
	
	@Test
	public void NhapDiemTuFileExcel_05() throws Exception {
		InterfaceUploadScore.upload(driver, "name_contain_special_characters_file_@#$%^&()_+={}[];'.,!~`.xlsx", InterfaceUploadScore.SUCCESS_MSG);
	}
	
	@Test
	public void NhapDiemTuFileExcel_06() throws Exception {
		InterfaceUploadScore.upload(driver, "rename_to_excel_file.xlsx.csv", InterfaceUploadScore.MUST_CHOOSE_EXCEL_FILE_MSG);
	}
	
	@Test
	public void NhapDiemTuFileExcel_07() throws Exception {
		InterfaceUploadScore.upload(driver, "not_excel_file.csv", InterfaceUploadScore.MUST_CHOOSE_EXCEL_FILE_MSG);
	}
	
	@Ignore
	@Test
	public void NhapDiemTuFileExcel_08() throws Exception {
		InterfaceUploadScore.upload(driver, "not_read_permission_file.xlsx", InterfaceUploadScore.CHOOSE_FILE_MSG);
	}
	
	@Test
	public void NhapDiemTuFileExcel_09() throws Exception {
		InterfaceUploadScore.upload(driver, "wrong_format_file.xlsx", InterfaceUploadScore.DATA_ERROR_MSG);
	}
	
	@Test
	public void NhapDiemTuFileExcel_10() throws Exception {
		InterfaceUploadScore.upload(driver, "empty_file.xlsx", InterfaceUploadScore.DATA_ERROR_MSG);
	}
}
