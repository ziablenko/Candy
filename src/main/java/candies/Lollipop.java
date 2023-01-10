package candies;

public class Lollipop extends Candies {

    public String taste;

    public Lollipop(String name, String type, int price, int weight, String taste) {

        super(name, type, price, weight);
        this.taste = taste;
    }
}
