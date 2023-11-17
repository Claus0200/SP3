import java.util.ArrayList;

public class CreateMedia {

    static ArrayList<Movie> movies = new ArrayList<>();

    static FileIO io = new FileIO();

    static void createMovie() {
        ArrayList<String> data = io.readPlayerData("src/100bedstefilm.txt");
        for (String s : data) {
            String[] row = s.split(";");
            String titel = row[0];
            int year = Integer.parseInt(row[1].trim());

            ArrayList<String> category2 = new ArrayList<>();

            String[] ctg = row[2].split(",");
            for (int i = 0; i < ctg.length; i++) {
                category2.add(ctg[i].trim());
            }
            String rating = row[3].trim();



            movies.add(new Movie(0, titel, year, rating, category2));
        }

        for (Movie movie : movies) {
            System.out.println(movie);
        }



        /*void createSerie () {

            static void createSerie() {
                ArrayList<String> data = io.readPlayerData("src/100bedsteSerie.txt");
                if (data.size() > 0) {
                    for (String s : data) {
                        String[] row = s.split(";");

                        System.out.println("\n"+data);

                    }
        }*/

       // void createEBook () {

       // }

    }
}
