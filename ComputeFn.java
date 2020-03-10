import java.util.*;
//
//  F(n) = (1) + (2*3) + (4*5*6) + ..... upto n packs. 
//
class ComputeFn
{  
  public static long computeFunction(long n)
  {
    long j = 1;
    long val = 0;
      for(int i=0;i<n;i++)
      {
        long g = 1;
        for( int k = 0;k<= i;k++)
        {
          g*= j;
          j++;
        }
        val += g;
      }
    return val;
  }
  public static void main(String args[])
  {  
    System.out.println(computeFunction(3));
  }
}

/*
Inout ; 3

output 127

*/
