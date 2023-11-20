import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;


public class FileIO {
    Scanner scan;

    public ArrayList<String> loadUsers(String path) {

        ArrayList<String> text = new ArrayList<>();
        File file = new File(path);

        try {
            scan = new Scanner(file);
            scan.nextLine();
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

    public void signupUser(String path, User user, ArrayList<User> users) {

        try {

            String previousUsers = "";
            String startLine = "Username;Password;ID" + "\n";
            FileWriter writer = new FileWriter(path);
            for(User userFromList : users) {
                previousUsers += userFromList.getUsername() + ";" + userFromList.getPassword() + ";" + userFromList.id + "\n";
            }
            String lineToSave = user.getUsername() + ";" + user.getPassword() + ";" + user.id;
            writer.write(startLine + previousUsers + lineToSave + "\n");
            writer.close();
        }
        catch(IOException e) {
            System.out.println("Something went wrong");
        }

    }

    public void saveUser(String path) {
        try {
            FileWriter writer = new FileWriter(path);
            writer.write("test");
            writer.close();
        }

        catch(IOException e) {

        }
    }


    public ArrayList<String> readMediaData(String path) {
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
