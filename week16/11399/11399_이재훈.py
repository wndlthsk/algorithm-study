N = int(input())

Pi = list(map(int, input().split()))

sorting = sorted(Pi)

acc = 0
res = 0
for x in sorting:
  acc += x
  res += acc
print(res)