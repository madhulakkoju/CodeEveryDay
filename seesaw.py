'''
n = int(input())
arr = list(map(int,input().split(" ")))
leftSum = [0]*n
rightSum = [0]*n
leftSum[0] = arr[0]
rightSum[-1] = arr[-1]
for i in range(1,n):
    leftSum[i] = leftSum[i-1] + arr[i]
for i in range(n-2,-1,-1):
    rightSum[i] = rightSum[i+1] + arr[i]
for i in range(1,n-1):
    if(leftSum[i-1]==rightSum[i+1]):
        print(i)
        break
'''
'''
n = int(input())
op=[]
start = ord('a')
for i in range(0,n,2):
    op.append(chr(start+i))
if(n%2 == 0):
    n-=1
else:
    n-=2
for i in range(n,0,-2):
    op.append(chr(i+start))
print(" ".join(op))
'''
'''
s = input().lower().split(" ")
s.sort()
text2 = input().lower().split(" ")
text = []
for i in text2:
    if(i==' 'or i ==''):
        continue
    text.append(i)
n = len(s)
m = len(text)
c = 0
for i in range(0,m-n+1):
    a1 = text[i:i+n]
    a1.sort()
    if(a1 == s):
        c+=1
print(c)

primes=[]
hi = 179
st = 0

def binSearch(a):
    global primes,hi,st 
    i = st
    j=hi
    m = 0
    while(i<=j):
        if(primes[i]==a or primes[j]==a):
            return True 
        m = (i+j)//2
        if(primes[m]==a):
            return True
        if(primes[m] > a):
            j = m-1
        else:
            i = m+1
    return False

def getDivisorsSum(a):
    if(binSearch(a)):
        return False
    s = 1
    r = a**(1/2)
    v = int(r)
    if(r == v):
        s += v
    for i in range(2,v):
        if(a%i == 0):
            s+=i
            s+= a//i
    return s>a

n = int(input())
c=0
for i in range(1,n+1):
    if(getDivisorsSum(i)):
        c+=i 
print(c)
'''
'''
primes=[1, 2,3, 5  , 7   ,  11  ,   13   ,  17   ,  19   ,  23  ,   29 ,
     31  ,   37  ,   41  ,   43  ,   47  ,   53  ,   59  ,   61  ,   67   ,  71 ,
     73   ,  79   ,  83   ,  89   ,  97  ,  101  ,  103  ,  107  ,  109  ,  113 ,
    127  ,  131  ,  137 ,   139   , 149  ,  151   , 157  ,  163  ,  167   , 173 ,
    179  ,  181  ,  191  ,  193  ,  197  ,  199  ,  211  ,  223  ,  227   , 229  ,
    233  ,  239  ,  241  ,  251  ,  257  ,  263  ,  269  ,  271  ,  277  ,  281  ,
    283  ,  293  ,  307  ,  311  ,  313  ,  317  ,  331  ,  337  ,  347  ,  349 ,
    353  ,  359   , 367  ,  373  ,  379  ,  383   , 389  ,  397   , 401  ,  409 ,
    419  ,  421  ,  431  ,  433   , 439  ,  443   , 449   , 457  ,  461  ,  463 ,
    467  ,  479  ,  487  ,  491  ,  499  ,  503  ,  509  ,  521  ,  523  ,  541 ,
    547  ,  557  ,  563  ,  569  ,  571  ,  577  ,  587  ,  593  ,  599  ,  601 ,
    607  ,  613  ,  617  ,  619  ,  631 ,   641  ,  643  ,  647  ,  653  ,  659 ,
    661  ,  673  ,  677  ,  683  ,  691  ,  701  ,  709   , 719   , 727   , 733 ,
    739  ,  743  ,  751  ,  757  ,  761   , 769  ,  773   , 787   , 797   , 809  ,
     811 ,   821  ,  823  ,  827  ,  829  ,  839  ,  853  ,  857  ,  859   , 863 ,
    877  ,  881  ,  883  ,  887  ,  907  ,  911 ,   919  ,  929  ,  937  ,  941 ,
    947  ,  953  ,  967  ,  971  ,  977  ,  983  ,  991  ,  997  , 1009  , 1013 ,
   1019  , 1021 ,  1031 ,  1033 ,  1039  , 1049 ,  1051  , 1061  , 1063  , 1069]
hi = 180
st = 0

def binSearch(a):
    global primes,hi,st 
    i = st
    j= hi
    m = 0
    while(i<=j):
        if(primes[i]==a or primes[j]==a):
            return True 
        m = (i+j)//2
        if(primes[m]==a):
            return True
        if(primes[m] > a):
            j = m-1
        else:
            i = m+1
    return False

def getDivisorsSum(a):
    if(binSearch(a)):
        return False
    #print("not prime",a)
    s = 1
    r = a**(1/2)
    v = int(r)
    i=2
    while(i<=v):
        if(a%i == 0):
            s+=i
            if(i != a//i):
                s+= a//i
        i+= 1
    return s>a

n = int(input())
c=0
i=1
while(i<=n):
    if(getDivisorsSum(i)):
        c+=i
    i+=1
print(c)
'''

