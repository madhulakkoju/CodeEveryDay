def wordbreak(op,i,s,d):
  s1 = s
  if(s1.replace(" ","")== op):
    print(s)
    return
  use=[]
  for x in d:
    if( x in op and x[0]==op[i]   ):
      use.append(x)
  for x in use:
    wordbreak(op,i +len(x),s+x+" ",d)
  return
  
d=["word","b","br","brea","bre","break","bike","this","r","e","a","k","ak","problem"]
d.sort()
wordbreak("wordbreakproblem",0,"",d )







