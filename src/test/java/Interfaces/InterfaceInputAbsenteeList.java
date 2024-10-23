package Interfaces;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import Commons.CommonFunction;

public class InterfaceInputAbsenteeList {
	public static String XPATH_KEYWORD_TXT						= "//input[@id='studentCodeFilter']";
	public static String XPATH_RECORD 							= "//tbody//tr";
		
	public static void searchStudent(WebDriver driver, String keyword, boolean isPressEnter, boolean isSuccess) throws Exception {
		CommonFunction.sendKeys(driver, XPATH_KEYWORD_TXT, keyword);
		if (isPressEnter) {
			CommonFunction.pressKeys(driver, XPATH_KEYWORD_TXT, Keys.ENTER);
		}
		
		int numRecord = CommonFunction.getXpathCount(driver, XPATH_RECORD);
		if (isSuccess) {
			assertTrue(numRecord >= 2);
		}
		else {
			assertTrue(numRecord == 1);
		}
	}
}