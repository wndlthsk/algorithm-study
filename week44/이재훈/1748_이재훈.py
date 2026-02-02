N = int(input())

n = len(str(N))

base = 0
for i in range(1, n):
  base += i * (9 * (10 ** (i - 1)))

digit = N - 10 ** (n - 1)

total = base + (digit + 1) * n
print(total)