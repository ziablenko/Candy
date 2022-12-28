package present;

import candies.Candies;

import java.util.ArrayList;

public interface Box {

 void sort(ArrayList<Candies> present);
 void priceBox(ArrayList<Candies> present);
 void weightBox(ArrayList<Candies> present);
 void searchCandy(ArrayList<Candies> present);

}
