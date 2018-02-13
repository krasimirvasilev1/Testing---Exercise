public class RecursiveAlgorithmToFindTheNFibonacciNumber {
    public static void main(String[] args) {
        System.out.println(fibN(55));
    }
    public static int fibN(int n){
        if (n < 0){
            throw new IllegalArgumentException("Fibonacci number should be in the positive range");
        }
        if (n == 1){
            return 1;
        }
        else if (n == 0){
            return 0;
        }
        return fibN(n - 1) + fibN(n - 2);
    }
}
