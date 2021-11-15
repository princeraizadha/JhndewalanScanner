package com.jhandewalan.scanner.Support;

import android.widget.EditText;

import java.util.regex.Pattern;

/**
 * Created by nishantgupta on 16/08/17.
 */

public class Validation {
    // Regular Expression
    // you can change the expression based on your need
    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    //    private static final String PHONE_REGEX = "\\d{2}-\\d{10}";
    private static final String PHONE_REGEX = "^[789]\\d{9}$";

    // Error Messages
//    private static final String REQUIRED_MSG = "required";
//    private static final String EMAIL_MSG = "invalid email";
//    private static final String PHONE_MSG = "###-#######";

    // call this method when you need to check email validation
    public static boolean isEmailAddress(EditText editText, boolean required, String errMsg) {
        return isValid(editText, EMAIL_REGEX, errMsg, required);
    }

    // call this method when you need to check phone number validation
    public static boolean isPhoneNumber(EditText editText, boolean required, String errMsg) {
        return isValid(editText, PHONE_REGEX, errMsg, required);
    }

    // return true if the input field is valid, based on the parameter passed
    public static boolean isValid(EditText editText, String regex, String errMsg, boolean required) {

        String text = editText.getText().toString().trim();
        // clearing the error, if it was previously set by some other values
        editText.setError(null);

        // text required and editText is blank, so return false
        if (required && !hasText(editText, errMsg)) return false;

        // pattern doesn't match so returning false
        if (required && !Pattern.matches(regex, text)) {
            editText.setError(errMsg);
            return false;
        }

        return true;
    }

    // check the input field has any text or not
    // return true if it contains text otherwise false
    public static boolean hasText(EditText editText, String errorMsg) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

        // length 0 means there is no text
        if (text.length() == 0) {
            editText.setError(errorMsg);
            return false;
        }

        return true;
    }

    // check the length of input field
    public static boolean hasLength(EditText editText, String message) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

        // length 0 means there is no text
        if (text.length() < 4) {
            editText.setError(message);
            return false;
        }

        return true;
    }

    // check value is greater then 1
    public static boolean isGreater(EditText editText, String message) {

        String text = editText.getText().toString().trim();
        editText.setError(null);
        int value = Integer.parseInt(text);

        // length 0 means there is no text
        if (value < 1) {
            editText.setError(message);
            return false;
        }

        return true;
    }

    /* public static boolean hasMatching(EditText password, EditText confirm_password, String message) {

        System.out.println();

        String pass = password.getText().toString().trim();
        String conf = confirm_password.getText().toString().trim();
        confirm_password.setError(null);

        // length 0 means there is no text
        if (!pass.equalsIgnoreCase(conf)) {
            confirm_password.setError(message);
            return false;
        }

        return true;
    }
    */

}
