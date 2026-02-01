numbers = list(map(int, input().split()))

seen = set()
dup = None
for x in numbers:
  if x in seen:
    dup = x
  else:
    seen.add(x)

n = len(seen)
price = 0
if n == 1:
  price = 10_000 + numbers[0] * 1_000
elif n == 2:
  price = 1_000 + dup * 100
else:
  price = max(numbers) * 100
print(price)