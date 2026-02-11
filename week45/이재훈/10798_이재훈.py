import sys

words = []
for line in sys.stdin:
  words.append(list(line.strip()))

max_len = max(len(w) for w in words)
res = []
for i in range(max_len):          # 열 기준
  for j in range(len(words)):     # 행 순회
    if i < len(words[j]):         # 해당 열이 존재하면
      res.append(words[j][i])
print(''.join(res))