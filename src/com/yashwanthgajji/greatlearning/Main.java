package com.yashwanthgajji.greatlearning;

import com.yashwanthgajji.greatlearning.entities.Employee;
import com.yashwanthgajji.greatlearning.itdepartment.CredentialService;

import java.util.Scanner;

public class Main {

    private static String getDepartmentNumber() {

        Scanner scanner = new Scanner(System.in);

        String stringBuilder = """
                Please enter the department from the following
                1. Technical
                2. Admin
                3. Human Resource
                4. Legal""";
        System.out.println(stringBuilder);

        boolean isCorrect = false;
        int departmentNumber = 0;
        String departmentName = "";

        while (!isCorrect) {
            departmentNumber = scanner.nextInt();
            if (departmentNumber<=0 || departmentNumber>4) {
                System.out.println("Enter correct department number");
            } else {
                isCorrect = true;
            }
        }

        switch (departmentNumber) {
            case 1 -> departmentName = "Technical";
            case 2 -> departmentName = "Admin";
            case 3 -> departmentName = "Human Resource";
            case 4 -> departmentName = "Legal";
        }
        return departmentName;
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Yashwanth", "Gajji");
        employee.setDepartment(getDepartmentNumber());
        employee.setEmail(CredentialService.generateEmailAddress(employee.getFirstName(), employee.getLastName(), employee.getDepartment()));
        employee.setPassword(CredentialService.generatePassword());
        CredentialService.showCredentials(employee);
    }
}
