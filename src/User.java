import java.util.ArrayList;

public class User {
    public int id;
    private String username;
    private String password;
    private ArrayList<String> savedFilms;
    private ArrayList<Integer> savedSeries;
    private ArrayList<Integer> savedEbooks;
    private ArrayList<String> seenMovies;

    User(String username, String password, int id, ArrayList<String> seenMovies) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.seenMovies = seenMovies;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<String> getSeenMovies() {
        return seenMovies;
    }

    public void setSeenMovies(String add) {
        this.seenMovies.add(add);
    }

    public ArrayList<String> getShowSavedMovies() {
        return savedFilms;
    }
    @Override
    public String toString() {
        return username + "; " + password + "; " + id;
    }
}
