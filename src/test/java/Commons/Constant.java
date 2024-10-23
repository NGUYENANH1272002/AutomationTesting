package Commons;

public class Constant {
	public static String DRIVER_KEY 			= "webdriver.chrome.driver";
	public static String DRIVER_KEY_LOCATION 	= System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe";// khởi tạo trình duyệt 

	public static String URL_TEST				= "http://localhost:3000/";

	public static String ADMIN_LEVEL			= "admin";
	public static String EMPLOYEE_LEVEL			= "employee";
	public static String LECTURE_LEVEL			= "lecture";
	
	public static String INDEX_TEXT				= "INDEX";
	public static String REGIS_CODE_TEXT		= "{ma_phach}";
	
	public static String UPLOAD_STUDENT_FILE_LOCATION 	= System.getProperty("user.dir") + "\\src\\test\\resources\\test_data\\upload_student\\";
	public static String UPLOAD_SCORE_FILE_LOCATION		= System.getProperty("user.dir") + "\\src\\test\\resources\\test_data\\upload_score\\";
}
