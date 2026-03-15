S = input()
n = len(S)

s = set()
for length in range(1, n + 1):
  for start in range(n - length + 1):
    s.add(S[start : start+length])
print(len(s))