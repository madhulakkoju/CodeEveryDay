import math

t = int(input())
has = 10**9 + 7
while(t > 0):
    t -= 1
    n,x,y = map(int,input().split(" "))
    gc = math.gcd(x,y)
    divisor = gc * (x // gc) * (y // gc)
    highNum = int('9'*n)
    if(n != 1):
        lessNum = int('9'*(n-1))
    else:
        lessNum = 0
    op = (highNum//divisor)%has - (lessNum//divisor)%has 
print(op % has )



