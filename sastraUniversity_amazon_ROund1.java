/*
public LNode mergeLists(LNode head1,LNode head2)
{

    LNode temp1=null,temp2=null;

    LNode head=new LNode(-1);
    temp1 = head;
    int val=0;
    int d=0;
    while(head1!=null || head2 != null)
    {
        d=-1          // -----------------------------------------------------check here
        if(head1 != null )
        {
            val = head1.val;
            
            d=1;
        }
        if(head2 != null)
        {
            if(d==-1 || val > head2.val) // ---------------------------- here
            {
                val = head2.val;
                d=2;
            }
        }

        if(d == 1)
        {
            temp1.next = head1;
            head1 = head1.next;
        }
        else if(d==2) //  // ---------------------------- here
        {
            temp1.next = head2;
            head2 = head2.next;
        }
        else  // ---------------------------- here
        break;  // ---------------------------- here
        temp1 = temp1.next;  // ---------------------------- here
        
    }
    temp1.next = null;


    return head.next;
}
*/



class Solution 
{

void dfs(int start,boolean[] visited,boolean[][] graph,int n)
{
    visited[start] = true;
    for(int i=1;i<=n;i++)
    {
        if(graph[start][i] && !visited[i])
        {
            dfs(i,visited,graph);
        }
    }
}


List<PairInt> criticalConnections(int numOfWarehouses,int numofRoads,List<PairInt> roads)
{

    boolean graph[] = new boolean[numOfWarehouses+1][numOfWarehouses+1];
    ListIterator<PairInt> it = roads.listIterator();
    PairInt buf;
    while(it.hasNext())
    {
        buf = it.next();
        graph[buf.first][buf.second] = true;
        graph[buf.second][buf.first] = true;
    }

    boolean visited[] = new boolean[numOfWarehouses+1];
    
    List<PairInt> op = new ArrayList<PairInt>();
    
    it = roads.listIterator();
    

    while(it.hasNext())
    {
        buf = it.next();
        graph[buf.first][buf.second] = false;
        graph[buf.second][buf.first] = false;



        dfs(1,visited,graph,numOfWarehouses);

        
        graph[buf.first][buf.second] = true;
        graph[buf.second][buf.first] = true;
        boolean bv=true;
        for(int i=1;i<=numOfWarehouses;i++)
        {
            bv = bv && visited[i];
            if(!bv)
            {
                op.add(buf);
            }
        }
    }
    return op;

}
}