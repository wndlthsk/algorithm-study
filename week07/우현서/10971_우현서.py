import sys
from itertools import permutations

n = int(sys.stdin.readline())
w = []
for _ in range(n):
    w.append(list(map(int, sys.stdin.readline().split())))

result = float('inf')

for i in permutations(range(1, n)):
    path = (0, ) + i
    count = 0
    check = 0
    # print(i)
    for j in range(n):
        tj = (j+1) % n
        if w[path[j]][path[tj]] == 0:
            check = 1
            break
        count += w[path[j]][path[tj]]

    # if count < result:
    #     print(i, count)
    #     result = count
    if check == 0:
        result = min(result, count)
print(result)
