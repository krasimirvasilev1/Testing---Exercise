package merge_sort_algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> sortedNumbers = mergesort(Arrays.asList(1,33,-22,-110,1,10,0,43 ,123,122,1000));

        StringBuilder builder = new StringBuilder();

        for (Integer sortedNumber : sortedNumbers) {
            builder.append(sortedNumber + " ");
        }

        System.out.println(builder.toString().trim());
    }

    public static List<Integer> mergesort(final List<Integer> values) {
        if (values.size() < 2) {
            return values;
        }
        final List<Integer> leftHalf = values.subList(0, values.size() / 2);
        final List<Integer> rightHalf = values.subList(values.size() / 2, values.size());
        return merge(mergesort(leftHalf), mergesort(rightHalf));
    }

    private static List<Integer> merge(final List<Integer> left, final List<Integer> right) {
        int leftPtr = 0;
        int rightPtr = 0;
        final List<Integer> merged = new ArrayList<>(left.size() + right.size());


        while (leftPtr < left.size() && rightPtr < right.size())

        {
            if (left.get(leftPtr) < right.get(rightPtr)) {
                merged.add(left.get(leftPtr));
                leftPtr++;
            } else {
                merged.add(right.get(rightPtr));
                rightPtr++;
            }
        }
        while (leftPtr < left.size())

        {
            merged.add(left.get(leftPtr));
            leftPtr++;
        }
        while (rightPtr < right.size())

        {
            merged.add(right.get(rightPtr));
            rightPtr++;
        }
        return merged;
    }
}

