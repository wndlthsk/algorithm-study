S = input()
n = len(S)

s = set()
for length in range(1, n + 1):
  for idx in range(n - length + 1):
    s.add(S[idx:idx + length])
print(len(s))