/**
 * Created by zacharyvargas on 5/4/17.
 */
public class LambdaArgumentDemo {
    static String changeStr(StringFunc sf, String s)
    {
        return sf.func(s);
    }

    public static void main(String args[])
    {
        String inStr = "Lambda Expressions Expand Java";
        String outStr;

        System.out.println("Here is input string: " + inStr);

        StringFunc reverse = (str) -> {
            String result = "";

            for (int i = str.length()-1; i >= 0; i--)
            {
                result += str.charAt(i);
            }
            return result;
        };

        outStr = changeStr(reverse, inStr);
        System.out.println("The string reverse: " + outStr);

        outStr = changeStr((str) -> {
            String result = "";
            char ch;

            for (int i = 0; i < str.length(); i++)
            {
                ch = str.charAt(i);
                if (Character.isUpperCase(ch)) result += Character.toLowerCase(ch);
                else result += Character.toUpperCase(ch);
            }
            return result;
        }, inStr);

        System.out.println("The string in reversed case: " + outStr);
    }
}

interface StringFunc
{
    String func (String str);
}
