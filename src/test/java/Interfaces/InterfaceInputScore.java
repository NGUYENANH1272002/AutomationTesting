package Interfaces;

import org.openqa.selenium.WebDriver;

import Commons.CommonFunction;
import Commons.Constant;

public class InterfaceInputScore {
	public static String XPATH_EXAM_RESULT_1_TXT				= "//input[@id='examResult1']";
	public static String XPATH_EXAM_RESULT_2_TXT				= "//input[@id='examResult2']";
	public static String XPATH_REGIS_CODE_NUM_TXT				= "//input[@id='registrationCodeNumber']";
	public static String XPATH_ADD_BTN							= "//button[contains(text(),'Add')]";
	public static String XPATH_CLOSE_BTN						= "//button[contains(text(),'Close')]";
	public static String XPATH_SAVE_BTN							= "//button[contains(text(),'Save')]";
	public static String XPATH_CONFIRM_BTN						= "//button[contains(text(),'Xác nhận')]";
	public static String XPATH_DELETE_BTN						= "//tbody/tr[1]/td[6]/*[1]";
		
	public static String SUCCESS_MSG							= "Nhập điểm thành công";
	public static String DATA_ERROR_MSG							= "Đã xảy ra lỗi trong quá trình cập nhật dữ liệu. Vui lòng tắt trình duyệt, mở lại và thử lại sau!";
	public static String REGIS_CODE_NOT_EXIST_MSG				= "Các mã phách: {ma_phach},  không đúng vui lòng kiểm tra lại";
	public static String REGIS_CODE_ABSENT_MSG					= "Các sinh viên: {ma_phach},  đã tích vắng thi nhưng vẫn có điểm, vui lòng liên hệ quản trị viên để được hỗ trợ!";
	
	public static void inputAndValidateNumber(WebDriver driver, String inputXpath, String inputValue) throws Exception {
		InterfaceSearchExamBag.openInputScoreDialog(driver);
		CommonFunction.clickItem(driver, XPATH_DELETE_BTN);
		CommonFunction.sendKeys(driver, inputXpath, inputValue);
		if (inputValue == "-1") {
			CommonFunction.assertValue(driver, inputXpath, "1");
		}
		else if (inputValue == "11") {
			CommonFunction.assertValue(driver, inputXpath, "10");
		}
		else {
			CommonFunction.assertValue(driver, inputXpath, inputValue.replaceAll("[a-zA-Z\\W\\s]", ""));
		}
	}
	
	public static void input(WebDriver driver, String examResult1, String examResult2, String regisCodeNum, String message) throws Exception {
		InterfaceSearchExamBag.openInputScoreDialog(driver);
		CommonFunction.clickItem(driver, XPATH_DELETE_BTN);
		CommonFunction.sendKeys(driver, XPATH_EXAM_RESULT_1_TXT, examResult1);
		CommonFunction.sendKeys(driver, XPATH_EXAM_RESULT_2_TXT, examResult2);
		CommonFunction.sendKeys(driver, XPATH_REGIS_CODE_NUM_TXT, regisCodeNum);
		CommonFunction.clickItem(driver, XPATH_ADD_BTN);
		CommonFunction.clickItem(driver, XPATH_SAVE_BTN);
		if (examResult1 != "" && examResult2 != "" && Math.abs(Double.parseDouble(examResult1) - Double.parseDouble(examResult2)) > 2) {
			CommonFunction.clickItem(driver, XPATH_CONFIRM_BTN);
		}
		
		if (message == REGIS_CODE_ABSENT_MSG || message == REGIS_CODE_NOT_EXIST_MSG) {
			CommonFunction.assertAlertMessage(driver, message.replace(Constant.REGIS_CODE_TEXT, regisCodeNum));
		}
		else {
			CommonFunction.assertAlertMessage(driver, message);
		}
	}
}