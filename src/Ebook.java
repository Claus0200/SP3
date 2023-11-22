import java.util.ArrayList;

// Extends is used, since Ebook inherits from the Media abstract class.

public class Ebook extends Media {

// Our Ebook constructor.

    Ebook(String ID, String titel, String year, String rating, ArrayList<String> category) {
        super(ID, titel, year, rating, category);

    }

}


