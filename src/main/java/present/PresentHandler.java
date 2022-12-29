package present;

import candies.Candies;
import candies.ChocolateBar;
import candies.Lollipop;
import candies.Cookie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

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
        candies[1] = new ChocolateBar("Сникерс     ", "Шоколадный батончик",
                                39, 40, "Нуга");
        candies[2] = new ChocolateBar("Сникерс     ", "Шоколадный батончик",
                                39, 40, "Нуга");
        candies[3] = new Lollipop("Хуба-буба   ", "Леденцы            ",
                                24, 30, "Малиновый");
        candies[4] = new Lollipop("Чупа-Чупс   ", "Леденцы            ",
                                31, 31, "Клубличный");
        candies[5] = new Lollipop("Витаминка   ", "Леденцы            ",
                                        14, 11, "Кока-кола");
        candies[6] = new Cookie("Орео        ", "печенье            ",
                                29, 100, "Шоколадное");
        candies[7] = new Cookie("Наполеон    ", "печенье            ",
                                        26, 66, "Песочное");
        candies[8] = new Cookie("Грильяж     ", "печенье            ",
                                        100, 30, "Имбирное");
        candies[9] = new Cookie("Тук         ", "печенье            ",
                                        55, 200, "Слоенное");

        return candies;
    }

    public static Candies getRandomCandy() {
        int random = (int)Math.floor(Math.random() * createCandies().length);
        return createCandies()[random];
    }

    public static ArrayList<Candies> createPresentBox() {

        Scanner countScaner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Введите колличество конфет для генерации подарка:");
        int count = countScaner.nextInt();

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

       Scanner paramScaner = new Scanner(System.in);  // Create a Scanner object
       System.out.println("Выберете параметр для сортировки конфет в подарке(NAME,WEIGHT,PRICE,TYPE)");
       String a = paramScaner.nextLine();
           Param param = Param.valueOf(a);

           switch (param) {
               case NAME -> present.sort(Comparator.comparing(Candies::getName));
               case WEIGHT -> present.sort(Comparator.comparing(Candies::getWeight));
               case PRICE -> present.sort(Comparator.comparing(Candies::getPrice));
               case TYPE -> present.sort(Comparator.comparing(Candies::getType));
           }

           System.out.println("Подарочный набор отсортирован:  (by " + param + ")");
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

        Scanner paramScaner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Выберете параметр для поиска конфет в подарке(NAME,WEIGHT,PRICE,TYPE)");
        String parameter = paramScaner.nextLine();
        Param param = Param.valueOf(parameter);

        switch (param) {
            case NAME -> {
                Scanner valueScaner = new Scanner(System.in);
                System.out.println("Введите значение для поля"+param);
                String value = valueScaner.nextLine();
                System.out.println("Результат поиска по " + param+" со значением "+value);
                for (Candies candy : present) {
                    if (candy.getName().equals(value)) {
                        System.out.println("- " + candy.name);
                    }
                }
            }
            case WEIGHT -> {
                Scanner minScaner = new Scanner(System.in);
                System.out.println("Введите минимальное значение для поиска по полю "+param);
                int min = minScaner.nextInt();
                Scanner maxScaner = new Scanner(System.in);
                System.out.println("Введите максимальное значение для поиска по полю "+param);
                int max = maxScaner.nextInt();
                System.out.println("Результат поиска по " + param+" с диапазоном значений от "+min+" до "+max);
                for (Candies candy : present) {
                    if (candy.getWeight() >= min && candy.getWeight() <= max) {
                        System.out.println("- " + candy.name);
                    }
                }
            }
            case PRICE -> {
                Scanner minScaner = new Scanner(System.in);
                System.out.println("Введите минимальное значение для поиска по полю "+param);
                int min = minScaner.nextInt();
                Scanner maxScaner = new Scanner(System.in);
                System.out.println("Введите максимальное значение для поиска по полю "+param);
                int max = maxScaner.nextInt();
                System.out.println("Результат поиска по " + param+" с диапазоном значений от "+min+" до "+max);
                for (Candies candy : present) {
                    if (candy.getPrice() >= min && candy.getPrice() <= max) {
                        System.out.println("- " + candy.name);
                    }
                }
            }
            case TYPE -> {
                Scanner valueScaner = new Scanner(System.in);
                System.out.println("Введите значение для поля"+param);
                String value = valueScaner.nextLine();
                System.out.println("Результат поиска по " + param+" со значением "+value);
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
