package comparable_test;

import java.util.Comparator;

public class ComparableRace implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Car firstCar = (Car) o1;
        Car secondCar = (Car) o2;

        int firstCompare = Double.compare(secondCar.getPrice(), firstCar.getPrice());
        if (firstCompare != 0) {
            return firstCompare;
        }

        return firstCar.getModel().compareTo(secondCar.getModel());
    }
}
