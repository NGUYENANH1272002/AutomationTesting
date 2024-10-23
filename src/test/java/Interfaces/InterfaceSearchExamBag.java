package Interfaces;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import Commons.CommonFunction;

public class InterfaceSearchExamBag {
	public static String XPATH_KEYWORD_TXT						= "//input";
	// Dành cho Admin
//	public static String XPATH_SEARCH_BTN						= "//body/div[@id='root']/div[1]/div[1]/div[3]/div[1]/div[1]/button[1]";
	// Dành cho Employee và Lecturer
	public static String XPATH_SEARCH_BTN						= "//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]/*[1]";
	public static String XPATH_ACTION_BTN						= "//tbody/tr[1]/td[4]";
	public static String XPATH_UPLOAD_SCORE_FILE_BTN			= "//tbody/tr[1]/td[4]/*[1]";
	public static String XPATH_INPUT_SCORE_BTN					= "//tbody/tr[1]/td[4]/*[2]";
	
	public static String XPATH_RECORD 							= "//tbody//tr";

	public static String XPATH_NOT_FOUND_MSG					= "//h4[contains(text(),'Không tìm thấy túi bài thi')]";
		
	public static void search(WebDriver driver, String keyword, boolean isPressEnter, boolean isSuccess) throws Exception {
		CommonFunction.sendKeys(driver, XPATH_KEYWORD_TXT, keyword);
		if (isPressEnter) {
			CommonFunction.pressKeys(driver, XPATH_KEYWORD_TXT, Keys.ENTER);
		}
		else {
			CommonFunction.clickItem(driver, XPATH_SEARCH_BTN);
		}
		
		if (isSuccess) {
			int numRecord = CommonFunction.getXpathCount(driver, XPATH_RECORD);
			assertTrue(numRecord >= 1);
		}
		else {
			CommonFunction.assertElementDisplayed(driver, XPATH_NOT_FOUND_MSG);
		}
	}
	
	public static void openInputAbsenteeListDialog(WebDriver driver) throws Exception {
		CommonFunction.clickItem(driver, XPATH_ACTION_BTN);
	}
	
	public static void openUploadScoreFileDialog(WebDriver driver) throws Exception {
		CommonFunction.clickItem(driver, XPATH_UPLOAD_SCORE_FILE_BTN);
	}
	
	public static void openInputScoreDialog(WebDriver driver) throws Exception {
		CommonFunction.clickItem(driver, XPATH_INPUT_SCORE_BTN);
	}
}