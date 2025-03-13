d,k = map(int,input().split(" "))
a,b = 1,1
for _ in range(4,d+1):
    a,b=b,a+b
for i in range(1,k//a+1):
    if (k-a*i)%b==0:
        print(i)
        print((k-a*i)/b)
        break
