package org.example;

public class LolliPops extends Candy {

        String taste= "Клубничный";

    public LolliPops(String name,String type,int price, int weight, String taste){ //создаем конструктор со всеми параметрами (наименование и вес(шт))
            super.name=name;
            super.weight=weight;
            super.type=type;
            super.price=price;
            this.taste=taste;

        };
}
