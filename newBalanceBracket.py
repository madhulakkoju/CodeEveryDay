'''
# Sample code to perform I/O:

name = input()                  # Reading input from STDIN
print('Hi, %s.' % name)         # Writing output to STDOUT

# Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
'''

# Write your code here

def balanceString(s):
    
    #s=s.replace('{}}',"")
    stkcnt=0
    op=0

    n = len(s)
    i=0
    while(i<n):
        if(s[i]=='{'):
            if(s[i:i+3]=='{}}'): #{}}
                i+=3
            elif(i<n-1 and s[i+1]=='}'): #{}
                i+=2
                op+=1
            else: #{...}} case
                stkcnt += 1
                i+=1
        else:
            if(s[i:i+2]=='}}' and stkcnt > 0 ):# {..}} case end
                stkcnt-=1
                i+=2
            elif(s[i:i+2]=='}}' and stkcnt == 0 ): #..}} case add { before
                op+=1
                i+=2
            else: # {..} case add }
                if(stkcnt>0):
                    op+=1
                    stkcnt-=1
                elif(stkcnt == 0):
                    op+=2 # add both { and }
                i+=1
    return op + stkcnt * 2
                

    '''
    for i in s:
        if(i=='{'):
            if(stkcnt >= 2):
                if(stk[-1]==):
                    pass
            stk.append(i)
        else:
            if(stk[-1]=='}' and stk[-2]=='{'):
                stk.pop(-1)
                stk.pop(-1)
            if(stk[-1]=='{'):
                stk.append(i)
    pass
    '''

t = int(input())
while(t > 0):
    t-=1
    s = input()
    print(balanceString(s))
