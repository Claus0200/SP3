import java.util.ArrayList;

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
        userMenu.saveUsers(users);
    }

    public void getChoice() {
        while (true) {
            String choice = textUI.getUserInput("search for media, category, rating, seen medias, saved medias or quit(Quit)").toLowerCase();
            if (choice.equals("rating") || choice.equals("r")) {
                searchRating(textUI.getUserInput("Which rating score from IMDB would you like to search for?"));
            }
            if (choice.equals("category") || choice.equals("c")) {
                searchCategory(textUI.getUserInput("Which category would you like to search for?"));
            }
            if (choice.equals("media") || choice.equals("movie") || choice.equals("serie")) {
                searchMedia(textUI.getUserInput("What movie/serie would you like to search for?"));
            }
            if (choice.equals("seen") || choice.equals("seen medias")) {
                seenMovies();
            }
            if (choice.equals("saved") || choice.equals("saved medias")) {
                showSavedMovies();
            }
            if (choice.equals("quit") || choice.equals("q")) {
                break;
            }
        }
    }


    public void searchMedia(String searchMedia) {
        ArrayList<Media> movies = new ArrayList<>();
        for (Media media : medias) {
            if (media.getTitel().contains(searchMedia)) {
                movies.add(media);
            }
        }
        if (movies.isEmpty()) {
            searchMedia(textUI.getUserInput("There were no movies/series with that name, try again."));
        } else {
            Media media = selectMovie(movies);
            playMovie(media);
        }
    }

    public void searchCategory(String searchcategory) {
        ArrayList<Media> categories = new ArrayList<>();
        for (Media media : medias) {
            if (media.getCategory().contains(searchcategory)) {
                categories.add(media);
            }
        }
        if (categories.isEmpty()) {
            System.out.println("There was no movie/serie with that name");
        } else {
            Media media = selectMovie(categories);
            playMovie(media);
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
            if (user.getSeenMedia().contains(media.ID)) {
                seenMovies.add(media);
            }
        }
        if (!seenMovies.isEmpty()) {
            Media media = selectMovie(seenMovies);
            playMovie(media);
        } else {
            System.out.println("You have not seen any movies/series");
        }
    }

    public Media selectMovie(ArrayList<Media> medias) {
        for (int i = 0; i < medias.size(); i++) {
            System.out.println(i + 1 + ") " + medias.get(i));
        }
        String text = textUI.getUserInput("Which movie/serie would you like to choose (ID)?").toLowerCase();
        try {
            try {
                Media number = medias.get(Integer.parseInt(text) - 1);
                if (medias.contains(number)) {
                    return medias.get(Integer.parseInt(text) - 1);
                } else {
                    return selectMovie(medias);
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("You didnt enter a correct ID, try again");
                return selectMovie(medias);
            }
        } catch (NumberFormatException e) {
            System.out.println("You didnt enter a number, try again");
            return selectMovie(medias);
        }
    }

    public void showSavedMovies() {
        ArrayList<Media> savedMedias = new ArrayList<>();

        for (Media media : medias) {
            if (user.getSavedMedia().contains(media.ID)) {
                savedMedias.add(media);
            }
        }

        if (!savedMedias.isEmpty()) {
            String choice = textUI.getUserInput("Would you like to watch a movie/serie, or remove?").toLowerCase();
            if (choice.equals("watch") || choice.equals("w")) {
                Media media = selectMovie(savedMedias);
                playMovie(media);
            } else if (choice.equals("remove") || choice.equals("r")) {
                removeFromWatchLater(selectMovie(savedMedias));
            }
        } else {
            System.out.println("You have not saved any movies/serie");
        }
    }

    void logout() {
        System.exit(0);
    }

    void playMovie(Media media) {
        String choice = textUI.getUserInput("Would you like to watch: " + media.getTitel() + " Yes(Y) or No(N)").toLowerCase();
        if (choice.equals("y") || choice.equals("yes")) {
            System.out.println(media.getTitel() + " is now playing");
            textUI.getUserInput("Press any button to quit");
            if (!user.getSeenMedia().contains(media.ID)) {
                user.addSeenMedia(media.ID);
            }
            addToWatchLater(media);
        }
        if (choice.equals("n") || choice.equals("no")) {
            System.out.println("The movie/serie is not playing");
            addToWatchLater(media);
        }
    }

    void addToWatchLater(Media media) {
        if (!user.getSavedMedia().contains(media.ID)) {
            String savedMovie = textUI.getUserInput("Would you like to save: " + media.getTitel() + " Yes(Y) or No(N)").toLowerCase();
            if (savedMovie.equals("y") || savedMovie.equals("yes")) {
                System.out.println(media.getTitel() + "Movie/serie is now saved");
                user.addSavedMedia(media.ID);
            }
            if (savedMovie.equals("n") || savedMovie.equals("no")) {
                System.out.println(media.getTitel() + "Movie/serie is not saved");
            }
        }
    }

    void removeFromWatchLater(Media media) {
        if (user.getSavedMedia().contains(media.ID)) {
            String savedMovie = textUI.getUserInput("Would you like to remove: " + media.getTitel() + " Yes(Y) or No(N)").toLowerCase();
            if (savedMovie.equals("y") || savedMovie.equals("yes")) {
                System.out.println(media.getTitel() + "Movie/serie is now removed");
                user.removeSavedMedia(media.ID);
            }
            if (savedMovie.equals("n") || savedMovie.equals("no")) {
                System.out.println(media.getTitel() + "Movie/serie is not removed");
            }
        }
    }
}