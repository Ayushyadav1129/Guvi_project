import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    // To store calculation history
    private static ArrayList<String> history = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalc = true;

        System.out.println("==== Welcome to Console Calculator ====");

        while (continueCalc) {
            try {
                System.out.print("\nEnter first number: ");
                double num1 = getValidNumber(scanner);

                System.out.print("Enter operator (+, -, *, /): ");
                char operator = getValidOperator(scanner);

                System.out.print("Enter second number: ");
                double num2 = getValidNumber(scanner);

                double result = calculate(num1, num2, operator);
                String operation = num1 + " " + operator + " " + num2 + " = " + result;
                System.out.println("Result: " + result);

                history.add(operation);

            } catch (ArithmeticException ae) {
                System.out.println("Error: " + ae.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error occurred.");
            }

            System.out.print("\nDo you want to perform another calculation? (yes/no/history): ");
            String choice = scanner.next().toLowerCase();

            if (choice.equals("no")) {
                continueCalc = false;
                System.out.println("Exiting calculator. Thank you!");
            } else if (choice.equals("history")) {
                printHistory();
            }
        }

        scanner.close();
    }

    // Validate and get a number
    private static double getValidNumber(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input! Please enter a number: ");
                scanner.next(); // clear invalid input
            }
        }
    }

    // Validate and get an operator
    private static char getValidOperator(Scanner scanner) {
        while (true) {
            String input = scanner.next();
            if (input.length() == 1 && "+-*/".contains(input)) {
                return input.charAt(0);
            }
            System.out.print("Invalid operator! Enter one of (+, -, *, /): ");
        }
    }

    // Perform calculation
    private static double calculate(double a, double b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("Cannot divide by zero.");
                return a / b;
            default: throw new IllegalArgumentException("Invalid operator.");
        }
    }

    // Print history of calculations
    private static void printHistory() {
        System.out.println("\n=== Calculation History ===");
        if (history.isEmpty()) {
            System.out.println("No calculations performed yet.");
        } else {
            for (String record : history) {
                System.out.println(record);
            }
        }
    }
}