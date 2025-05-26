package com.basic.util;

import java.util.Scanner;

public class InputUtils {

    public static int readIntInput(Scanner scanner, String prompt) {
        int number;
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                number = Integer.parseInt(input);
                break; // input is valid
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid number. Please enter a valid integer.");
            }
        }
        return number;
    }
}
