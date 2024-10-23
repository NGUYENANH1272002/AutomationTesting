package Interfaces;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import Commons.CommonFunction;
import Commons.Constant;

public class InterfaceUploadStudent {
	public static String XPATH_DELETE_DATA_BTN					= "//button[contains(text(),'Xoá dữ liệu nhập lại')]";
	public static String XPATH_UPLOAD_FILE_TXT					= "//input[@type='file']";
	public static String XPATH_IS_CHK_DATA_CHKBOX				= "//input[@name='isCheckData']";
	public static String XPATH_CANCEL_BTN						= "//button[contains(text(),'Cancel')]";
	public static String XPATH_UPLOAD_BTN						= "//button[contains(text(),'Upload')]";
	
	public static String XPATH_TITLE							= "//h2";
	
	public static String SUCCESS_MSG							= "Import thành công 8938 sinh viên";
	public static String CHOOSE_FILE_MSG						= "Please choose excel file to upload!";
	public static String MUST_CHOOSE_EXCEL_FILE_MSG				= "Must choose excels file to upload, please!";
	public static String DATA_ERROR_MSG							= "File Excel không có dữ liệu hoặc sai định dạng, vui lòng kiểm tra lại dữ liệu file excel!";
		
	public static void upload(WebDriver driver, String file, String message) throws Exception {
		InterfaceConfigExam.openUploadStudentDialog(driver);
		CommonFunction.clickItem(driver, XPATH_DELETE_DATA_BTN);
		if (!file.equals("")) {
			CommonFunction.clickItem(driver, XPATH_UPLOAD_FILE_TXT);
			Robot rb = new Robot();
			// Copy File path vào Clipboard
			StringSelection str = new StringSelection(Constant.UPLOAD_STUDENT_FILE_LOCATION + file);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
			Thread.sleep(1000);
			// Nhấn Control+V để dán
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			// Xác nhận Control V trên
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			Thread.sleep(1000);
			// Nhấn Enter
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(4000);
		}
		
		if (file.equals("deleted_valid_file.xlsx")) {
			File deleteFile = new File(Constant.UPLOAD_STUDENT_FILE_LOCATION + file);
			deleteFile.delete();
		}
		CommonFunction.clickItem(driver, XPATH_UPLOAD_BTN);
		TimeUnit.SECONDS.sleep(3);
		
		CommonFunction.assertAlertMessage(driver, message);
	}
}