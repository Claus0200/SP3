import java.util.ArrayList;

public class User {
    public int id;
    private String username;
    private String password;
    private ArrayList<String> savedMedia;
    private ArrayList<String> seenMedia;

    User(String username, String password, int id, ArrayList<String> seenMedia, ArrayList<String> savedMedia) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.seenMedia = seenMedia;
        this.savedMedia = savedMedia;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<String> getSeenMedia() {
        return seenMedia;
    }

    public void addSeenMedia(String add) {
        this.seenMedia.add(add);
    }

    public ArrayList<String> getSavedMedia() {
        return savedMedia;
    }
    public void addSavedMedia(String add) {
        this.savedMedia.add(add);
    }
    public void removeSavedMedia(String remove) {
        this.savedMedia.remove(remove);
    }
    @Override
    public String toString() {
        return username + "; " + password + "; " + id + "; " + seenMedia + "; " + savedMedia;
    }
}
