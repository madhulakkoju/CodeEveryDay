/*
Print all possible coin change with given coins
*/
import java.util.*;
import java.io.*;

public class CoinChangeProblem
{
  public static HashSet<ArrayList<Integer>> all = new HashSet<ArrayList<Integer>>();
  public static Integer CoinSet[];
  public static void generate(int n,ArrayList<Integer> coins )
  {
    if(n == 0)
    {
      ArrayList<Integer> test = new ArrayList<Integer>(coins);
      Collections.sort(test);
      all.add(test);
      //System.out.println(test);
      return;
    }
    if(n<0)
    return;
    for(int i=0;i<CoinSet.length;i++)
    {
      coins.add( CoinSet[i] );
      generate(n-CoinSet[i] , coins );
      coins.remove(CoinSet[i]);
    }
    
    return;
  }
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		CoinSet= new Integer[Integer.parseInt(sc.nextLine())]; // length
		
		int i = 0;
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		while(st.hasMoreTokens())
		{
		  CoinSet[i++] = Integer.parseInt(st.nextToken());
		}
		
		generate(Integer.parseInt(sc.nextLine()),new ArrayList<Integer>());
		System.out.println(all);
	}
}
