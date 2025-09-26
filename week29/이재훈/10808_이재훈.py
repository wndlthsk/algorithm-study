S = input()

cnt = [0] * 26
for x in S:
  idx = ord(x) - 97
  cnt[idx] = S.count(x)
print(' '.join(map(str, cnt)))
