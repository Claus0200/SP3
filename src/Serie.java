import java.util.ArrayList;

public class Serie extends Media {

    ArrayList<Integer> totalEpisodes = new ArrayList<Integer>();

    public Serie(int ID, String titel, int year, String rating, ArrayList<String> category) {
        super(ID, titel, year, rating,category);
    }


    public ArrayList<Integer> getTotalEpisodes() {
        return totalEpisodes;
    }

    @Override
    public String toString() {
        return super.toString() + totalEpisodes;
    }

}

