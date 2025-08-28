N = int(input())
words = [list(input()) for _ in range(N)]

d = {}

for word in words:
  weight = 1
  for w in reversed(word):
    if w not in d:
      d[w] = 1 * weight
    else:
      d[w] += (1 * weight)
    weight *= 10

srt_d = sorted(d.items(), key=lambda x: x[1], reverse=True)

res = 0
num = 9
for _, val in srt_d:
  res += num * val
  num -= 1
print(res)