N = int(input())
seq = list(map(int, input().split()))
MAX = 1_000

stg = [True] * (MAX + 1)
stg[0] = False
stg[1] = False

for i in range(2, int(MAX ** 0.5) + 1):
  if stg[i]:
    for j in range(i * i, MAX + 1, i):
      stg[j] = False

cnt = 0
for x in seq:
  if stg[x]:
    cnt += 1
print(cnt)