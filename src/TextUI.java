import java.util.Scanner;

public class TextUI {
    void printText(String msg) {

    }

    public String getUserInput(String msg) {
        Scanner scan = new Scanner(System.in);
        System.out.println(msg);
        String text = scan.nextLine();
        return text;
    }
}
