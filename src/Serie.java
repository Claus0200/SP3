import java.util.ArrayList;

public class Serie extends Media {

    ArrayList<String> totalEpisodes;

    public Serie(String ID, String titel, String year, String rating, ArrayList<String> category, ArrayList<String> totalEpisodes) {
        super(ID, titel, year, rating,category);
        this.totalEpisodes = totalEpisodes;
    }


    public ArrayList<String> getTotalEpisodes() {
        return totalEpisodes;
    }

    @Override
    public String toString() {
        return super.toString() + totalEpisodes;
    }

}

