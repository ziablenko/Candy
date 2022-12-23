package org.example;

public class Сookies extends Candy {

    String dough= "Имбирное";

    public Сookies(String n,String t,int p, int w, String d){ //создаем конструктор со всеми параметрами (наименование и вес(шт))
        super.name=n;
        super.weight=w;
        super.type=t;
        super.price=p;
        dough=d;

    };
}
