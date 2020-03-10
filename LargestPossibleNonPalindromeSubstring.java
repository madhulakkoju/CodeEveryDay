import java.util.*;

class LargestPossibleNonPalindromSubstring
{  
  public static boolean isPalindrome(String x)
  {
    for(int i =0;i<x.length()/2;i++)
    {
      if(x.charAt(i) != x.charAt(x.length() - i -1))
        return false;
    }
    return true;
  }
  public static int largestNonPalindrome(String x)
  {
    for(int i=x.length();i>0;i--)
    {
      for(int j = 0;j <= (x.length() - i ) ;j++)
      {
        if(! isPalindrome(x.substring(j,j+i)))
          return i;
      }
    }
    return 1;
  }
  public static void main(String args[])
  {  
    System.out.println(largestNonPalindrome("abcdcbaa"));
  }
}
