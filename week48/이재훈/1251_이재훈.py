import sys
input = sys.stdin.readline

word = input().strip()
n = len(word)

res = []
for i in range(1, n - 1):
  for j in range(i + 1, n):
    a = word[:i][::-1]
    b = word[i:j][::-1]
    c = word[j:][::-1]
    res.append(a + b + c)
print(min(res))