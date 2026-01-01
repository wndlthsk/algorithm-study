S = input()
seq = [-1] * 26
for ch in S:
  idx = ord(ch) - 97
  pos = S.find(ch)
  if pos != -1:
    seq[idx] = pos
print(*seq)