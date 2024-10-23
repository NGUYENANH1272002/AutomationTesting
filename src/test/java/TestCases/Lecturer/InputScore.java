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
import Interfaces.InterfaceConfigExam;
import Interfaces.InterfaceExamMnt;
import Interfaces.InterfaceInputScore;
import Interfaces.InterfaceListExam;
import Interfaces.InterfaceLogin;
import Interfaces.InterfaceSearchExamBag;

// Tạo Exam -> Upload student -> Sinh phách -> Nhập ds vắng thi (chỉ có 1 sv đi thi), sử dụng với ExamBag=123
public class InputScore {
	private static WebDriver driver;
	private static int index;
	private static int indexToConfig;
	private String folder = this.getClass().getName();
	private String testcase;
	@Rule public TestName name = new TestName();
	
	@BeforeClass
	public static void setUpForClass() throws Exception {
		driver = CommonFunction.initWebDriver(Constant.URL_TEST);
	}
		
	@Before
	public void setUp() throws Exception {
		InterfaceLogin.login(driver, Constant.LECTURE_LEVEL);	
		index = CommonFunction.getXpathCount(driver, InterfaceListExam.XPATH_RECORD);
		InterfaceListExam.openSearchExamBagScreen(driver, Integer.toString(index));
		InterfaceSearchExamBag.search(driver, "123", true, true);
	}
	
	@After
	public void tearDown() throws Exception {
		testcase = name.getMethodName();
		CommonFunction.captureScreen(driver, folder, testcase);
		InterfaceLogin.openScreen(driver);
		InterfaceLogin.login(driver, Constant.ADMIN_LEVEL);
		indexToConfig = CommonFunction.getXpathCount(driver, InterfaceExamMnt.XPATH_RECORD);
		InterfaceExamMnt.openConfigScreen(driver, Integer.toString(indexToConfig));
		InterfaceConfigExam.resetInputScore(driver);
		InterfaceLogin.openScreen(driver);
	}
	
	@AfterClass
	public static void tearDownForClass() throws Exception {
		CommonFunction.shutDownDriver(driver);
	}

	@Test
	public void QuetPhachNhapDiem_01() throws Exception {
		InterfaceInputScore.input(driver, "5", "5", "18431", InterfaceInputScore.SUCCESS_MSG);
	}
	
	@Test
	public void QuetPhachNhapDiem_03() throws Exception {
		InterfaceInputScore.input(driver, "", "", "", InterfaceInputScore.DATA_ERROR_MSG);
	}
	
	@Test
	public void QuetPhachNhapDiem_04() throws Exception {
		InterfaceInputScore.input(driver, "", "10", "18431", InterfaceInputScore.DATA_ERROR_MSG);
	}
	
	@Test
	public void QuetPhachNhapDiem_05() throws Exception {
		InterfaceInputScore.inputAndValidateNumber(driver, InterfaceInputScore.XPATH_EXAM_RESULT_1_TXT, "-1");
	}
	
	@Test
	public void QuetPhachNhapDiem_06() throws Exception {
		InterfaceInputScore.input(driver, "0", "1.5", "18431", InterfaceInputScore.SUCCESS_MSG);
	}
	
	@Test
	public void QuetPhachNhapDiem_07() throws Exception {
		InterfaceInputScore.input(driver, "10", "8.5", "18431", InterfaceInputScore.SUCCESS_MSG);
	}
	
	@Test
	public void QuetPhachNhapDiem_08() throws Exception {
		InterfaceInputScore.inputAndValidateNumber(driver, InterfaceInputScore.XPATH_EXAM_RESULT_1_TXT, "11");
	}
	
	@Test
	public void QuetPhachNhapDiem_09() throws Exception {
		InterfaceInputScore.inputAndValidateNumber(driver, InterfaceInputScore.XPATH_EXAM_RESULT_1_TXT, "1abc");
	}
	
	@Test
	public void QuetPhachNhapDiem_10() throws Exception {
		InterfaceInputScore.inputAndValidateNumber(driver, InterfaceInputScore.XPATH_EXAM_RESULT_1_TXT, "@#$8");
	}
	
	@Test
	public void QuetPhachNhapDiem_11() throws Exception {
		InterfaceInputScore.inputAndValidateNumber(driver, InterfaceInputScore.XPATH_EXAM_RESULT_1_TXT, "1   0");
	}
	
	@Test
	public void QuetPhachNhapDiem_12() throws Exception {
		InterfaceInputScore.input(driver, "5.555", "6", "18431", InterfaceInputScore.SUCCESS_MSG);
	}
	
	@Test
	public void QuetPhachNhapDiem_13() throws Exception {
		InterfaceInputScore.input(driver, "10", "", "18431", InterfaceInputScore.DATA_ERROR_MSG);
	}
	
