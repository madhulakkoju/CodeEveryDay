import java.util.*;

class Stack<T extends Number >
{
    LinkedList<T> stk ;
    int counter=0;
    Stack()
    {
        this.stk = new LinkedList<T>();
    } 
    void push(T val)
    {
        this.stk.addFirst(val);
        this.counter ++;
    }
    T pop()
    {
        if(this.counter == 0)
            return null;
        this.counter--;
        return this.stk.removeFirst();
        
    }

    T peek()
    {
        if(this.counter==0)
            return null;
        return this.stk.getFirst();
    }

    boolean isEmpty()
    {
        if(this.counter == 0)
            return true;
        return false;
    }

    void printStack()
    {
        for(T t:this.stk)
        {
            System.out.print(t+" ");
        }
    }
}

class SortStack<T extends Number >
{
    Stack<T> stk1 = new Stack<T>();
    Stack<T> stk2 = new Stack<T>();

    void push(T val)
    {
        if(this.stk1.isEmpty() || this.stk1.peek().longValue() >= val.longValue() )
        {
            this.stk1.push(val);
            return ;
        }
        else
        {
            while( true )
            {
                if(this.stk1.isEmpty()) break;
                if(this.stk1.peek().longValue() < val.longValue())
                    this.stk2.push(this.stk1.pop());
                else break;
            }
            this.stk1.push(val);
            while( !this.stk2.isEmpty())
            {
                this.stk1.push(this.stk2.pop());
            }
        }
    }

    T pop()
    {
        return this.stk1.pop();
    }

    void printStack()
    {
        this.stk1.printStack();
    }
    
    public static void main(String args[])
    {
        SortStack<Integer> stk = new SortStack<Integer>();
        stk.push(10);
        stk.printStack();
        stk.push(1);
        stk.push(1);
        stk.push(1);
        stk.printStack();
        stk.push(6);
        stk.printStack();
        stk.pop();
        stk.push(43);
        stk.printStack();
    }
}