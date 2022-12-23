package org.example;

public class ChocolateBars extends Candy {

    String filling= "Орехи";

    public ChocolateBars(String name,String type,int price, int weight, String filling){

        super.name=name;
        super.weight=weight;
        super.type=type;
        super.price=price;
        this.filling=filling;

    };
}
