package candies;

public class Cookie extends Candies {

    String dough;

    public Cookie(String name, String type, int price, int weight, String dough) {
        super(name, type, price, weight);
        this.dough = dough;

    }
}
