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
        gift.priceBox(present);
        gift.weightBox(present);
        gift.searchCandy(present);
        createCandies();
        getRandomCandy();

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
                                29, 100, "Шоколадное");
        candies[7] =new Cookies("Наполеон    ", "печенье            ",
                                        26, 66, "Песочное");
        candies[8] =new Cookies("Грильяж     ", "печенье            ",
                                        100, 30, "Имбирное");
        candies[9] =new Cookies("Тук         ", "печенье            ",
                                        55, 200, "Слоенное");

        return candies;
    }

    public static Candies getRandomCandy() {
        int random = (int)Math.floor(Math.random() * createCandies().length);
        return createCandies()[random];
    }

    public static ArrayList<Candies> createPresentBox() {
        int count=10;

        ArrayList<Candies> present = new ArrayList<>();

        for (int i=0;i<count;i++) {
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
       Param param = Param.NAME;

       switch (param) {
           case NAME -> present.sort(Comparator.comparing(Candies::getName));
           case WEIGHT -> present.sort(Comparator.comparing(Candies::getWeight));
           case PRICE -> present.sort(Comparator.comparing(Candies::getPrice));
           case TYPE -> present.sort(Comparator.comparing(Candies::getType));
       }

        System.out.println("Подарочный набор отсортирован:  (by "+ param+")");
        System.out.println("| Наименование | Тип                 |Цена|Вес |");
        System.out.println("|--------------|---------------------|----|----|");

        for (Candies candy : present) {
            candy.showAllInfo(candy.name);
        }
    }

    @Override
    public void priceBox(ArrayList<Candies> present) {
        int sum = 0;
        for (Candies candy : present) {
            sum += candy.getPrice();
        }
        System.out.println("Цена подарка: " + sum);
    }

    @Override
    public void weightBox(ArrayList<Candies> present) {
        int sum = 0;
        for (Candies candy : present) {
            sum += candy.getWeight();
        }
        System.out.println("Вес подарка: " + sum);
    }

    @Override
    public void searchCandy(ArrayList<Candies> present) {
        Param param = Param.NAME;
        String value="Орео        ";
        int min = 10;
        int max= 30;

        System.out.println("Фильтр конфет ("+param+value+min+max+"):");

        switch (param) {
            case NAME -> {
                for (Candies candy : present) {
                    if (candy.getName().equals(value)) {
                        System.out.println("- " + candy.name);
                    }
                }
            }
            case WEIGHT -> {
                for (Candies candy : present) {
                    if (candy.getWeight() >= min && candy.getWeight() <= max) {
                        System.out.println("- " + candy.name);
                    }
                }
            }
            case PRICE -> {
                for (Candies candy : present) {
                    if (candy.getPrice() >= min && candy.getPrice() <= max) {
                        System.out.println("- " + candy.name);
                    }
                }
            }
            case TYPE -> {
                for (Candies candy : present) {
                    if (candy.getType().equals(value)) {
                        System.out.println("- " + candy.name);
                    }
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + param);
        }

    }
}
