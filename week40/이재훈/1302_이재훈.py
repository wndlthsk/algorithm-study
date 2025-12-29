N = int(input())
books = {}

for _ in range(N):
  book = input()
  if book not in books:
    books[book] = 1
  else:
    books[book] += 1

cnt = 0
res = []
for k, v in books.items():
  if v > cnt:
    cnt = v
    res = [k]
  elif v == cnt:
    res.append(k)

print(sorted(res)[0])
