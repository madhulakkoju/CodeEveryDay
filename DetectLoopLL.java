// { Driver Code Starts
// driver code

import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}

class GFG
{
    public static void makeLoop(Node head, Node tail, int x){
        if (x == 0) return;
        
        Node curr = head;
        for(int i=1; i<x; i++)
            curr = curr.next;
        
        tail.next = curr;
    }
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t--> 0)
        {
            int n = sc.nextInt();
            
            int num = sc.nextInt();
            Node head = new Node(num);
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = new Node(num);
                tail = tail.next;
            }
            
            int pos = sc.nextInt();
            makeLoop(head, tail, pos);
            
            Solution x = new Solution();
            if( x.detectLoop(head) )
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}
// } Driver Code Ends


/* Node is defined as

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/


class Solution {
    public static boolean detectLoop(Node head){
        // Add code here
        Node t1 = head;
        Node t2 = head;
        
        while(true)
        {
            t1 = t1.next;
            if(t2.next != null)
                t2 = t2.next.next;
            else
                return false;
            if(t1 == null || t2 == null)
                return false;
            if(t1 == t2)
                return true;
            if(t1 == t2 && t1 == null)
                break;
        }
        return false;
    }
}
