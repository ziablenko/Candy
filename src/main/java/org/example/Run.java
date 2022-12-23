package org.example;

import java.util.ArrayList;
import java.util.Comparator;

public class Run {
    public static void main(String[] args) {
        {
            ArrayList<Candy> present = new ArrayList<>();

            ChocolateBars test0 = new ChocolateBars("Марс        ", "Шоколадный батончик", 25, 33, "Орехи");
            ChocolateBars test1 = new ChocolateBars("Сникерс     ", "Шоколадный батончик", 39, 40, "Нуга");
            LolliPops test2 = new LolliPops("Хуба-буба   ", "Леденцы            ", 24, 30, "Малиновый");
            LolliPops test3 = new LolliPops("Чупа-Чупс   ", "Леденцы            ", 31, 31, "Кока-кола");
            Сookies test4 = new Сookies("Орео        ", "печенье            ", 14, 33, "Шоколадное");
            Сookies test5 = new Сookies("Звезда      ", "печенье            ", 12, 29, "Имбирное");

            present.add(test0);
            present.add(test1);
            present.add(test2);
            present.add(test3);
            present.add(test4);
            present.add(test5);

            present.sort(Comparator.comparing(Candy::getName)
                    .thenComparing(Candy::getWeight));
            System.out.println("Подарочный набор отсортирован: ");
            System.out.println("| Наименование | Тип                 |Цена|Вес |");
            System.out.println("|--------------|---------------------|----|----|");

            for (Candy candy : present) {
                candy.show_all_info1(candy.name);
            }

            int sum = 0;
            for (Candy candy : present) {
                sum += candy.getPrice();
            }
            System.out.println("Цена подарка: " + sum);

            int weight = 0;
            for (Candy candy : present) {
                weight += candy.getWeight();
            }
            System.out.println("Вес подарка: " + weight);

            System.out.println("Конфеты с весом от 30 до 31 грамма:");
            for (Candy candy : present) {
                if (candy.getWeight() >= 30 && candy.getWeight() <= 31) {
                    System.out.println("- " + candy.name);
                }
            }
        }
    }
}