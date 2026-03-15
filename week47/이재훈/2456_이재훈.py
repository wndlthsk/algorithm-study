N = int(input())

candidates = [[0] * N for _ in range(3)]
for i in range(N):
  a, b, c = map(int, input().split())
  candidates[0][i] = a
  candidates[1][i] = b
  candidates[2][i] = c

info = []
for i in range(3):
  total = sum(candidates[i])
  cnt3 = candidates[i].count(3)
  cnt2 = candidates[i].count(2)
  info.append((total, cnt3, cnt2, i + 1))

info.sort(reverse=True)

if info[0][:3] == info[1][:3]:
  print(0, info[0][0])
else:
  print(info[0][3], info[0][0])