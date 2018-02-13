import java.util.HashMap;
import java.util.Map;

public class RecursiveAlgorithmFasterApproach {
    private static Map<Integer, Integer> fibCache = new HashMap<>();

    public static int cachedFibN(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must not be less than zero");
        }
        fibCache.put(0, 0);
        fibCache.put(1, 1);
        return recursiveCachedFibN(n);
    }

    private static int recursiveCachedFibN(int n) {
        if (fibCache.containsKey(n)) {
            return fibCache.get(n);
        }
        int value = recursiveCachedFibN(n - 1) + recursiveCachedFibN(n - 2);
        fibCache.put(n, value);
        return value;
    }
    public static void main(String[] args) {
        System.out.println(cachedFibN(55));
    }
}
