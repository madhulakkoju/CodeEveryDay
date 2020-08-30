import numpy as np
n = int(input())

arr = np.zeros(n)
for i in range(n):
    a = input()
    ind = -1
    for j in range(0,n):
        if(a[j]=='R'):
            ind = j 
    arr[i] = ind
swaps = 0
#print(arr)
for i in range(0,n):
    if(arr[i] <= i):
        continue
    j = i+1
    while(j < n):
        if(arr[j] <= i):
            break
        j+=1
    if(j==n):
        swaps = -1
        break
    else:
        val = arr[j]
        while(j>i):
            arr[j]=arr[j-1]
            j-=1
            swaps += 1
        arr[i] = val
print(swaps)
