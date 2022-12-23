package org.example;

public class Сookies extends Candy {

    String dough= "Имбирное";

    public Сookies(String name,String type,int price, int weight, String dough){
        super.name=name;
        super.weight=weight;
        super.type=type;
        super.price=price;
        this.dough=dough;
    };
}
