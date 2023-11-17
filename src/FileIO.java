import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;


public class FileIO {
    Scanner scan;

    public ArrayList<String> readUser(String path) {

        ArrayList<String> text = new ArrayList<>();
        File file = new File(path);

        try {
            scan = new Scanner(file);
            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                text.add(line);
            }
        }

        catch(FileNotFoundException e) {
            System.out.print("File not found");
        }

        return text;
    }

    public void saveUser(String path, User user) {

        try {

            FileWriter writer = new FileWriter(path);
            for (String s : readUser(path)) {
                scan.nextLine();
                System.out.println(s);
            }
            String lineToSave = user.getUsername() + "; " + user.getPassword();
            writer.write(lineToSave + "\n");
        }
        catch(IOException e) {
            System.out.println("Something went wrong");
        }

    }

    /*
    public void searchUser(S

     */

    /*public static void searchCategory(String genre) throws FileNotFoundException {
        File file = new File("src/100bedstefilm.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            final String lineFromFile = scanner.nextLine();
            if (lineFromFile.contains(genre)) {
                // a match!
                System.out.println(lineFromFile);
                // break;
            }
        }
    }*/
    public ArrayList<String> readPlayerData(String path) {
        ArrayList<String> data = new ArrayList<>();
        //instantier File
        File file = new File(path);

        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String s = scan.nextLine();// Hele linjen vil stå i én string   ==>  "Egon, 200"
                data.add(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }

        return data;
    }
}
