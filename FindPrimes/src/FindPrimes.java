/**
 * Created by zacharyvargas on 4/11/17.
 */
public class FindPrimes {
    public static void main(String args[])
    {
        for (int i = 2; i <= 100; i++)
        {
            boolean prime = true;
            for (int j = 2; j < 10; j++)
            {
                if ((j != i) && (i % j == 0))
                {
                    prime = false;
                    break;
                }
            }
            if (prime == true)
            {
                System.out.println(i + " is prime");
            }
        }
    }
}
