import java.util.ArrayList;

// The Media class is an abstract class,
// That inherits its content to the movie and serie class.

public abstract class Media {

// Declare variables

    public String ID;
    private String titel;
    private String year;
    private String rating;
    private ArrayList<String> category;

 // Our Media Constructor, that holds our variables

    Media(String ID, String titel, String year, String rating, ArrayList<String> category) {
        this.ID = ID;
        this.titel = titel;
        this.year = year;
        this.rating = rating;
        this.category = category;

    }

    public void testMethod() {
        System.out.println("0");
    }

// Getter methods that let you get variables inside a class. A class represents an object since java is object oriented.

    public String getTitel() {
        return titel;
    }

    public String getYear() {
        return year;
    }

    public String getRating() {
        return rating;
    }

    public ArrayList<String> getCategory() {
        return category;
    }


// toString methods to print out our objects.




}
