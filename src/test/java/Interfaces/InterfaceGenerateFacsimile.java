package Interfaces;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import Commons.CommonFunction;

public class InterfaceGenerateFacsimile {
	public static String XPATH_CANCEL_BTN					= "//button[contains(text(),'Cancel')]";
	public static String XPATH_GEN_BTN						= "//button[contains(text(),'Sinh phách bổ sung')]";
	
	public static String SUCCESS_MSG						= "Sinh thành công 8938 phách";
		
	public static void generate(WebDriver driver, boolean isGenerate) throws Exception {
		InterfaceConfigExam.openGenerateFacsimileDialog(driver);
		if (isGenerate) {
			CommonFunction.clickItem(driver, XPATH_GEN_BTN);
			TimeUnit.SECONDS.sleep(3);
			CommonFunction.assertAlertMessage(driver, SUCCESS_MSG);
		}
		else {
			CommonFunction.clickItem(driver, XPATH_CANCEL_BTN);
		}
	}
}