package org.example;

public class Candy {
    public String name;
    public String type;
    public int price;
    public int weight;

    /*создаем конструктор по умолчанию*/

    public Candy(){
        name="Default";
        type= "Default type";
        price= 0;
        weight=0;
    }

    /*создаем конструктор со всеми полями для объекта Candy*/

    public Candy(String n,String t,int p, int w){ //создаем конструктор со всеми параметрами (наименование и вес(шт))
        name=n;
        weight=w;
        type=t;
        price=p;
    };

    /*создание метода вывода объекта в табличку*/

    public void show_all_info1(String n) { // создаем метод который выводит всю информацию таблично
        name=n;
        System.out.println("| "+name+" | "+type+" | "+price+" | "+weight+" | ");
    }

    /*создание методов получения значений*/

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
