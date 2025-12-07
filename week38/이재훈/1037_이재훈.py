N = int(input())
el = sorted(map(int, input().split()))

if len(el) == 1:
  print(el[0] ** 2)
else:
  print(el[0] * el[-1])