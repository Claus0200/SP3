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
        if(choice.equals("S")) {
            signup();
        }
        if(choice.equals("L")) {
            login();
        }
    }

    void loadUsers() {
        ArrayList<String> usersText = fileIO.loadUsers(path);
        for(String user : usersText) {
            String[] values = user.split(";");
            users.add(new User(values[0].trim(),values[1].trim(),Integer.parseInt(values[2])));
        }
        System.out.println(users);
    }


    void signup() {
        user = new User(textUI.getUserInput("Username: "), textUI.getUserInput("Password: "),users.size()+1);
        for(User userFromList : users) {
            if(user.getUsername().equals(userFromList.getUsername())) {
                signup();
            }
            else {
                fileIO.signupUser("src/users.txt",user,users);
            }
        }
    }

    void login() {
        String username = textUI.getUserInput("Username: ");
        String password = textUI.getUserInput("Password: ");
        for(User user : users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                this.user = user;
            }
            else {
                login();
            }
        }
    }

    void fuckingDumbassWhoForgotPassword() {

    }
}
