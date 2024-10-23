package Interfaces;

import org.openqa.selenium.WebDriver;

import Commons.CommonFunction;
import Commons.Constant;

public class InterfaceListExam {
	public static String XPATH_RECORD							= "//tbody//tr";
	public static String XPATH_INPUT_ABSENTEE_LIST_BTN			= "//tbody//tr[INDEX]//td[4]//a[1]";
		
	public static void openSearchExamBagScreen(WebDriver driver, String index) throws Exception {
		CommonFunction.clickItem(driver, XPATH_INPUT_ABSENTEE_LIST_BTN.replace(Constant.INDEX_TEXT, index));
	}
}