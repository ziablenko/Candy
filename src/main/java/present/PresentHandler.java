package present;

import candies.Candies;
import candies.ChocolateBar;
import candies.Lollipops;
import candies.Cookies;

import java.util.ArrayList;
import java.util.Comparator;

public class PresentHandler implements Box {

    public static void run() {

        PresentHandler gift = new PresentHandler();
        ArrayList<Candies> present = createPresentBox();
        gift.sort(present);
        gift.presentPrice(present);
        gift.presentWeight(present);
        gift.searchCandy(present);
        gift.createCandies();
        gift.getRandomCandy();

    }

    public static Candies[] createCandies(){
        Candies [] candies = new Candies[10];

        candies[0] = new ChocolateBar("Марс        ", "Шоколадный батончик",
                                25, 33, "Орехи");
        candies[1] =new ChocolateBar("Сникерс     ", "Шоколадный батончик",
                                39, 40, "Нуга");
        candies[2] =new ChocolateBar("Сникерс     ", "Шоколадный батончик",
                                39, 40, "Нуга");
        candies[3]=new Lollipops("Хуба-буба   ", "Леденцы            ",
                                24, 30);
        candies[4] =new Lollipops("Чупа-Чупс   ", "Леденцы            ",
                                31, 31);
        candies[5] =new Lollipops("Витаминка   ", "Леденцы            ",
                                        14, 11);
        candies[6] =new Cookies("Орео        ", "печенье            ",
                                29, 100);
        candies[7] =new Cookies("Наполеон    ", "печенье            ",
                                        26, 50);
        candies[8] =new Cookies("Грильяж     ", "печенье            ",
                                        100, 30);
        candies[9] =new Cookies("Тук         ", "печенье            ",
                                        55, 200);

        return candies;
    }

    public static Candies getRandomCandy() {
        int random = (int)Math.floor(Math.random() * createCandies().length);
        return createCandies()[random];
    }

    public static ArrayList<Candies> createPresentBox() {
        ArrayList<Candies> present = new ArrayList<>();

        for (int i=0;i<5;i++) {
            present.add(getRandomCandy());
        }
        System.out.println("Подарочный набор : ");
        System.out.println("| Наименование | Тип                 |Цена |Вес |");
        System.out.println("|--------------|---------------------|-----|----|");

        for (Candies candy : present) {
            candy.showAllInfo(candy.name);
        }
        return present;
    }

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
