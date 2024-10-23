package Interfaces;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;

import Commons.CommonFunction;

public class InterfaceEditExam {
	public static String XPATH_EXAM_CODE_TXT					= "//input[@name='examCode']";
	public static String XPATH_EXAM_NAME_TXT					= "//input[@name='examName']";
	public static String XPATH_NOTE_TXT							= "//input[@name='note']";
	public static String XPATH_START_REGIS_CODE_TXT				= "//input[@name='startRegistrationCode']";
	public static String XPATH_IS_AUTO_GEN_CHKBOX				= "//input[@name='isAutoGenRegistrationCode']";
	public static String XPATH_IS_DELETE_CHKBOX					= "//input[@name='isDelete']";
	public static String XPATH_STATUS_CHKBOX					= "//input[@name='status']";
	public static String XPATH_SAVE_BTN							= "//button[contains(text(),'Lưu thay đổi')]";
	public static String XPATH_CANCEL_BTN						= "//button[contains(text(),'Hủy')]";
	
	public static String XPATH_ERROR_MSG						= "//div[@class='invalid-feedback']";
		
	public static String ERROR_MESSAGE							= "Không thể chỉnh sửa thông tin kỳ thi";
	
	public static void edit(WebDriver driver, String code, String name, String note, String startRegistrationCode, boolean isAutoGenRegistrationCode, boolean isDelete, boolean status, boolean isSave, boolean isSuccess) throws Exception {
		int numRecordBefore = CommonFunction.getXpathCount(driver, InterfaceExamMnt.XPATH_RECORD);
		int numRecordAfter;
		
		CommonFunction.sendKeys(driver, XPATH_EXAM_CODE_TXT, code);
		CommonFunction.sendKeys(driver, XPATH_EXAM_NAME_TXT, name);
		CommonFunction.sendKeys(driver, XPATH_NOTE_TXT, note);
		CommonFunction.sendKeys(driver, XPATH_START_REGIS_CODE_TXT, startRegistrationCode);
		if (isAutoGenRegistrationCode) {
			CommonFunction.clickItem(driver, XPATH_IS_AUTO_GEN_CHKBOX);
		}
		if (isDelete) {
			CommonFunction.clickItem(driver, XPATH_IS_DELETE_CHKBOX);
		}
		if (status) {
			CommonFunction.clickItem(driver, XPATH_STATUS_CHKBOX);
		}
		
		if (isSave) {
			CommonFunction.clickItem(driver, XPATH_SAVE_BTN);
			
			if (isSuccess) {
				numRecordAfter = CommonFunction.getXpathCount(driver, InterfaceExamMnt.XPATH_RECORD);
				if (isDelete) {
					assertEquals(numRecordBefore-1, numRecordAfter);
				}
				else {
					assertEquals(numRecordBefore, numRecordAfter);
				}
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
		else {
			CommonFunction.clickItem(driver, XPATH_CANCEL_BTN);
			
			numRecordAfter = CommonFunction.getXpathCount(driver, InterfaceExamMnt.XPATH_RECORD);
			assertEquals(numRecordBefore, numRecordAfter);
		}
	}
}