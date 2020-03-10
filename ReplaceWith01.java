import java.util.*;
class ReplaceWith01
{  
  public static void replaceWith01(String str)
  {
    if(str.indexOf("?") == -1 )
    {
      System.out.println(str);
      return;
    }
      
    StringBuffer st = new StringBuffer(str);
    int index = str.indexOf("?");
    replaceWith01(new String(st.replace(index,index+1,"0")));
    replaceWith01(new String(st.replace(index,index+1,"1")));
     return;
  }
  public static void main(String args[])
  {  
    replaceWith01("110?01?1");
  }
}


/*
OUTPUT 


11000101
11000111
11010101
11010111




*/
