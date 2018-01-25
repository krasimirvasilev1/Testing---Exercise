package comparable_test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Race race = new Race();

        Car car = new Car(20,430.20, "Beti");
        Car car1 = new Car(30,430.20, "Alpha");
        Car car2 = new Car(200,200,"Z");
        Car car3 = new Car(1350,1350.20,"Niki");
        Car car4 = new Car(0,1350.20, "Estel");

        race.addACar(car);
        race.addACar(car1);
        race.addACar(car2);
        race.addACar(car3);
        race.addACar(car4);

        race.getAllCars().sort(new ComparableRace());

        for (Car car5 : race.getAllCars()) {
            System.out.println(car5);
        }
    }
}
