import jdk.jfr.Category;

import java.time.Duration;

import java.util.ArrayList;

public class Movie extends Media {

    Movie(int ID, String titel, int year, String rating, ArrayList<String> category) {
      super(ID, titel,year,rating,category);
    }

}
