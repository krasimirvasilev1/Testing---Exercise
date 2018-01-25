package binary_search_sorted_list;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println(isTheNumberInTheList(Arrays.asList(1,2,3,5,55),55));
    }

    public static boolean isTheNumberInTheList(final List<Integer> numbers, final Integer number){
        if (numbers == null || numbers.isEmpty()){
            return false;
        }

        int middleNumber = numbers.get(numbers.size() / 2);
        if (middleNumber == number){
            return true;
        }

        if (middleNumber < number){
            return isTheNumberInTheList(numbers.subList(numbers.size() / 2 + 1, numbers.size()),number);
        }

        else {
            return isTheNumberInTheList(numbers.subList(0 , numbers.size() / 2), number);
        }
    }
}
