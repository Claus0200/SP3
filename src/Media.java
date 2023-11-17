import java.util.ArrayList;

public abstract class Media {

    public int ID;
    private String titel;
    private int year;
    private String rating;
    private ArrayList<String> category;

    Media(int ID, String titel, int year, String rating, ArrayList<String> category) {
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

    private int getYear() {
        return year;
    }

    private String getRating() {
        return rating;
    }

    private ArrayList<String> getCategory() {
        return category;
    }

    public String toString() {
        return " The movies name: " + titel + ". Release year of the movie: " + year + " The movies rating: " + rating + " The movies category: " + category;
    }



}