	@Test
	public void QuetPhachNhapDiem_14() throws Exception {
		InterfaceInputScore.inputAndValidateNumber(driver, InterfaceInputScore.XPATH_EXAM_RESULT_2_TXT, "-1");
	}
	
	@Test
	public void QuetPhachNhapDiem_15() throws Exception {
		InterfaceInputScore.input(driver, "1.5", "0", "18431", InterfaceInputScore.SUCCESS_MSG);
	}
	
	@Test
	public void QuetPhachNhapDiem_16() throws Exception {
		InterfaceInputScore.input(driver, "8.5", "10", "18431", InterfaceInputScore.SUCCESS_MSG);
	}
	
	@Test
	public void QuetPhachNhapDiem_17() throws Exception {
		InterfaceInputScore.inputAndValidateNumber(driver, InterfaceInputScore.XPATH_EXAM_RESULT_2_TXT, "11");
	}
	
	@Test
	public void QuetPhachNhapDiem_18() throws Exception {
		InterfaceInputScore.inputAndValidateNumber(driver, InterfaceInputScore.XPATH_EXAM_RESULT_2_TXT, "1abc");
	}
	
	@Test
	public void QuetPhachNhapDiem_19() throws Exception {
		InterfaceInputScore.inputAndValidateNumber(driver, InterfaceInputScore.XPATH_EXAM_RESULT_2_TXT, "@#$8");
	}
	
	@Test
	public void QuetPhachNhapDiem_20() throws Exception {
		InterfaceInputScore.inputAndValidateNumber(driver, InterfaceInputScore.XPATH_EXAM_RESULT_2_TXT, "1   0");
	}
	
	@Test
	public void QuetPhachNhapDiem_21() throws Exception {
		InterfaceInputScore.input(driver, "6", "5.555", "18431", InterfaceInputScore.SUCCESS_MSG);
	}
	
	@Test
	public void QuetPhachNhapDiem_22() throws Exception {
		InterfaceInputScore.input(driver, "5.75", "4.55", "18431", InterfaceInputScore.SUCCESS_MSG);
	}
	
	@Test
	public void QuetPhachNhapDiem_23() throws Exception {
		InterfaceInputScore.input(driver, "6.75", "4.75", "18431", InterfaceInputScore.SUCCESS_MSG);
	}
	
	@Test
	public void QuetPhachNhapDiem_24() throws Exception {
		InterfaceInputScore.input(driver, "7.75", "4.75", "18431", InterfaceInputScore.SUCCESS_MSG);
	}
	
	@Test
	public void QuetPhachNhapDiem_25() throws Exception {
		InterfaceInputScore.input(driver, "4.55", "5.75", "18431", InterfaceInputScore.SUCCESS_MSG);
	}
	
	@Test
	public void QuetPhachNhapDiem_26() throws Exception {
		InterfaceInputScore.input(driver, "4.75", "6.75", "18431", InterfaceInputScore.SUCCESS_MSG);
	}
	
	@Test
	public void QuetPhachNhapDiem_27() throws Exception {
		InterfaceInputScore.input(driver, "4.75", "7.75", "18431", InterfaceInputScore.SUCCESS_MSG);
	}
	
	@Test
	public void QuetPhachNhapDiem_28() throws Exception {
		InterfaceInputScore.input(driver, "4.00", "6.00", "", InterfaceInputScore.DATA_ERROR_MSG);
	}
	
	@Test
	public void QuetPhachNhapDiem_29() throws Exception {
		InterfaceInputScore.inputAndValidateNumber(driver, InterfaceInputScore.XPATH_REGIS_CODE_NUM_TXT, "10abc947");
	}
	
	@Test
	public void QuetPhachNhapDiem_30() throws Exception {
		InterfaceInputScore.inputAndValidateNumber(driver, InterfaceInputScore.XPATH_REGIS_CODE_NUM_TXT, "10@#$947");
	}
	
	@Test
	public void QuetPhachNhapDiem_31() throws Exception {
		InterfaceInputScore.inputAndValidateNumber(driver, InterfaceInputScore.XPATH_REGIS_CODE_NUM_TXT, "10   947");
	}
	
	@Test
	public void QuetPhachNhapDiem_32() throws Exception {
		InterfaceInputScore.input(driver, "4.00", "6.00", "10000", InterfaceInputScore.REGIS_CODE_NOT_EXIST_MSG);
	}
	
	@Test
	public void QuetPhachNhapDiem_33() throws Exception {
		InterfaceInputScore.input(driver, "4.00", "6.00", "13813", InterfaceInputScore.REGIS_CODE_ABSENT_MSG);
	}
}
