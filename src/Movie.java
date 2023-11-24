import jdk.jfr.Category;

import java.time.Duration;

import java.util.ArrayList;

// Extends is used, since movie inherits from the Media abstract class

public class Movie extends Media {

// Our movie constructor.

 Movie(String ID, String titel, String year, String rating, ArrayList<String> category) {
      super(ID, titel,year,rating,category);
    }

    @Override
    public String toString() {
        return " The movie's name: " + getTitel() + ". Release year of the movie: " + getYear() + " The movie's rating: " + getRating() + " The movie category(s): " + getCategory();
    }


}
