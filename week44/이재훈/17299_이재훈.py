from collections import Counter
import sys
input = sys.stdin.readline

n = int(input())
lst = list(map(int, input().split()))

freq = Counter(lst)
stk = []
res = [-1] * n
for i in range(n - 1, -1, -1):
  current = lst[i]
  while stk and freq[stk[-1]] <= freq[current]:
    stk.pop()
  if stk:
    res[i] = stk[-1]
  stk.append(current)
print(' '.join(map(str, res)))