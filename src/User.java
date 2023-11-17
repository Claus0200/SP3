import java.util.ArrayList;

public class User {
    public int id;
    private String username;
    private String password;
    private ArrayList<Integer> savedFilms;
    private ArrayList<Integer> savedSeries;
    private ArrayList<Integer> savedEbooks;

    User(String username, String password, int id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return username + "; " + password + "; " + id;
    }
}
