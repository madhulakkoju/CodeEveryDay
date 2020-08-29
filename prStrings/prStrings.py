
t = int(input())
while(t > 0):
    t -= 1
    s = input()
    x,y = map(int,input().split(" "))
    # x = remove pr
    # y = remove rp
    val = 0
    if( x > y ):
        print("pr > rp")
        while(True):
            prev = len(s)
            s = s.replace('pr','')
            cur = len(s)
            if(prev == cur):
                break
            val += ((prev - cur)//2)* x 
        while(True):
            prev = len(s)
            s = s.replace('rp','')
            cur = len(s)
            if(prev == cur):
                break
            val += ((prev - cur)//2)* y 
    else :
        print("else")
        while(True):
            prev = len(s)
            s = s.replace('rp','')
            cur = len(s)
            if(prev == cur):
                break
            val += ((prev - cur)//2)*y  
        while(True):
            prev = len(s)
            s = s.replace('pr','')
            cur = len(s)
            if(prev == cur):
                break
            val += ((prev - cur)//2)* x 
    print(val)