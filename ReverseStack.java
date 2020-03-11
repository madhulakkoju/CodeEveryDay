/*
In the question, it was mentioned that the reversal has to be reflected in the same stack which has been taken as argument . So, we could do this way.
We can pop all elements except the last one from stack 1 and push to stack2 and store the last element until the stack1 empties. then push the stored element. to stack 2
This is done iteratively n times. then stack 1 becomes empty.. Then we can pop all from stack2 to stack 1 and return the "stack 1" only.

*/

import java.util.*;

class ReverseStack
{  
  public static ArrayDeque<Integer> reverseStack(ArrayDeque<Integer> stack)
  {
    ArrayDeque<Integer> stackBuf = new ArrayDeque<Integer>();
    
    while(true)
    {
      int i = 0;
      while(stack.size() > 1)
      {
        i++;
        stackBuf.push(stack.pop());
      }
      int valStore = stack.pop();
      while(i>0)
      {
        i--;
        stack.push(stackBuf.pop());
      }
      stackBuf.push(valStore);
      if(stack.size()==0)
        break;
    }
    while(stackBuf.size()>0)
    {
      stack.push(stackBuf.pop());
    }
    return stack;
  }
  public static void main(String args[])
  {  
    ArrayDeque<Integer> stack =  new ArrayDeque<Integer>();
    
    Scanner sc = new Scanner(System.in);
    StringTokenizer buf = new StringTokenizer(sc.nextLine()," ");
    while(buf.hasMoreTokens())
    {
      stack.push(Integer.parseInt(buf.nextToken()));
    }
    System.out.print("Before : "+ stack + "\nAfter : ");
    stack = reverseStack(stack);
    System.out.println(stack);
  }
}

/*

 Output
Before : [6, 5, 4, 3, 2, 1]
After : [1, 2, 3, 4, 5, 6]

*/



