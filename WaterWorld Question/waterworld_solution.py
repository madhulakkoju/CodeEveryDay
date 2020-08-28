import numpy as np
n = int(input())
c = int(input())

links = np.zeros(c)
capacities = np.zeros(c)
usages = np.zeros(c)

for i in range(c):
    a = input().split(" ")
    
    usages[i] = int(a[1])
    capacities[i] = int(a[2])

l = int(input())

for i in range(l):
    a = input().split("_")
    if(a[0] == 'F'):
        links[int(a[1][1:]) - 1] = -1
    else:
        links[int(a[1][1:]) - 1] = int(a[0][1:]) - 1
    #print(links)

totalWater = 0

currentWater = np.zeros(c)

def fillTank(j):
    j = int(j)
    if(j==-1):
        return 0
    global currentWater,links,capacities
    if(links[j] == -1):
        currentWater[j] = capacities[j]
        return currentWater[j]
    currentWater[j] = capacities[j] 
    return capacities[j] + fillTank(links[j])

for i in range(c):
    currentWater[i] = capacities[i] - usages[i]
    totalWater += capacities[i] 

for i in range(1,n):
    for j in range(c-1,-1,-1):
        if(currentWater[j] < usages[j]):
            totalWater += fillTank(j)
    for j in range(0,c):
        currentWater[j] -= usages[j]

print(int(totalWater))

'''
Input 

3
4
c1 100 300
c2 100 300
c3 100 200
c4 100 400
4
F_c1
[-1.  0.  0.  0.]
F_c2
[-1. -1.  0.  0.]
C2_c3
[-1. -1.  1.  0.]
c3_c4
[-1. -1.  1.  2.]

Output

1700.0


'''