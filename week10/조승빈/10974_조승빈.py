from itertools import permutations
n = int(input())
arr= [i for i in range(1,n+1)]
for per in list(permutations(arr,n)):
    print(*per)
