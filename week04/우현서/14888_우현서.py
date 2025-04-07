import sys
from itertools import permutations

n = int(sys.stdin.readline())
a = list(map(int, sys.stdin.readline().split()))
operators = list(map(int, sys.stdin.readline().split()))

op = ['+', '-', '*', '/']
ops = []
for i in range(4):
    ops.extend([op[i]] * operators[i])

permutes = set(permutations(ops))

max_result = float('-inf')
min_result = float('inf')

for p in permutes:
    result = a[0]
    for i in range(n-1):
        if p[i] == '+':
            result += a[i+1]
        elif p[i] == '-':
            result -= a[i+1]
        elif p[i] == '*':
            result *= a[i+1]
        elif p[i] == '/':
            if result < 0:
                result = -(-result // a[i+1])
            else:
                result //= a[i+1]
    max_result = max(max_result, result)
    min_result = min(min_result, result)

print(max_result)
print(min_result)