import java.io.IOException;

/**
 * Created by zacharyvargas on 4/12/17.
 */
public class ConvertLowerToUpper {
    public static void main(String args[]) throws IOException {
        char input;
        int changes = 0;

        System.out.println("Enter characters. Enter a period to exit");

        do {
            input = (char) System.in.read();

            if (input > 'a' & input < 'z')
            {
                changes++;
                input -= 32;
                System.out.println(input);
            }
            else if (input > 'A' & input < 'Z')
            {
                changes++;
                input += 32;
                System.out.println(input);
            }
        } while (input != '.');

        System.out.println("Total Changes: " + changes);
    }
}
