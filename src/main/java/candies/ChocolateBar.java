package candies;

public class ChocolateBar extends Candies {

    String filling;


    public ChocolateBar(String name, String type, int price, int weight, String filling) {
        super(name, type, price, weight);
        this.filling=filling;
    }

    public ChocolateBar createChocolateBar(){
        ChocolateBar mars = new ChocolateBar("Марс        ", "Шоколадный батончик",
                25, 33, "Орехи");
        return mars;
    }
}
