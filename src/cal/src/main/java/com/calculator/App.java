package com.calculator;

import java.util.Scanner;

public class App {

    // Variables A and B
    private static float A = 0;
    private static float B = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char command= ' ';

        // Display the calculator menu
        do {
            printMenu();

            System.out.print("Enter a command: ");
            String input = scanner.nextLine();

            // Validate input for the command
            if (input.length() == 1) {
                command = input.charAt(0);
            } else {
                System.out.println("Invalid command. Please try again.");
                continue;
            }

            switch (command) {
                case 'a':
                    A = getFloatInput(scanner, "Enter a value for A: ");
                    break;
                case 'b':
                    B = getFloatInput(scanner, "Enter a value for B: ");
                    break;
                case '+':
                    A = A + B;
                    break;
                case '-':
                    A = A - B;
                    break;
                case '*':
                    A = A * B;
                    break;
                case '/':
                    if (B == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                    } else {
                        A = A / B;
                    }
                    break;
                case 'c':
                    A = 0;
                    B = 0;
                    System.out.println("Values cleared.");
                    break;
                case 'q':
                    System.out.println("Quitting the calculator.");
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }

        } while (command != 'q');

        scanner.close();
    }

    // Method to print the calculator menu and display A and B values
    private static void printMenu() {
        System.out.printf("---------------------------------\n");
        System.out.printf("Calculator\n");
        System.out.printf("---------------------------------\n");
        System.out.printf("A = %.3f\t\tB = %.3f\n", A, B);
        System.out.println("a\tEnter a value for A");
        System.out.println("b\tEnter a value for B");
        System.out.println("+\tAdd");
        System.out.println("-\tSubtract");
        System.out.println("*\tMultiply");
        System.out.println("/\tDivide");
        System.out.println("c\tClear");
        System.out.println("q\tQuit");
        System.out.printf("---------------------------------\n");
    }

    // Method to get a valid float input from the user
    private static float getFloatInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return Float.parseFloat(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid float value.");
            }
        }
    }
}