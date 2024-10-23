package Interfaces;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;

import Commons.CommonFunction;

public class InterfaceCreateExam {
	public static String XPATH_EXAM_CODE_TXT					= "//input[@name='examCode']";
	public static String XPATH_EXAM_NAME_TXT					= "//input[@name='examName']";
	public static String XPATH_NOTE_TXT							= "//input[@name='note']";
	public static String XPATH_START_REGIS_CODE_TXT				= "//input[@name='startRegistrationCode']";
	public static String XPATH_IS_AUTO_GEN_CHKBOX				= "//input[@name='isAutoGenRegistrationCode']";
	public static String XPATH_ADD_BTN							= "//button[contains(text(),'+ Add')]";
		
	public static String XPATH_ERROR_MSG						= "//div[@class='invalid-feedback']";
	
	public static String ERROR_MESSAGE							= "Không thể tạo kỳ thi mới";
	
	public static void create(WebDriver driver, String code, String name, String note, String startRegistrationCode, boolean isAutoGenRegistrationCode, boolean isSuccess) throws Exception {
		int numRecordBefore = CommonFunction.getXpathCount(driver, InterfaceExamMnt.XPATH_RECORD);
		int numRecordAfter;
		
		CommonFunction.sendKeys(driver, XPATH_EXAM_CODE_TXT, code);
		CommonFunction.sendKeys(driver, XPATH_EXAM_NAME_TXT, name);
		CommonFunction.sendKeys(driver, XPATH_NOTE_TXT, note);
		CommonFunction.sendKeys(driver, XPATH_START_REGIS_CODE_TXT, startRegistrationCode);
		if (isAutoGenRegistrationCode) {
			CommonFunction.clickItem(driver, XPATH_IS_AUTO_GEN_CHKBOX);
		}
		CommonFunction.clickItem(driver, XPATH_ADD_BTN);
		
		if (isSuccess) {
			numRecordAfter = CommonFunction.getXpathCount(driver, InterfaceExamMnt.XPATH_RECORD);
			assertEquals(numRecordBefore+1, numRecordAfter);
		}
		else if (code == "2024-2025K1A") {
			CommonFunction.assertTextValue(driver, XPATH_ERROR_MSG, "Exam Code đã được sử dụng, vui lòng nhập giá trị khác!");
		}
		else if (code.trim() == "" || name.trim() == "" || startRegistrationCode.trim() == ""){
			CommonFunction.assertTextValue(driver, XPATH_ERROR_MSG, "Không được để trống");
		}
		else {
			CommonFunction.assertTextValue(driver, XPATH_ERROR_MSG, "Nhập giá trị trong khoảng 1.000 - 1.000.000");
		}
	}
}