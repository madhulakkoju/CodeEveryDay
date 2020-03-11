
/*

If there is nothjing inside the brackets, they are called as Redundant Brackets. 

Return True if there are redundant brackets

(aa+(bb((d))))
True

Assumptio :
The string is Balanced.
*/

import java.util.*;

class ReverseStack
{  
  public static boolean checkRedundancy(String exp)
  {
    ArrayDeque<Character> stack = new ArrayDeque<Character>();
    for(int i=0;i<exp.length();i++)
    {
      if(exp.charAt(i) == '}'||exp.charAt(i) == ')'||exp.charAt(i) == ']')
      {
        if(exp.charAt(i) == ']' && stack.peek()=='[')
            return true;
        if(exp.charAt(i) == '}' && stack.peek()=='{')
            return true;
        if(exp.charAt(i) == ')' && stack.peek()=='(')
            return true;
        else
        {
          char c;
          while(true)
          {
            c= stack.pop();
            if(c == '{'||c == '['||c == '(')
              break;
          }
        }
      }
      else
      {
        stack.push(exp.charAt(i));
      }
      //System.out.println(stack);
    }
    return false;
  }
  public static void main(String args[])
  {  
    Scanner sc = new Scanner(System.in);
    System.out.println(checkRedundancy(sc.nextLine()));
  }
}