'''
from sklearn.neighbors import KNeighborsClassifier
import pandas as pd 
from sklearn.preprocessing import OrdinalEncoder
from sklearn.preprocessing import LabelEncoder

traindata = pd.read_csv("Train_data.csv",header = 0 )
trainop = traindata['accident']
le = LabelEncoder()
le.fit(trainop)
trainop_Enc = le.transform(trainop)

traindata = traindata.drop(['accident','gender','Unnamed: 0'],axis = 1)
traindata = traindata.astype(str)

oe = OrdinalEncoder()
oe.fit(traindata)
traindata_Enc = oe.transform(traindata)

classifier = KNeighborsClassifier(n_neighbors = 10) 
classifier.fit(traindata_Enc,trainop)

testdata = pd.read_csv("Test_Data.csv",header = 0 )

testdata = testdata.astype(str)

testdata = testdata.drop(['Unnamed: 0','gender'],axis = 1)

oe = OrdinalEncoder()
oe.fit(testdata)
testdata = oe.transform(testdata)

prediction = list(classifier.predict(testdata))
pred = []
for i in prediction :
    pred.append([i])    

file = open('op.csv', 'w+', newline ='') 
import csv
# writing the data into the file 
with file:     
    write = csv.writer(file) 
    write.writerows(pred) 

'''


#code

t = int(input())
maxb = 0
listA = []
listB = []
tt= t
while(tt>0):
    tt-=1
    a,b = map(int,input().split(' '))
    maxb = max(maxb,b)
    listA.append(a)
    listB.append(b)
    pass

def getPrimes(n):
    primes = []
    #primes.extend(range(n+1))
    checks = [True]*(n+1)
    checks[0] = False
    checks[1] = False
    i=2
    while(i<=n):
        if(checks[i]):
            primes.append(i)
            j=i+i
            while(j<=n):
                checks[j] = False
                j += i
        i+=1
    return (primes,checks)

def sexyprime(l, r) : 
      
    # Sieve Of Eratosthenes 
    # for generating 
    # prime number. 
    prime=[True] * (r + 1) 
      
    p = 2
      
    while(p * p <= r) : 
          
        # If prime[p] is not changed,  
        # then it is a prime 
        if (prime[p] == True) : 
              
            # Update all multiples of p 
            for i in range( p * 2, r+1 ,p) : 
                   prime[i] = False
          
        p = p + 1
          
    # From L to R - 6, checking if i, 
    # i + 6 are prime or not. 
    for i in range( l,r - 6 + 1) : 
          
        if (prime[i] and prime[i + 6]) : 
            print("(", i , ",", i + 6,")", end="") 
              

def printSexyPrimes(primes,checks,a,b):
    while(a<=b):
        if(checks[a]):
            if(a+6 <= b and checks[a+6]):
                print(a,a+6,end=" ")
        a+=1
    pass

primes,checks = getPrimes(maxb)
ii=0
while(ii<t):
    
    printSexyPrimes(primes,checks,listA[ii],listB[ii])
    print(listA[ii],"======",listB[ii])
    sexyprime(listA[ii],listB[ii])
    print()
    ii+=1    
    
    



