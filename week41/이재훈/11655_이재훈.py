line = list(input())

res = []
for ch in line:
  if ch.isalpha():
    if ch.isupper():
      idx = (ord(ch) - ord('A') + 13) % 26
      ch = chr(ord('A') + idx)
    else:
      idx = (ord(ch) - ord('a') + 13) % 26
      ch = chr(ord('a') + idx)
  res.append(ch)
print(''.join(res))