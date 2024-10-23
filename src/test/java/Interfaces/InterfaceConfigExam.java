package Interfaces;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import Commons.CommonFunction;

public class InterfaceConfigExam {
	public static String XPATH_UPLOAD_STUDENT_LINK				= "//b[contains(text(),'Upload Student')]";
	public static String XPATH_GEN_FACSIMILE_LINK				= "//b[contains(text(),'Sinh phách')]";
	public static String XPATH_EXPORT_SCORE_LINK				= "//b[contains(text(),'Xuất bảng điểm')]";
	
	public static String XPATH_KEYWORD_TXT						= "//input";
	public static String XPATH_INPUT_SCORE_BTN					= "//tbody//tr[1]/td[5]//*[@class='text-primary ud-cursor']";
		
	public static void openUploadStudentDialog(WebDriver driver) throws Exception {
		CommonFunction.clickItem(driver, XPATH_UPLOAD_STUDENT_LINK);
	}
	
	public static void openGenerateFacsimileDialog(WebDriver driver) throws Exception {
		CommonFunction.clickItem(driver, XPATH_GEN_FACSIMILE_LINK);
	}
	
	public static void openSearchExamBagScreen(WebDriver driver) throws Exception {
		CommonFunction.clickItem(driver, XPATH_EXPORT_SCORE_LINK);
	}
	
	public static void resetInputScore(WebDriver driver) throws Exception {
		CommonFunction.sendKeys(driver, XPATH_KEYWORD_TXT, "7100140");
		CommonFunction.pressKeys(driver, XPATH_KEYWORD_TXT, Keys.ENTER);
		CommonFunction.doubleClickItem(driver, XPATH_INPUT_SCORE_BTN);
	}
}