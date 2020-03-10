#include <stdio.h>
int main()
{
  int n,i,m=0,check=0,s=0,k=0;
  scanf("%d",&n);
  int bar[n];
  for(i=0;i<n;i++)
  scanf("%d",&bar[i]);
  
  for(i=0;i<n;i++)
  {
    if(i<n)
    {
      check=1;
    }
    if(bar[i] <= bar[i+1]&& check==0)
    {
      
      continue;
    }
    else if(bar[i] > bar[i+1] && check ==0)
    {
    
      m=i;
      check=1;
    }
    else if(bar[i] >= bar[m] && check ==1)
    {
      s+=k;
      k=0;
      m=i;
      check=0;
    }
    else if(bar[i] < bar[m] && check==1)
    {
      k+= (bar[m]-bar[i]);
    }
    
  }
check=0;
m=n-1;
k=0;
    for(i=n;i>=0;i--)
  {
    if(i<n)
    {
      check=1;
    }
    if(bar[i] <= bar[i-1] && check ==0)
    {
      continue;
    }
    else if(bar[i] > bar[i-1] && check ==0)
    {
      m=i;
      check=1;
    }
    else if(bar[i] > bar[m] && check ==1)
    {
      s+=k;
      k=0;
      m=i;
      check=0;
    }
    else if(bar[i] < bar[m] && check ==1)
    {
    k+=(bar[m]-bar[i]);
    }
  }
printf("%d",s);
  
  
  return 0;
}
 
