import java.util.Scanner;
public class Task2 {
    public static void printTask2() {
        //allowing user to input their age
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter age: ");
        int userAge= scanner.nextInt();
//the if statement to meet the condition needed
        if(userAge >= 18){
            System.out.println("Your are an adult.");
        }
        else {
            System.out.println("Your are a minor.");
        }

    }
}
