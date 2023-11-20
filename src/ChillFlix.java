import java.util.ArrayList;

public class ChillFlix {
    public ArrayList<Media> medias = new ArrayList<>();
    public User user;

    FileIO fileIO = new FileIO();
    TextUI textUI = new TextUI();
    CreateMedia createMedia = new CreateMedia();

    void getMedia() {
        medias = CreateMedia.loadMediaData();
    }

    void start(User user) {
        this.user = user;
        getMedia();
        getChoice();
        //playMovie();
    }

    public void getChoice() {
        String choice = textUI.getUserInput("search for movie(Movie), search for Category(Category) or search for rating(Rating)");
        if (choice.equals("Rating")) {
            searchRating(textUI.getUserInput("Hvilken rating score fra rottentomato vil du søge på?"));
        }
        if (choice.equals("Category")) {
            searchCategory(textUI.getUserInput("Hvilken category vil du søge efter?"));
        }
        if (choice.equals("Movie")) {
            searchMovie(textUI.getUserInput("Hvilken film vil du søge efter?"));
        }
    }

    public void searchMovie(String searchmovie) {
        int count = 0;
        for (Media media : medias) {
            if (media.getTitel().contains(searchmovie)) {
                count += 1;
                System.out.println(count + ") " + media.toString());
            }
        }
    }

    public void searchCategory(String searchcategory) {
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

   /* void SeenMovies(String SeenMovies) {
        for (Movie movie : movies) {
            if (user.getSeenMovies().) {

            }


        }


    }*/


    void showSavedMovies() {

    }

    void searchEBooks() {

    }

    void logout() {
        System.exit(0);
    }

    void playMovie() {
        String choice = textUI.getUserInput("Would you like to watch this movie? Yes(Y) or No(N)");
        if (choice.equals("Y")) {

        }
        if (choice.equals("N")) {

        }
    }


    void addToWatchLater() {

    }

    void removeFromWatchLater() {

    }


}
