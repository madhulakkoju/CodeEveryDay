maxLen = 1

def subSetCheck(arr,l,k):
    i = 0
    while(i<l):
        j=i+1
        while(j<l):
            if((arr[i]+arr[j])%k == 0):
                return False
            j+= 1
        i+=1
    return True

def createSubset(s,n,k,arr,l,i):
    print(arr)
    #print(arr)
    global maxLen
    if( maxLen < l and subSetCheck(arr,l,k) ):
        print("------------ maxlen here")
        maxLen = l
    j=i 
    while(j<n):
        arr.append(s[j])
        createSubset(s,n,k,arr,l+1,j+1)
        arr.pop(-1)
        j+=1
    pass

def nonDivisibleSubset(k, s):
    n = len(s)
    createSubset(s,n,k,[],0,0)
    return maxLen
  
n,k = map(int,input().split(" "))
s = list(map(int,input().split(" ")))

print(nonDivisibleSubset(k,s))