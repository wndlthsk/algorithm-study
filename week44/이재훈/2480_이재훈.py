numbers = list(map(int, input().split()))

is_same_triple = numbers[0] == numbers[1] and numbers[1] == numbers[2]
is_same_double = numbers[0] == numbers[1] or numbers[1] == numbers[2] or numbers[0] == numbers[2]

res = 0
if is_same_triple:
  res = 10_000 + numbers[0] * 1_000
elif is_same_double:
  l = sorted(numbers)
  res = 1_000 + l[1] * 100
else:
  res = max(numbers) * 100
print(res)