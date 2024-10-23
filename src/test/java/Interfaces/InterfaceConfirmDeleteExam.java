package Interfaces;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;

import Commons.CommonFunction;

public class InterfaceConfirmDeleteExam {
	public static String XPATH_CANCEL_BTN						= "//button[contains(text(),'Cancel')]";
	public static String XPATH_DELETE_BTN						= "//button[contains(text(),'Delete')]";
		
	public static void delete(WebDriver driver, String index, boolean isSuccess) throws Exception {
		int numRecordBefore = CommonFunction.getXpathCount(driver, InterfaceExamMnt.XPATH_RECORD);
		int numRecordAfter;
		
		InterfaceExamMnt.openConfirmDeleteDialog(driver, index);
		if (isSuccess) {
			CommonFunction.clickItem(driver, XPATH_DELETE_BTN);
			numRecordAfter = CommonFunction.getXpathCount(driver, InterfaceExamMnt.XPATH_RECORD);
			assertEquals(numRecordBefore-1, numRecordAfter);
		}
		else {
			CommonFunction.clickItem(driver, XPATH_CANCEL_BTN);
			numRecordAfter = CommonFunction.getXpathCount(driver, InterfaceExamMnt.XPATH_RECORD);
			assertEquals(numRecordBefore, numRecordAfter);
		}
	}
}