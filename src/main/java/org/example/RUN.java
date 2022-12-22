package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class RUN {
    public static void main(String[] args) {
        {
            ArrayList<Candy> present = new ArrayList<>();

            Candy test0 = new ChocolateBars("Марс","Шоколадный батончик",25, 33, "Орехи");
            Candy test1 = new ChocolateBars("Сникерс","Шоколадный батончик",39, 40, "Нуга");
            Candy test2 = new Lollipops("Хуба-буба","Леденцы",24, 30, "Малиновый");
            Candy test3 = new Lollipops("Чупа-Чупс","Леденцы",31, 31, "Кока-кола");
            Candy test4 = new Candy("Орео","печенье",14, 32);
            Candy test5 = new Candy("Нут","печенье",12, 29);

            present.add(test0);
            present.add(test1);
            present.add(test2);
            present.add(test3);
            present.add(test4);
            present.add(test5);


            present.sort(Comparator.comparing(Candy::getName)
                    .thenComparing(Candy::getWeight));

            System.out.println("Наименование: "+"Тип: "+"Цена: "+"Вес(шт): ");
            for (Candy candy : present) {
                candy.show_all_info1(candy.name);
            }
        }
    }
}