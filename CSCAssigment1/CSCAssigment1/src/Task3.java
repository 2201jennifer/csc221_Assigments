public class Task3 {
    public static void printTask3() {
        System.out.println("Numbers between 1 and 20: ");
        for (int i = 1; i < 20; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");

            }
        }
        System.out.println();
        //Odd Numbers
        System.out.println("Sum of Odd Numbers between 1 and 50: ");
        int sum = 0;
        int j;
        for (j = 1; j < 50; j++) {
            if (j % 2 != 0) {
                sum += j;

            }

        }

        System.out.println(sum + " ");

    }
}
