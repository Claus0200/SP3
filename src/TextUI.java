import java.util.Scanner;

public class TextUI {



// Our getUserInput method with parameter: String msg

    public String getUserInput(String msg) {
        Scanner scan = new Scanner(System.in);       // Declaring the Variable scan, to Refer to a object or a new scanner. scanner will scan across line or console. It scans through input.If your program asks you to input something, it's called an input. Input is what the user wants to tell the computer. Scanners are used for input.
        System.out.println(msg);                     //  printing out the msg
        String text = scan.nextLine();              //  Declaring the variable text to scan.nextLine().
        return text;
    }
}
