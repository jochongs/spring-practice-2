package practice2.core.singleton;

public class StatefulService {

    private int price;

    public void order(String name, int price) {
        System.out.print("name = " + name);
        System.out.println(", price = " + price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
