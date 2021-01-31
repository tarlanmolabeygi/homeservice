package com.example.homeservice.validation;

public class PasswordValidation {

    public static void checkPasswordPattern(String password) {
        String regex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        if (!password.matches(regex)) {
            throw new RuntimeException("There is a mismatch. You must enter a valid password.");
        }
    }
}
