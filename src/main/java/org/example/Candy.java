package org.example;

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

    public Candy(String n,String t,int p, int w){ //создаем конструктор со всеми параметрами (наименование и вес(шт))
        name=n;
        weight=w;
        type=t;
        price=p;
    };

    public void show_all_info1(String n) { // создаем метод который выводит всю информацию таблично
        name=n;
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
