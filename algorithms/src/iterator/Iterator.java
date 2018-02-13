package iterator;

import java.util.Arrays;
import java.util.List;

public class Iterator<T> implements java.util.Iterator {
    List<T> stringList;
    int currIndex = 0;

    public Iterator(List<T> stringList) {
        this.stringList = stringList;
    }

    @Override
    public boolean hasNext() {
        if (currIndex >= stringList.size()){
            return false;
        }


        return true;
    }

    @Override
    public Object next() {
        currIndex++;

        return stringList.get(currIndex - 1);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4);
        Iterator<Integer> iterator = new Iterator<>(list);

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
