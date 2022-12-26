package present;

import candies.Candies;
import candies.ChocolateBar;
import candies.Lollipops;
import candies.Cookies;

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

        ChocolateBar candy0 = new ChocolateBar("Марс        ", "Шоколадный батончик",
                25, 33);
        ChocolateBar candy1 = new ChocolateBar("Сникерс     ", "Шоколадный батончик",
                39, 40);
        Lollipops candy2 = new Lollipops("Хуба-буба   ", "Леденцы            ",
                24, 30);
        Lollipops candy3 = new Lollipops("Чупа-Чупс   ", "Леденцы            ",
                31, 31);
        Cookies candy4 = new Cookies("Орео        ", "печенье            ",
                14, 33);
        Cookies candy5 = new Cookies("Звезда      ", "печенье            ",
                12, 29);

        present.add(candy0);
        present.add(candy1);
        present.add(candy2);
        present.add(candy3);
        present.add(candy4);
        present.add(candy5);

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
