import java.util.ArrayList;

public abstract class Media {

    public String ID;
    private String titel;
    private String year;
    private String rating;
    private ArrayList<String> category;


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

    public String toString() {
        return " The movies name: " + titel + ". Release year of the movie: " + year + " The movies rating: " + rating + " The movies category(s): " + category;
    }



}
