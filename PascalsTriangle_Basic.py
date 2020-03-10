def pascal(n):
  if(n==0):
    return [1]
  a= pascal(n-1)
  b=[1]
  for i in range(0,n-1):
    b.append(a[i]+ a[i+1])
  b.append(a[-1])
  #print(b)
  return b
  
  
print(pascal(int(input())))
