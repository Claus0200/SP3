import java.util.ArrayList;

public class UserMenu {

    TextUI textUI = new TextUI();
    FileIO fileIO = new FileIO();
    User user;
    String path = "src/users.txt";

    void start() {
        getChoice();
    }

    void getChoice() {
        String choice = textUI.getUserInput("Signup(S) or Login(L)");
        if(choice.equals("S")) {
            signup();
        }
        if(choice.equals("L")) {
            test();
        }

    }

    void signup() {
        user = new User(textUI.getUserInput("Username: "), textUI.getUserInput("Password: "),0);
        fileIO.saveUser("src/users.txt",user);
    }

    void login() {
        test();
        /*
        String loginUsername = textUI.getUserInput("Username: ");
        String loginPassword = textUI.getUserInput("Password: ");


        user = new User(textUI.getUserInput(),textUI.getUserInput(),0);
        if (user.getUsername().equals())


        */
    }

    void test() {
        ArrayList<String> users = fileIO.readUser(path);
        for(String user : users) {
            System.out.println(user);
        }
    }

    void fuckingDumbassWhoForgotPassword() {

    }

    void loadSavedMedia() {

    }
}
