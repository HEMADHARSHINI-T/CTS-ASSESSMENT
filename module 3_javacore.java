import java.util.*;
import java.io.*;
import java.util.concurrent.*;
import java.lang.reflect.*;

public class JavaExercises {

    1. Hello World Program
    public static void helloWorld() {
        System.out.println("Hello, World!");
    }

     2. Simple Calculator
    public static void simpleCalculator() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();
        System.out.println("Choose operation (+, -, *, /): ");
        char operator = sc.next().charAt(0);
        double result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error! Division by zero.");
                    return;
                }
                break;
            default:
                System.out.println("Invalid operator!");
                return;
        }
        System.out.println("Result: " + result);
    }

    3. Even or Odd Checker
    public static void evenOrOdd() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();

        if (num % 2 == 0) {
            System.out.println(num + " is even.");
        } else {
            System.out.println(num + " is odd.");
        }
    }

    4. Leap Year Checker
    public static void leapYearChecker() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = sc.nextInt();

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }
    }

     5. Multiplication Table
    public static void multiplicationTable() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " * " + i + " = " + (num * i));
        }
    }

    6. Data Type Demonstration
    public static void dataTypeDemo() {
        int anInt = 10;
        float aFloat = 10.5f;
        double aDouble = 20.99;
        char aChar = 'A';
        boolean aBoolean = true;

        System.out.println("int: " + anInt);
        System.out.println("float: " + aFloat);
        System.out.println("double: " + aDouble);
        System.out.println("char: " + aChar);
        System.out.println("boolean: " + aBoolean);
    }

    7. Type Casting Example
    public static void typeCastingExample() {
        double myDouble = 9.78;
        int myInt = (int) myDouble; // casting double to int
        System.out.println("Double value: " + myDouble);
        System.out.println("Int value after casting: " + myInt);

        int myInt2 = 10;
        double myDouble2 = myInt2; // Implicit casting (int to double)
        System.out.println("Int value: " + myInt2);
        System.out.println("Double value after casting: " + myDouble2);
    }

    8. Operator Precedence
    public static void operatorPrecedence() {
        int result = 10 + 5 * 2; // Multiplication happens first
        System.out.println("Result of 10 + 5 * 2: " + result);
    }

    9. Grade Calculator
    public static void gradeCalculator() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks (0-100): ");
        int marks = sc.nextInt();
        String grade = "";

        if (marks >= 90) {
            grade = "A";
        } else if (marks >= 80) {
            grade = "B";
        } else if (marks >= 70) {
            grade = "C";
        } else if (marks >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
        System.out.println("Grade: " + grade);
    }

    10. Number Guessing Game
    public static void numberGuessingGame() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int numberToGuess = rand.nextInt(100) + 1;
        int userGuess = 0;

        System.out.println("Guess the number between 1 and 100!");

        while (userGuess != numberToGuess) {
            System.out.print("Enter your guess: ");
            userGuess = sc.nextInt();
            if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            }
        }
        System.out.println("Congratulations! You guessed the number.");
    }

    11. Factorial Calculator
    public static void factorialCalculator() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to calculate factorial: ");
        int num = sc.nextInt();
        long factorial = 1;

        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        System.out.println("Factorial of " + num + " is " + factorial);
    }

    12. Method Overloading
    public static int add(int a, int b) {
        return a + b;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void methodOverloading() {
        System.out.println("Sum of 2 integers: " + add(10, 20));
        System.out.println("Sum of 2 doubles: " + add(10.5, 20.3));
        System.out.println("Sum of 3 integers: " + add(10, 20, 30));
    }

    13. Recursive Fibonacci
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void recursiveFibonacci() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();
        System.out.println("Fibonacci number at position " + n + " is: " + fibonacci(n));
    }

     14. Array Sum and Average
    public static void arraySumAndAverage() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] numbers = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
            sum += numbers[i];
        }

        double average = (double) sum / n;
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }

    15. String Reversal
    public static void stringReversal() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        String reversed = new StringBuilder(str).reverse().toString();
        System.out.println("Reversed string: " + reversed);
    }

    16. Palindrome Checker
    public static void palindromeChecker() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(str).reverse().toString();

        if (str.equals(reversed)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }

    17. Class and Object Creation
    static class Car {
        String make;
        String model;
        int year;

        public Car(String make, String model, int year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }

        public void displayDetails() {
            System.out.println("Car Make: " + make);
            System.out.println("Car Model: " + model);
            System.out.println("Car Year: " + year);
        }
    }

    public static void classAndObjectCreation() {
        Car car = new Car("Toyota", "Camry", 2021);
        car.displayDetails();
    }

     18. Inheritance Example
    static class Animal {
        public void makeSound() {
            System.out.println("Animal makes sound");
        }
    }

    static class Dog extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Bark");
        }
    }

    public static void inheritanceExample() {
        Animal animal = new Animal();
        Dog dog = new Dog();
        animal.makeSound();
        dog.makeSound();
    }

    19. Interface Implementation
    interface Playable {
        void play();
    }

    static class Guitar implements Playable {
        @Override
        public void play() {
            System.out.println("Guitar is playing");
        }
    }

    static class Piano implements Playable {
        @Override
        public void play() {
            System.out.println("Piano is playing");
        }
    }

    public static void interfaceImplementation() {
        Playable guitar = new Guitar();
        Playable piano = new Piano();
        guitar.play();
        piano.play();
    }

    20. Try-Catch Example
    public static void tryCatchExample() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter numerator: ");
        int num1 = sc.nextInt();
        System.out.print("Enter denominator: ");
        int num2 = sc.nextInt();

        try {
            int result = num1 / num2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error! Division by zero.");
        }
    }

    21. Custom Exception
    static class InvalidAgeException extends Exception {
        public InvalidAgeException(String message) {
            super(message);
        }
    }

    public static void customException() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age: ");
        int age = sc.nextInt();

        try {
            if (age < 18) {
                throw new InvalidAgeException("Age must be 18 or older.");
            } else {
                System.out.println("Valid age.");
            }
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }

     22. File Writing
    public static void fileWriting() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to write to file: ");
        String text = sc.nextLine();

        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write(text);
            System.out.println("Data written to file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }
    }

    23. File Reading
    public static void fileReading() {
        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
    }

    24. ArrayList Example
    public static void arrayListExample() {
        List<String> names = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of names: ");
        int n = sc.nextInt();
        sc.nextLine();  // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name: ");
            names.add(sc.nextLine());
        }

        System.out.println("Names entered: " + names);
    }

    25. HashMap Example
    public static void hashMapExample() {
        Map<Integer, String> studentMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();  // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consume newline
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            studentMap.put(id, name);
        }

        System.out.println("Enter student ID to get name: ");
        int searchId = sc.nextInt();
        System.out.println("Student Name: " + studentMap.getOrDefault(searchId, "ID not found"));
    }

     26. Thread Creation
    public static void threadCreation() {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 1: " + i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 2: " + i);
            }
        });

        thread1.start();
        thread2.start();
    }

    27. Lambda Expressions
    public static void lambdaExpressions() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Dave");
        Collections.sort(names, (a, b) -> a.compareTo(b));
        System.out.println("Sorted names: " + names);
    }

    28. Stream API
    public static void streamAPI() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
        System.out.println("Sum of even numbers: " + sum);
    }

    // Main method
    public static void main(String[] args) {
        helloWorld();
        simpleCalculator();
        evenOrOdd();
        leapYearChecker();
        multiplicationTable();
        dataTypeDemo();
        typeCastingExample();
        operatorPrecedence();
        gradeCalculator();
        numberGuessingGame();
        factorialCalculator();
        methodOverloading();
        recursiveFibonacci();
        arraySumAndAverage();
        stringReversal();
        palindromeChecker();
        classAndObjectCreation();
        inheritanceExample();
        interfaceImplementation();  // Call the interface method here
        tryCatchExample();
        customException();
        fileWriting();
        fileReading();
        arrayListExample();
        hashMapExample();
        threadCreation();
        lambdaExpressions();
        streamAPI();
    }
}