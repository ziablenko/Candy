package candies;

public class Cookies extends Candies {

    String dough;

    public Cookies(String name, String type, int price, int weight,String dough) {
        super(name, type, price, weight);
        this.dough=dough;

    }
}
