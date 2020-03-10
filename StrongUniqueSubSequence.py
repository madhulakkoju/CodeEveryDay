#python 3.7.1
import collections 
s=input()
x=[]
for i in range(0,len(s)):
  for j in range(i,len(s)):
    
      x.append(s[i:j+1])

new=[]
for i in x:
  di = collections.Counter(i)
  ii = 0
  print(di.keys())
  new.append(i)
  for ii in di.values():
    if(ii > 1): 
      new.pop(-1)
      break
  

x.sort()
new.sort()    
print(x)
print(new)
print(new[-1])
    
    
    
