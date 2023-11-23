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
        while (true) {
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
            if (choice.equals("Saved")) {
                showSavedMovies();
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
        if (movies.isEmpty()) {
            searchMovie(textUI.getUserInput("Der var ingen film med det navn, prøv igen."));
        } else {
            playMovie(selectMovie(movies));
        }
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
        ArrayList<Media> seenMovies = new ArrayList<>();
        for (Media media : medias) {
            if (user.getSeenMedia().contains(media.ID) && media instanceof Movie) {
                System.out.println(media);
                seenMovies.add(media);
            }
        }
        if(!seenMovies.isEmpty()) {
            String choice = textUI.getUserInput("Would you like to watch any of these movies? Yes(Y) or No(N)").toLowerCase();
            if (choice.equals("y") || choice.equals("yes")) {
                Media movie = selectMovie(seenMovies);
                playMovie(movie);
            }
        }
        else {
            System.out.println("There was no media with that name");
        }
    }

    public Media selectMovie(ArrayList<Media> movies) {
        for (int i = 0; i < movies.size(); i++) {
            System.out.println(i + 1 + ") " + movies.get(i));
        }
        String text = textUI.getUserInput("Hvilken film vil du vælge? ID (1,2,3...)");
        return movies.get(Integer.parseInt(text) - 1);
    }

    public void showSavedMovies() {
        ArrayList<Media> savedMovies = new ArrayList<>();

        for (Media media : medias) {
            if (user.getSavedMedia().contains(media.ID) && media instanceof Movie) {
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
            System.out.println(movie.getTitel() + " is now playing");
            user.addSeenMedia(movie.ID);
            textUI.getUserInput("Press any button to quit");
            addToWatchLater(movie);
        }
        if (choice.equals("n") || choice.equals("no")) {
            System.out.println("The Movie is not playing");
            addToWatchLater(movie);
        }

    }

    void addToWatchLater(Media movie) {

        String savedMovie = textUI.getUserInput("Would you like to save : " + movie.getTitel() + " Yes(Y) or No(N)").toLowerCase();

        if (savedMovie.equals("y") || savedMovie.equals("yes")) {
            System.out.println(movie.getTitel() + " Movie is now saved");
            user.addSavedMedia(movie.ID);
        }
        if (savedMovie.equals("n") || savedMovie.equals("no")) {
            System.out.println(movie.getTitel() + "Movie is not saved");
        }
    }

    void removeFromWatchLater() {

    }
}