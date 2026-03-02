N = int(input())
card_numbers = list(map(int, input().split()))
M = int(input())
queries = list(map(int, input().split()))

freq = {}
for x in card_numbers:
  freq[x] = freq.get(x, 0) + 1

res = []
for num in queries:
  f = freq.get(num, 0)
  res.append(f)
print(*res)