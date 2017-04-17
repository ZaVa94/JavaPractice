import java.io.IOException;

/**
 * Created by zacharyvargas on 4/12/17.
 */
public class CheckPeriod {
    public static void main(String args[]) throws IOException {
        char input;
        int count = 0;

        System.out.println("Type a character, spaces get counted. Enter a period to exit");

        do {
            input = (char) System.in.read();
            if (input == ' ')
            {
                count++;
            }
        } while (input != '.');

        System.out.println("Number of spaces: " + count);
    }
}
