package org.example;

public class Candy {
    public String name= "Default Name";
    public String type= "Test";
    public int price= 10;
    public int weight =10;
    public Candy(){
        name="Default";
        type= "Default type";
        price= 0;
        weight=0;
    };//создаем конструктор по умолчанию

    public Candy(String n){ //создаем конструктор содержащий только 1 параметр (наименование)
        name=n;
    };

    public Candy(String n, int w){ //создаем конструктор c 2 параметрами (наименование и вес(шт))
        name=n;
        weight=w;
    };

    public Candy(String n,String t,int p, int w){ //создаем конструктор со всеми параметрами (наименование и вес(шт))
        name=n;
        weight=w;
        type=t;
        price=p;
    };

    public void cost(int price,int count) { // создаем метод который подсчитывает стоимость
        int c=price*count;
        System.out.println("Стоимость: "+c);
    }

    public void show_all_info(String n) { // создаем метод который выводит всю информацию
        name=n;
        System.out.println("Наименование: "+name);
        System.out.println("Тип: "+type);
        System.out.println("Цена: "+price);
        System.out.println("Вес(шт): "+weight+ " грамм");
        System.out.println(" ");
    }

    public void show_all_info1(String n) { // создаем метод который выводит всю информацию таблично
        name=n;
        System.out.println("| "+name+" | "+type+" | "+price+" | "+weight+" | ");
    }

    public void present1() { // создаем метод который выводит всю информацию
        System.out.println("Наименование: "+name);
        System.out.println("Тип: "+type);
        System.out.println("Цена: "+price);
        System.out.println("Вес(шт): "+weight+ " грамм");
        System.out.println(" ");
    }


    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }
}
