package comparable_test;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> allCars;

    public Race() {
        this.allCars = new ArrayList<>();
    }

    public void addACar(Car car){
        this.allCars.add(car);
    }

    public List<Car> getAllCars() {
        return this.allCars;
    }
}
