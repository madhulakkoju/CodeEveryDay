/*

Find the minimum number of groups with a certain sum "" req "" from the given array ""a"".. of size "n"

Input :
{1.01,1.01,3.0,2.7,1.99,2.3,1.7}
 Sum Req = 3
 Output
[[1.01, 1.99], [1.01, 1.7], [3.0], [2.7], [2.3]]
5


*/
import java.util.*;
class MinGroups
{  
  public static int minGroups(int n,double[] a,double req)
  {
    ArrayList<ArrayList<Double>> all =new ArrayList<ArrayList<Double>>();
    
    ArrayList<Double> al;
    Boolean check[] = new Boolean[n];
    
    for(int i=0;i<n;i++)
      check[i] = true;
    
    for(int i = 0;i<n;i++)
    {
      if(!check[i]) continue;
       al = new ArrayList<Double>();
      al.add(a[i]);
      check[i] = false;
      double sum = a[i];
      for(int j = i+1;j<n;j++)
      {
        if(al.indexOf(a[j]) != -1) continue;
        if(!check[j]) continue;
        if((sum + a[j]) > req) continue;
        sum += a[j];
        al.add(a[j]);
        check[j] = false;
      }
      if(al.size()>0) all.add(al);
    }
    System.out.println(all);
    return all.size();
  }
  public static void main(String args[])
  {  
    double a[] = {1.01,1.01,3.0,2.7,1.99,2.3,1.7};
    System.out.println(minGroups(7,a,3));
  }
}
