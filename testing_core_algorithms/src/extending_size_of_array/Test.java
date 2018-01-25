package extending_size_of_array;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int [] numbers = {1,2,3,4,5};
        int [] newArrayWithAdditionSpace = extendingArraySize(numbers);

        System.out.println(Arrays.toString(newArrayWithAdditionSpace).substring(1,Arrays.toString(newArrayWithAdditionSpace).length() - 1));
    }

    public static int [] extendingArraySize(int [] currArray){
        int [] array = new int [currArray.length + 1];
        System.arraycopy(currArray,0,array,0,currArray.length);
        array[5] = 6;

        return array;
    }
}
