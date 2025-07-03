N = int(input())

stk = []
for i in range(N):
  book = input()
  stk.append(book)

s = sorted(stk)
idx, cnt = 0, 0
for i, v in enumerate(s):
  value = s.count(v)
  if cnt < value:
    cnt = value
    idx = i
print(s[idx])