import java.io.*;
import java.util.*;

class  Sherlock
{
    public static int getDoorCount(String s)
    {
        if(s.equals(""))
            return -1;
        s  = s.replace("+-","");
        int open = 0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='+')
                open++;
            else
                return -1;
        }
        return open;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int op = getDoorCount(sc.nextLine());
        if(op == -1)
        System.out.println("Invalid");
        else
        System.out.println(op);
    }
}