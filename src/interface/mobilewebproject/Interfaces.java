package mobilewebproject;

public class Interfaces {

	public class AbstractPage{
		
	}
	public class LoginPage {
		public static final String TXT_EMAIL = "//input[@id='Email']";
		public static final String BTN_NEXT="//input[@id='next']";
		public static final String LBL_DYNAMIC_ERROR="//span[@id='errormsg_0_Email' and contains(text(),'%s')]";

	}
	
}