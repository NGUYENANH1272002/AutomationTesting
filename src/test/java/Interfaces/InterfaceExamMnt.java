package Interfaces;

import org.openqa.selenium.WebDriver;

import Commons.CommonFunction;
import Commons.Constant;

public class InterfaceExamMnt {
	public static String XPATH_CREATE_NEW_BTN					= "//button[contains(text(),'+ Create new')]";
	public static String XPATH_RECORD							= "//tbody//tr";
	public static String XPATH_ACTIONS_BTN						= "//tbody//tr[INDEX]//td//div//button[@id='input-group-dropdown-1']";
	public static String XPATH_EDIT_BTN							= "//tbody//tr[INDEX]//td[8]//div[1]//div[1]//a[1]";
	public static String XPATH_DELETE_BTN						= "//tbody//tr[INDEX]//td[8]//div[1]//div[1]//a[2]";
	public static String XPATH_CONFIG_BTN						= "//tbody//tr[INDEX]//td[8]//div[1]//div[1]//a[3]";
		
	public static void openCreateNewScreen(WebDriver driver) throws Exception {
		CommonFunction.clickItem(driver, XPATH_CREATE_NEW_BTN);
	}
	
	public static void openEditDialog(WebDriver driver, String index) throws Exception {
		CommonFunction.clickItem(driver, XPATH_ACTIONS_BTN.replace(Constant.INDEX_TEXT, index));
		CommonFunction.clickItem(driver, XPATH_EDIT_BTN.replace(Constant.INDEX_TEXT, index));
	}
	
	public static void openConfirmDeleteDialog(WebDriver driver, String index) throws Exception {
		CommonFunction.clickItem(driver, XPATH_ACTIONS_BTN.replace(Constant.INDEX_TEXT, index));
		CommonFunction.clickItem(driver, XPATH_DELETE_BTN.replace(Constant.INDEX_TEXT, index));
	}
	
	public static void openConfigScreen(WebDriver driver, String index) throws Exception {
		CommonFunction.clickItem(driver, XPATH_ACTIONS_BTN.replace(Constant.INDEX_TEXT, index));
		CommonFunction.clickItem(driver, XPATH_CONFIG_BTN.replace(Constant.INDEX_TEXT, index));
	}
}