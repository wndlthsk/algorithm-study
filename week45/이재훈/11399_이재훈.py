N = int(input())
Pi = list(map(int, input().split()))

acc = 0
res = 0
for x in sorted(Pi):
  acc += x
  res += acc
print(res)