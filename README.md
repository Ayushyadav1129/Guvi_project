# Console-Based Calculator

## Project Overview
This is a simple console-based calculator built using Java. It allows users to perform basic arithmetic operations including addition, subtraction, multiplication, and division. The application also maintains a history of operations during a session.

## Features
- Addition, Subtraction, Multiplication, and Division operations
- Console-based user interface
- Maintains a history of all performed calculations
- Supports continuous calculations until the user decides to exit

## Error Handling
- Handles non-numeric input using `InputMismatchException`
- Manages divide-by-zero errors using `ArithmeticException`
- Prompts users for correct input in case of invalid entries

## Technical Details
- Developed in Java
- Uses `Scanner` for user input
- Uses `ArrayList` to store calculation history
- Implements exception handling for robustness

## Usage
1. Run the application.
2. Enter the first number.
3. Choose an operation (+, -, *, /).
4. Enter the second number.
5. View the result.
6. Choose to perform another calculation, view history, or exit.

## Conclusion
This project demonstrates fundamental Java programming concepts such as control flow, loops, exception handling, and basic data structures. It provides a clean and user-friendly experience for performing arithmetic operations via the console.
