import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //------------------------Task 1------------------------------------
        System.out.println("Task 1:");
        Task1.printTask1();
        System.out.println("-----------------------------------------");

        //------------------------Task 2-----------------------------------
        System.out.println("Task 2:");
        Task2.printTask2();
        System.out.println("-----------------------------------------");

        //------------------------Task 3-----------------------------------
        System.out.println("Task 3:");
        Task3.printTask3();
        System.out.println("-----------------------------------------");

        //------------------------Task 4-----------------------------------
        System.out.println("Task 4:");
        //call function
        double result= Task4.calculateArea(5.33,7.33);
        //calculation of area one
        System.out.println("Area Calculation 1: "+ result);
        //calculation of area one
        double result2= Task4.calculateArea(2.00,3.00);
        System.out.println("Area Calculation 2: "+ result2);
        System.out.println("-----------------------------------------");

        //------------------------Task 5-----------------------------------
        System.out.println("Task 5:");
        int number1 =3;//the input n
        int number2=2;
        long factorial1 = Task5.calculateFactorial(number1);
        System.out.println("Factorial of " + number1+ ": "+ factorial1);
        long factorial2 = Task5.calculateFactorial(number2);
        System.out.println("Factorial of " + number2+ ": "+ factorial2);
        System.out.println("-----------------------------------------");

        //------------------------Bonus-----------------------------------
        System.out.println("Bonus:");
        Scanner scanner = new Scanner(System.in);

        // Ask user to enter the first number
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        // Ask user to enter the second number
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        // Ask user to enter the operator
        System.out.print("Enter an operator (-, +, *, /): ");
        char operator = scanner.next().charAt(0);

        double Result = 0; // Variable to store the result of the operation

        // Will subtract, add, multiple, or divide depending on operator entered by the user
        switch (operator) {
            case '+':
                Result =Bonus.add(num1, num2);
                break;
            case '-':
                Result = Bonus.sub(num1,num2);
                break;
            case '*':
                Result = Bonus.multiply(num1,num2);
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("Cannot divide by zero");
                    return; // Will exit if user tries to divide by zero
                }
                Result = Bonus.divide(num1,num2);
                break;
            default:
                // Handling an invalid operator input
                System.out.println("Operator is invalid! Please enter one of the following valid operators (-, +, *, /) ");
                return; // Exiting the program
        }

        // Show result
        System.out.println(num1 + " " + " " + operator + " " +num2 +" =");
        System.out.println("Result: " + Result);

        // Close scanner
        scanner.close();
    }





}