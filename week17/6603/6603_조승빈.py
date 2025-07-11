from itertools import combinations
while True:
    arr = list(map(int,input().split(" ")))
    if arr[0]==0:
        break
    num_len = arr.pop(0)
    ans = list(combinations(arr,6))
    for an in ans:
        for a in an:
            print(a,end=" ")
        print()
    print()

            