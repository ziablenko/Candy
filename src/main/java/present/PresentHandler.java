package present;

import candies.Candies;
import candies.ChocolateBar;
import candies.Lollipops;
import candies.Сookies;

import java.util.ArrayList;
import java.util.Comparator;

public class PresentHandler implements Box {

    public static void createBoxPresent() {

        PresentHandler gift = new PresentHandler();
        ArrayList<Candies> present = createPresent();
        gift.sort(present);
        gift.presentPrice(present);
        gift.presentWeight(present);
        gift.searchCandy(present);

    }

    public static ArrayList<Candies> createPresent() {
        ArrayList<Candies> present = new ArrayList<>();

        ChocolateBar test0 = new ChocolateBar("Марс        ", "Шоколадный батончик",
                25, 33);
        ChocolateBar test1 = new ChocolateBar("Сникерс     ", "Шоколадный батончик",
                39, 40);
        Lollipops test2 = new Lollipops("Хуба-буба   ", "Леденцы            ",
                24, 30);
        Lollipops test3 = new Lollipops("Чупа-Чупс   ", "Леденцы            ",
                31, 31);
        Сookies test4 = new Сookies("Орео        ", "печенье            ",
                14, 33);
        Сookies test5 = new Сookies("Звезда      ", "печенье            ",
                12, 29);

        present.add(test0);
        present.add(test1);
        present.add(test2);
        present.add(test3);
        present.add(test4);
        present.add(test5);

        System.out.println("Подарочный набор : ");
        System.out.println("| Наименование | Тип                 |Цена|Вес |");
        System.out.println("|--------------|---------------------|----|----|");

        for (Candies candy : present) {
            candy.showAllInfo(candy.name);
        }
        return present;
    }

    @Override
    public void sort(ArrayList<Candies> present) {

        present.sort(Comparator.comparing(Candies::getName)
                .thenComparing(Candies::getWeight));
        System.out.println("Подарочный набор отсортирован: ");
        System.out.println("| Наименование | Тип                 |Цена|Вес |");
        System.out.println("|--------------|---------------------|----|----|");

        for (Candies candy : present) {
            candy.showAllInfo(candy.name);
        }
    }

    @Override
    public void presentPrice(ArrayList<Candies> present) {
        int sum = 0;
        for (Candies candy : present) {
            sum += candy.getPrice();
        }
        System.out.println("Цена подарка: " + sum);
    }

    @Override
    public void presentWeight(ArrayList<Candies> present) {
        int sum = 0;
        for (Candies candy : present) {
            sum += candy.getWeight();
        }
        System.out.println("Вес подарка: " + sum);
    }

    @Override
    public void searchCandy(ArrayList<Candies> present) {
        System.out.println("Конфеты с весом от 30 до 31 грамма:");
        for (Candies candy : present) {
            if (candy.getWeight() >= 30 && candy.getWeight() <= 31) {
                System.out.println("- " + candy.name);
            }
        }
    }
}
