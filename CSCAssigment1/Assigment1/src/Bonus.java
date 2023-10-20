
// crated a class that broke down the operation add,subtract,multiply,divide
// specifies what will be returned for each corresponding operation
public class Bonus {
    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static double sub(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public static double divide(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            System.out.print("Error");
            return Double.NaN;
        }

    }
}
