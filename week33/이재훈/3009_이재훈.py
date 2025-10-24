a = list(map(int, input().split()))
b = list(map(int, input().split()))
c = list(map(int, input().split()))

xs = [a[0], b[0], c[0]]
ys = [a[1], b[1], c[1]]

x4, y4 = 0, 0
for x in xs:
  if xs.count(x) == 1:
    x4 = x
for y in ys:
  if ys.count(y) == 1:
    y4 = y

print(x4, y4)