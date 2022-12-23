package Candies;

public class Candy {
    public String name;
    public String type;
    public int price;
    public int weight;

    public Candy(){
        name="Default";
        type= "Default type";
        price= 0;
        weight=0;
    }

    public Candy(String name,String type,int price, int weight){
        this.name=name;
        this.weight=weight;
        this.type=type;
        this.price=price;
    };

    public void show_all_info1(String name) {
        this.name=name;
        System.out.println("| "+name+" | "+type+" | "+price+" | "+weight+" | ");
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
}
