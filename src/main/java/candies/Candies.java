package candies;

public abstract class Candies {
    public String name;
    public String type;
    public int price;
    public int weight;

    public Candies(String name, String type, int price, int weight) {
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.price = price;
    }

    public void showAllInfo(String name) {
        System.out.println("| " + name + " | " + type + " | " + price + " | " + weight + " | ");
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }
}
