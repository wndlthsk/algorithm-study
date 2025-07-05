import sys

n = int(sys.stdin.readline())
entrance = {}
for i in range(n):
    car = sys.stdin.readline().strip()
    entrance[car] = i

exit_order = []
for i in range(n):
    car = sys.stdin.readline().strip()
    exit_order.append(entrance[car])

# print(entrance)
# print(exit_order)

count = 0
for i in range(n):
    for j in range(i+1, n):
        if exit_order[i] > exit_order[j]:
            count += 1
            break
print(count)