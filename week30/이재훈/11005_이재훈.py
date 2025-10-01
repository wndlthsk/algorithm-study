N, B = map(int, input().split())

p = 1
while B ** p <= N:
  p += 1

res = []
for i in range(p - 1, -1, -1):  # (p-1)자리부터 0자리까지
  cnt = N // (B ** i)       # 현재 자리의 값
  N %= B ** i               # 남은 값 갱신
  res.append(cnt)

r = [chr(55 + x) if x >= 10 else x for x in res]
print(*r, sep='')