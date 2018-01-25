package insert_sort_algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,8,123,-5,4,0,3);
        numbers = insertSort(numbers);

        StringBuilder builder = new StringBuilder();
        for (Integer number : numbers) {
            builder.append(number + " ");
        }

        System.out.println(builder.toString().trim());
    }

    public static List<Integer> insertSort(List<Integer> numbers){
        List<Integer> sortedList = new LinkedList<>();

        for (Integer number : numbers) {
            boolean numberFound = false;
            for (int i = 0; i < sortedList.size(); i++) {
                if (number < sortedList.get(i)){
                    sortedList.add(i, number);
                    numberFound = true;
                    break;
                }
            }

            if (!numberFound){
                sortedList.add(sortedList.size() , number);
            }
        }
        return sortedList;
    }


}
