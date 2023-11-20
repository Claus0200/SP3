public class Main {
    public static void main(String[] args) {
        UserMenu userMenu = new UserMenu();
        User user;
        user = userMenu.start();
        ChillFlix chillFlix = new ChillFlix();
        //chillFlix.searchCategory();

        //Movie m1 = new Movie();

        chillFlix.start(user);

    }
}