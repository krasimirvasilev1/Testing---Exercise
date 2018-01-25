package order_preserving_iteration_map;

import java.util.Map;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        Map<Integer,String> maps = new TreeMap<>();
        maps.put(4,"niki");
        maps.put(1,"krasi");
        maps.put(111,"denkata");
        maps.put(3 , "valka");

        for (Integer integer : maps.keySet()) {
            System.out.println(integer);
        }
    }
}
