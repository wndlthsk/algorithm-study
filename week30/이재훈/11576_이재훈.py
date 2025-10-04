A, B = map(int, input().split())
m = int(input())
Anums = list(map(int, input().split()))

# 1) A진법 → 10진법
decimal = 0
for num in Anums:
  decimal = decimal * A + num

# 2) 10진법 → B진법
res = []
while decimal > 0:
  decimal, r = divmod(decimal, B)
  res.append(str(r))
print(' '.join(reversed(res)))
