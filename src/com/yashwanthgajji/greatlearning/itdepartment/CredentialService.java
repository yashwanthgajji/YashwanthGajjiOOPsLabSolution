package com.yashwanthgajji.greatlearning.itdepartment;

import com.yashwanthgajji.greatlearning.entities.Employee;

import java.util.Random;

public class CredentialService {

    public static String generateEmailAddress(String firstName, String lastName, String department) {
        String email = firstName + lastName + "@" + department + ".company.com";
        return email;
    }

    public static String generatePassword() {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "@!#$%&*";
        String numbers = "0123456789";
        String allCharacters = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        password.append(capitalCaseLetters.charAt(random.nextInt(26)));
        password.append(lowerCaseLetters.charAt(random.nextInt(26)));
        password.append(specialCharacters.charAt(random.nextInt(7)));
        password.append(numbers.charAt(random.nextInt(10)));
        for (int i = 0; i < 4; i++) {
            password.append(allCharacters.charAt(random.nextInt(69)));
        }
        return password.toString();
    }

    public static void showCredentials(Employee employee) {
        StringBuilder displayString = new StringBuilder();
        displayString.append("Dear ").append(employee.getFirstName()).append("t your generated credentials are as follows").append("\n");
        displayString.append("Email    ---> ").append(employee.getEmail()).append("\n");
        displayString.append("Password ---> ").append(employee.getPassword());
        System.out.println(displayString);
    }
}
