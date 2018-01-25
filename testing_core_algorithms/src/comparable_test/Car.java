package comparable_test;

public class Car {
    private int weight;
    private double price;
    private String model;

    public Car(int weight, double price, String model) {
        this.weight = weight;
        this.price = price;
        this.model = model;
    }

    public int getWeight() {
        return this.weight;
    }

    public double getPrice() {
        return this.price;
    }

    public String getModel() {
        return this.model;
    }

    @Override
    public String toString() {
        return this.weight + " " + this.price + " " + this.model;
    }
}
