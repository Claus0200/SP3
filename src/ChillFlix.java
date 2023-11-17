import java.util.ArrayList;

public class ChillFlix {
    public ArrayList<Movie> movies = new ArrayList<>();
    public ArrayList<Serie> series = new ArrayList<>();
    public ArrayList<Ebook> ebooks = new ArrayList<>();
    public User user;
    FileIO fileIO = new FileIO();
    TextUI textUI = new TextUI();
    CreateMedia createMedia = new CreateMedia();

    void getMedia() {
        CreateMedia.createMovie();

    }

    void getChoice() {
     
    }

    void searchMovie() {

    }

    /*void searchCategory() {
        try {
            fileIO.searchCategory(textUI.getUserInput("Hvad vil du søge på taber"));
        }
        catch(Exception e) {
            System.out.println("Dette er ikke en kategori");
        }
    }
*/

    void showSeenMovies() {

    }

    void showSavedMovies() {

    }

    void searchEBooks() {

    }

    void logout() {
        System.exit(0);
    }

    void playMovie() {

    }


    void addToWatchLater() {

    }

    void removeFromWatchLater() {

    }


}
