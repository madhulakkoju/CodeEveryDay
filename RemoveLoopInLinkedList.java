// { Driver Code Starts
// driver code

import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
}

class GFG
{
    public static Node newNode(int data){
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        return temp;
    }
    
    public static void makeLoop(Node head, int x){
        if (x == 0)
            return;
        Node curr = head;
        Node last = head;

        int currentPosition = 1;
        while (currentPosition < x)
        {
            curr = curr.next;
            currentPosition++;
        }
        
        while (last.next != null)
            last = last.next;
        last.next = curr;
    }
    
    public static boolean detectLoop(Node head){
        Node hare = head.next;
        Node tortoise = head;
        while( hare != tortoise )
        {
            if(hare==null || hare.next==null) return false;
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return true;
    }
    
    public static int length(Node head){
        int ret=0;
        while(head!=null)
        {
            ret += 1;
            head = head.next;
        }
        return ret;
    }
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t--> 0)
        {
            int n = sc.nextInt();
            
            int num = sc.nextInt();
            Node head = newNode(num);
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = newNode(num);
                tail = tail.next;
            }
            
            int pos = sc.nextInt();
            makeLoop(head, pos);
            
            solver x = new solver();
            x.removeLoop(head);
            
            if( detectLoop(head) || length(head)!=n )
                System.out.println("0");
            else
                System.out.println("1");
        }
    }
}
// } Driver Code Ends


/*
class Node
{
    int data;
    Node next;
}
*/

class solver
{
     public static Node detectLoop(Node head){
        // Add code here
        Node t1 = head;
        Node t2 = head;
        
        while(true)
        {
            t1 = t1.next;
            if(t2.next != null)
                t2 = t2.next.next;
            else
                return null;
            if(t1 == null || t2 == null)
                return null;
            if(t1 == t2)
                return t1;
            if(t1 == t2 && t1 == null)
                break;
        }
        return null;
    }
    
    public static void removeLoop(Node head){
        // code here
        // remove the loop without losing any nodes
        Node x = detectLoop(head);
        if(x == null)
            return;
        Node temp = x;
        int len= 1;
        while(temp.next != x)
        {
            len+=1;
            temp = temp.next;
        }
        temp = head;
        
        while(len > 0)
        {
            temp = temp.next;
            len --;
        }
        x = head;
        while(temp != x)
        {
            temp = temp.next;
            x = x.next;
        }
        while(temp.next != x)
        {
            temp = temp.next;
        }
        temp.next = null;
        return;
    }
}
