import java.lang.reflect.Array;
import java.util.ArrayList;

public class UserMenu {

    TextUI textUI = new TextUI();
    FileIO fileIO = new FileIO();
    User user;
    String path = "src/users.txt";
    ArrayList<User> users = new ArrayList<>();

    public User start() {
        loadUsers();
        getChoice();
        return user;
    }

    void getChoice() {
        String choice = textUI.getUserInput("Signup(S) or Login(L)");
        if (choice.equals("S")) {
            signup();
        }
        if (choice.equals("L")) {
            login();
        } else {
            getChoice();
        }
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }

    void loadUsers() {
        ArrayList<String> usersText = fileIO.loadUsers(path);
        for (String user : usersText) {
            String[] values = user.split(";");
            ArrayList<String> seenMediaList = new ArrayList<>();
            String[] seenMedias = values[3].split(",");
            for (int i = 0; i < seenMedias.length; i++) {
                seenMediaList.add(seenMedias[i]);
            }
            ArrayList<String> savedMediaList = new ArrayList<>();
            String[] savedMedia = values[4].split(",");
            for (int i = 0; i < savedMedia.length; i++) {
                savedMediaList.add(savedMedia[i]);
            }
            users.add(new User(values[0].trim(), values[1].trim(), Integer.parseInt(values[2]), seenMediaList, savedMediaList));

        }
        System.out.println(users);
    }


    void signup() {
        ArrayList<String> seenMedias = new ArrayList<>();
        ArrayList<String> savedMedias = new ArrayList<>();
        seenMedias.add("0");
        savedMedias.add("0");
        String password = "";
        String username = "";
        while (true) {
            boolean userExist = false;
            username = textUI.getUserInput("Username: ");
            password = textUI.getUserInput("Password: ");
            for (User userFromList : users) {
                if (username.equals(userFromList.getUsername())) {
                    userExist = true;
                    System.out.println("This username already exist!");
                }
            }
            if (userExist == false) {
                break;
            }
        }

        user = new User(username, password, users.size() + 1, seenMedias, savedMedias);
        fileIO.signupUser("src/users.txt", user, users);
        users.add(user);
        System.out.println("User has been saved");
    }

    void login() {
        boolean loginSucces = false;
        while (!loginSucces) {
            String username = textUI.getUserInput("Username: ");
            String password = textUI.getUserInput("Password: ");
            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    this.user = user;
                    loginSucces = true;
                    System.out.println("Login succesful");
                }
            }
            if (!loginSucces) {
                System.out.println("You failed to login, try again");
            }
        }
    }

    void saveUsers(ArrayList<User> usersList) {
        fileIO.saveUsers(path, usersList);
    }
}

