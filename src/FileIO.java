import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;


public class FileIO {

    Scanner scan;                         // Declaring the variable scan.


    public ArrayList<String> loadUsers(String path) {

        ArrayList<String> text = new ArrayList<>();     // Declaring a variable to a new ArrayList.
        File file = new File(path);                     // Declaring a new file, with path as parameter.

        try {
            scan = new Scanner(file);                   // Declaring scan to a new Scanner with our file parameter as variable.
            scan.nextLine();                            // Declaring scan.nextLine(); it scans the whole line.

            while (scan.hasNextLine()) {                // A while loop that contains scan.hasNextLine(). It is a method, which is used to check if there is another line in the input of this scanner.
                String line = scan.nextLine();          // Initialize the variable line to scan.nextLine()
                text.add(line);                         // I add the line to the text.
            }
        } catch (FileNotFoundException e) {
            System.out.print("File not found");         // Printing out "file not fot found"
        }

        return text;
    }

    public void signupUser(String path, User user, ArrayList<User> users) {

        try {

            String previousUsers = "";
            String startLine = "Username;Password;ID;SeenMedias;SavedMedias" + "\n";
            FileWriter writer = new FileWriter(path);
            for (User userFromList : users) {
                previousUsers += userFromList.getUsername() + ";" + userFromList.getPassword() + ";" + userFromList.id + ";";

                for (String watchedMovie : userFromList.getSeenMedia()) {
                    previousUsers += watchedMovie + ",";
                }

                previousUsers = previousUsers.substring(0,previousUsers.length()-1);
                previousUsers += ";";

                for (String savedMovie : userFromList.getSavedMedia()) {
                    previousUsers += savedMovie + ",";
                }
                previousUsers = previousUsers.substring(0,previousUsers.length()-1) + "\n";
            }

            String lineToSave = user.getUsername() + ";" + user.getPassword() + ";" + user.id + ";" + "0" + ";" + "0";
            writer.write(startLine + previousUsers + lineToSave + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }

    }

    public void saveUsers(String path, ArrayList<User> users) {
        try {
            String savedUsers = "";

            String StartLine = "Username;Password;ID;SeenMedias;SavedMedias" + "\n";
            FileWriter writer = new FileWriter(path);

            for (User userFromList : users) {
                savedUsers = savedUsers + userFromList.getUsername() + ";" + userFromList.getPassword() + ";" + userFromList.id + ";";

                for (String watchedMovie : userFromList.getSeenMedia()) {
                    savedUsers += watchedMovie + ",";
                }
                savedUsers = savedUsers.substring(0,savedUsers.length()-1);
                savedUsers += ";";

                for (String savedMedia : userFromList.getSavedMedia()) {
                    savedUsers += savedMedia + ",";
                }
                savedUsers = savedUsers.substring(0,savedUsers.length()-1) + "\n";
            }
            writer.write(StartLine + savedUsers);
            writer.close();
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
    }

    public ArrayList<String> readMediaData(String path) {
        ArrayList<String> data = new ArrayList<>();
        //instantier File
        File file = new File(path);

        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                data.add(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }


        return data;
    }
}
