/*
Find the no of pairs (x,y) such that 0<= x<=n & 0<=y<=n 
F(x)  = sum of digits in x 
find number of pairs sucg that F(x) + F(y) is a prime number .
n = 3
output = 5 

*/
import java.util.*;
class MinGroups
{  
  public static ArrayList<Integer> primes;
  public static ArrayList<Integer> primeNumbers(Integer n)
  {
    ArrayList<Integer> primes = new ArrayList<Integer>();
    for(int i =2;i<= n;i++)
    {
      primes.add(i);
    }
    int i = 0;
    while(i < primes.size())
    {
      int prime = primes.get(i);
      int spr = prime ;
      while(true)
      {
        spr = spr + prime;
        if(spr > n) break;
        int k = primes.indexOf(spr);
        if(k == -1) continue;
         primes.remove(k);
      }
      i ++;
    }
    return primes;
  }
  
  public static boolean isPrime(Integer n)
  {
    if(primes.indexOf(n) == -1)
      return false;
    return true;
  }
  
  public static int F(int n)
  {
    int a= n;
    int sum = 0;
    while(a > 0)
    {
      sum += a%10;
      a/= 10;
    }
    return sum;
  }
  
  public static int findGroups(int n)
  {
    ArrayList<Integer> sums = new ArrayList<Integer>();
    for(int i=0;i<=n;i++)
    {
      for(int j = i;j<=n;j++)
      {
          sums.add(F(i)+F(j));
      }
    }
    Integer maxi = Collections.max(sums);
    primes = primeNumbers(maxi);
    int counter = 0;
    Iterator<Integer> it = sums.iterator();
    while(it.hasNext())
    {
      Integer k =it.next();
      if(isPrime(k))
        counter++;
    }
    return counter;
  }
  
  public static void main(String args[])
  {  
    System.out.println( findGroups(3)  );
  }
}
