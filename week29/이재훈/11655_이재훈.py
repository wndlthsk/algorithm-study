S = input()

res = []
for x in S:
  if x.islower():
    res.append(chr((ord(x) - ord('a') + 13) % 26 + ord('a')))
  elif x.isupper():
    res.append(chr((ord(x) - ord('A') + 13) % 26 + ord('A')))
  else:
    res.append(x)
print(''.join(res))