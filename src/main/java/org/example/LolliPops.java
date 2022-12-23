package org.example;

public class LolliPops extends Candy {

        String taste= "Клубничный";

    public LolliPops(String n,String t,int p, int w, String ta){ //создаем конструктор со всеми параметрами (наименование и вес(шт))
            super.name=n;
            super.weight=w;
            super.type=t;
            super.price=p;
            taste=ta;

        };
}
