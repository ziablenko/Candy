package candies;

public class ChocolateBar extends Candies {

    public String filling;

    public ChocolateBar(String name, String type, int price, int weight, String filling) {
        super(name, type, price, weight);
        this.filling = filling;
    }
}
