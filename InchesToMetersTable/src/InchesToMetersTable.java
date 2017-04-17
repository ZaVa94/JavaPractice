/**
 * Created by zacharyvargas on 4/10/17.
 */
public class InchesToMetersTable {
    public static void main(String args[])
    {
        double inches, meters;
        int counter = 1;

        for (inches = 1; inches <= 144; inches++)
        {
            meters = inches * .0254;
            System.out.println(inches + " inches is " + meters + " meters");
            if (counter == 12)
            {
                System.out.println();
                counter = 0;
            }
            counter++;
        }
    }
}
