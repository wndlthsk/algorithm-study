N = int(input())

freq = {}
for _ in range(N):
  first_name = input()[0]
  freq[first_name] = freq.get(first_name, 0) + 1

res = [k for k, v in freq.items() if v >= 5]

if res:
  print(''.join(sorted(res)))
else:
  print("PREDAJA")