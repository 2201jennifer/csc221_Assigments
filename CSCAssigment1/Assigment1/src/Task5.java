public class Task5 {
    //factorial computation using a loop
    public static long calculateFactorial(int n){
        if (n==0){
            return 1;
        }
        else{
            return n * calculateFactorial(n-1);
        }
    }
}
