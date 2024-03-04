package com.ssdecom.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ssdecom.dto.UserDto;

public class Validations {
	public static void main(String[] args) {
		
		String product="erhdgdghjyu.767868932.jpg";
		boolean b= validateImage(product);
		System.out.println(b);
	}
	
	public static boolean validateLetters(String txt) {

	    String regx ="^[a-zA-Z\\s]*$";
	    Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(txt);
	    return matcher.find();

	}
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

		public static boolean validateEmail(String emailStr) {
		        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		        return matcher.matches();
		}
		public static boolean validatePhoneNo(String txt) {
		String regex = "^\\d{10}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(txt);
			 return matcher.matches();
		}
		public static boolean validateAdharNo(String txt) {
			String regex= "^[2-9]{1}[0-9]{11}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(txt);
			 return matcher.matches();
			
		}
		public static boolean validateProductName(String txt) {

		    String regx ="^[a-zA-Z\\s0-9._+-]*$";
		    Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
		    Matcher matcher = pattern.matcher(txt);
		    return matcher.find();
		}
		
//		^\d+(,\d{1,2})?$
//		"^\\u20B9[0-9]{1,3}(, [0-9]{3})*\\.[0-9]{2}$|^(Rs\\.\\s)"
		public static boolean validatePrice(String txt) {
			String regx = "^(Rs|$)+[0-9]{1}[0-9,]+\\.[0-9]{2}$";
		    Pattern pattern = Pattern.compile(regx);
		    Matcher matcher = pattern.matcher(txt);
		    return matcher.find();
			
		}
		public static boolean validateImage(String txt) {
			String regx = "^[a-zA-Z0-9:./%#_+-]+(\\.(?i)(jpe?g|png|gif|bmp|avif))$";
		    Pattern pattern = Pattern.compile(regx);
		    Matcher matcher = pattern.matcher(txt);
		    return matcher.find();
			
		}
		

}
