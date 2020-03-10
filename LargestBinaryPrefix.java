//ref Coding club @ Linkedin

import java.util.*;
class LargeBinaryPrefix
{  
  public static void createBinary( String k, int n )
  {
    int ones = 0,zeros = 0;
      for(int i =0;i<k.length();i++)
      {
        if(k.charAt(i)=='0')
          zeros ++;
        else
          ones++;
        if(ones < zeros)
          return;
      }
    if(k.length() == n)
    {
      System.out.println(k);
      return;
    }
    createBinary(k+"1",n);
    createBinary(k+"0",n);
    return;
  }
  public static void main(String args[])
  {  
    createBinary("",5);
  }
}
