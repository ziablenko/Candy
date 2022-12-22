package org.example;

public class ChocolateBars extends Candy {

    String filling= "Орехи";

    public ChocolateBars(String n,String t,int p, int w, String f){ //создаем конструктор со всеми параметрами (наименование и вес(шт))
        super.name=n;
        super.weight=w;
        super.type=t;
        super.price=p;
        filling=f;

    };
}
