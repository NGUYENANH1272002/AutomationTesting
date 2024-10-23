package Interfaces;
import org.openqa.selenium.WebDriver;
import Commons.CommonFunction;
import Commons.Constant;

public class InterfaceLogin {
	public static String XPATH_ADMIN_LOGIN_BTN 				= "//a[contains(text(),'Admin Login')]";
	public static String XPATH_EMPLOYEE_LOGIN_BTN 			= "//a[contains(text(),'Employee Login')]";
	public static String XPATH_LECTURE_LOGIN_BTN 			= "//a[contains(text(),'Lecture Login')]";
		
	public static void openScreen(WebDriver driver) throws Exception {
		CommonFunction.clickItem(driver, "//a[contains(text(),'Home')]");
	}
	
	public static void login(WebDriver driver, String level) throws Exception {
		if (level == Constant.ADMIN_LEVEL) {
			CommonFunction.clickItem(driver, XPATH_ADMIN_LOGIN_BTN);
		}
		else if (level == Constant.EMPLOYEE_LEVEL) {
			CommonFunction.clickItem(driver, XPATH_EMPLOYEE_LOGIN_BTN);
		}
		else if (level == Constant.LECTURE_LEVEL) {
			CommonFunction.clickItem(driver, XPATH_LECTURE_LOGIN_BTN);
		}
	}
}