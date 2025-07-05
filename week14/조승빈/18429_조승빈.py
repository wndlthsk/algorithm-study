from itertools import permutations
n,m = map(int,input().split(" "))
arr = list(map(int,input().split(" ")))
ans = 0
for  permu in list(permutations(arr,n)):
    flag = 0
    for p in permu:
        flag+=(p-m)
        if flag < 0:
            break
    if flag >=0 :
        ans+=1
print(ans)
