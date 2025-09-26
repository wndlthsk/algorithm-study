S = input()

seq = [-1] * 26
for i, x in enumerate(S):
  p = ord(x) - 97
  if seq[p] != -1:
    continue
  seq[p] = i
print(*seq)