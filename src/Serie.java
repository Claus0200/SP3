import java.util.ArrayList;

// Extends is used, since serie inherits from the Media abstract class

public class Serie extends Media {

// Declaring an ArrayList of the total episodes in a serie.

    ArrayList<String> totalEpisodes;


    // Our serie constructor.
    // Super is a reference variable. Refers to the super class and the inheritance class. The class from which the subclass is derived is called a superclass

    public Serie(String ID, String titel, String year, String rating, ArrayList<String> category, ArrayList<String> totalEpisodes) {
        super(ID, titel, year, rating,category);
        this.totalEpisodes = totalEpisodes;
    }


    // Getter method, that let you get variables inside a class. A class represents an object since java is object oriented.

    public ArrayList<String> getTotalEpisodes() {
        return totalEpisodes;
    }



    // toString methods to print out our objects. @Override is used.




    @Override
    public String toString() {
        return " The serie's name: " + getTitel() + ". Release year of the serie: " + getYear() + " The serie's rating: " + getRating() + " The serie category(s): " + getCategory() + " Episodes: " + totalEpisodes;
    }
}

