package bubble_sort_algorithm;

import java.util.Arrays;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>(Arrays.asList(2,3,4,5,6,7,8,1,123,22,1444,12312,0,-15));

        for (int i = 0; i < numbers.size(); i++) {
            int currMax = Integer.MIN_VALUE;
            int currMaxIndex = 0;
            for (int j = i; j < numbers.size(); j++) {
                if (numbers.get(j) > currMax){
                    currMax = numbers.get(j);
                    currMaxIndex = j;
                }
            }

            if (currMaxIndex != 0){
                int numberOfTheIIndex = numbers.get(i);
                numbers.set(currMaxIndex , numberOfTheIIndex);
                numbers.set(i, currMax);
            }
        }

        for (Integer number : numbers) {
            System.out.println(number + " ");
        }
    }
}
