import jdk.jfr.Category;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Objects;

public class ChillFlix {
    public ArrayList<Media> medias = new ArrayList<>();
    public ArrayList<User> users = new ArrayList<>();
    public User user;

    TextUI textUI = new TextUI();
    UserMenu userMenu = new UserMenu();
          
    void start() {
        user = userMenu.start();
        users = userMenu.getUsers();
        medias = CreateMedia.loadMediaData();
        getChoice();
        //FIX DET HER
        userMenu.saveUsers(users);
    }

    public void getChoice() {
        while(true) {
            String choice = textUI.getUserInput("search for movie(Movie), search for Category(Category), search for rating(Rating), search for seen movies(Seen) or quit(Quit)");
            if (choice.equals("Rating")) {
                searchRating(textUI.getUserInput("Hvilken rating score fra rottentomato vil du søge på?"));
            }
            if (choice.equals("Category")) {
                searchCategory(textUI.getUserInput("Hvilken category vil du søge efter?"));
            }
            if (choice.equals("Movie")) {
                searchMovie(textUI.getUserInput("Hvilken film vil du søge efter?"));
            }
            if (choice.equals("Seen")) {
                seenMovies();
            }
            if (choice.equals("Quit")) {
                break;
            }
        }
    }

    public void searchMovie(String searchmovie) {
        ArrayList<Media> movies = new ArrayList<>();
        for (Media media : medias) {
            if (media.getTitel().contains(searchmovie)) {
                movies.add(media);
            }
        }
        selectMovie(movies);
    }

    public void searchCategory(String searchcategory) {
        ArrayList<Objects> categories = new ArrayList<>();
        for (Media media : medias) {
            if (media.getCategory().contains(searchcategory)) {
                System.out.println(media);
            }
        }
    }

    public void searchRating(String searchrating) {
        for (Media media : medias) {
            if (media.getRating().contains(searchrating)) {
                System.out.println(media);
            }
        }
    }

    public void seenMovies() {
        for (Media media : medias) {
            if (user.getSeenMovies().contains(media.ID) && media instanceof Movie) {
                System.out.println(media);
            }
        }
    }

    void selectMovie(ArrayList<Media> movies) {
        for (int i = 0; i < movies.size(); i++) {
            System.out.println(i+1 + ") " + movies.get(i));

        }
        String text = textUI.getUserInput("Hvilken film vil du vælge? ID (1,2,3...)");
        playMovie(movies.get(Integer.parseInt(text)-1));
    }

    public void showSavedMovies(String showSavedMovies) {
        showSavedMovies = textUI.getUserInput("Saved Movies: ");
        for (Media media : medias) {
            if (user.getShowSavedMovies().contains(media.ID) && media instanceof Movie) {
                System.out.println(media);
            }
        }
    }

    void searchEBooks() {

    }

    void logout() {
        System.exit(0);
    }

    void playMovie(Media movie) {
        String choice = textUI.getUserInput("Would you like to watch: " + movie.getTitel() + " Yes(Y) or No(N)").toLowerCase();
        if (choice.equals("y") || choice.equals("yes")) {
            System.out.println("You are now watching: " + movie.getTitel());
            user.setSeenMovies(movie.ID);
        }
        if (choice.equals("n") || choice.equals("no")) {
            getChoice();
        }
    }


    void addToWatchLater() {


    }

    void removeFromWatchLater() {


    }


}
