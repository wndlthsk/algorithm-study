N = int(input())
Ai = list(map(int, input().split()))
Bi = list(map(int, input().split()))

cnt = 0
for a, b in zip(Ai, Bi):
  if a <= b:
    cnt += 1

print(cnt)