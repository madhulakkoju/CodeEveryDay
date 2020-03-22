import java.util.*;
import java.io.*;
// google kickstart problem
/*
Problem
Dr. Patel has N stacks of plates. Each stack contains K plates. Each plate has a positive beauty value, describing how beautiful it looks.

Dr. Patel would like to take exactly P plates to use for dinner tonight. If he would like to take a plate in a stack, he must also take all of the plates above it in that stack as well.

Help Dr. Patel pick the P plates that would maximize the total sum of beauty values.

Input
The first line of the input gives the number of test cases, T. T test cases follow. Each test case begins with a line containing the three integers N, K and P. Then, N lines follow. The i-th line contains K integers, describing the beauty values of each stack of plates from top to bottom.

Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the maximum total sum of beauty values that Dr. Patel could pick.

Limits
Time limit: 20 seconds per test set.
Memory limit: 1GB.
1 ≤ T ≤ 100.
1 ≤ K ≤ 30.
1 ≤ P ≤ N * K.
The beauty values are between 1 and 100, inclusive.

Test set 1
1 ≤ N ≤ 3.

Test set 2
1 ≤ N ≤ 50.

Sample

Input
 	
Output
 
2
2 4 5
10 10 100 30
80 50 10 50
3 2 3
80 80
15 50
20 10

  
Case #1: 250
Case #2: 180

  
In Sample Case #1, Dr. Patel needs to pick P = 5 plates:

He can pick the top 3 plates from the first stack (10 + 10 + 100 = 120).
He can pick the top 2 plates from the second stack (80 + 50 = 130) .
In total, the sum of beauty values is 250.
In Sample Case #2, Dr. Patel needs to pick P = 3 plates:

He can pick the top 2 plates from the first stack (80 + 80 = 160).
He can pick no plates from the second stack.
He can pick the top plate from the third stack (20).
In total, the sum of beauty values is 180.

*/
public class Main
{
  public static Integer checkBeauty(int score,int cur,int n,int k,int p, ArrayList< ArrayList<Integer>>  plates)
  {
    System.out.println(plates);
    if(p==0 || (plates.get(cur).size() <= 0 ))
        return score ;
    int t = plates.get(cur).get(0);
    plates.get(cur).remove(0);
    TreeSet<Integer> sorted = new TreeSet<Integer>();
    for(int i =0;i< plates.size() ;i++  )
    {
      if(plates.get(i).size() > 0 )
      {
        sorted.add(  checkBeauty(score+t , i,n,k,p-1, new ArrayList< ArrayList<Integer>> (plates) ) );
      }
    }
    if(sorted.size()>0 )
    return sorted.last();
    
    return 0;
  }

   public static Integer checkBeautyScores(int n,int k,int p, ArrayList< ArrayList<Integer>>  plates)
  {
    TreeSet<Integer> sorted = new TreeSet<Integer>();
    ArrayList< ArrayList<Integer>> p2 = new ArrayList< ArrayList<Integer>>();
    for(int i=0;i<plates.size();i++)
    {
      p2.clear();
      for(int jj=0;jj<plates.size();jj++)
      {
      p2.add(new ArrayList<Integer>(plates.get(jj)));
      }
      //p2 = new ArrayList< ArrayList<Integer>>(plates);
      System.out.println("==="+ p2 );
      //sorted.add(checkBeauty(0,i,n,k,p,new ArrayList< ArrayList<Integer>> (plates) ) );
      sorted.add(checkBeauty(0,i,n,k,p,p2 ) );
      System.out.println("===>"+ p2 );
      System.out.println("==>>"+plates);
    }
    return sorted.last();
  
  
  }
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    int testcase = Integer.parseInt(sc.nextLine());
    while(testcase > 0){
    testcase--;
    StringTokenizer stk = new StringTokenizer(sc.nextLine()," ");
    int n = Integer.parseInt(stk.nextToken());
    int k = Integer.parseInt(stk.nextToken());
    int p = Integer.parseInt(stk.nextToken());
    ArrayList< ArrayList<Integer>> plates = new ArrayList< ArrayList<Integer>>();
    for( int i =0; i<n ; i++ )
    {
      plates.add(new ArrayList<Integer>());
      stk = new StringTokenizer(sc.nextLine()," ");
      while(stk.hasMoreTokens())
      {
        plates.get(i).add(Integer.parseInt(stk.nextToken() ) );
      }
      
    }
    System.out.println(plates);
    System.out.println(checkBeautyScores(n,k,p,plates ));
    }
  }
}
/*
  
2
2 4 5
10 10 100 30
80 50 10 50
3 2 3
80 80
15 50
20 10
  
  output ::
  
  250
  180
  */
