K, L = map(int, input().split())

for i in range(2, int(K ** 0.5) + 1):
  if K % i == 0 and i < L:
    print("BAD", i)
    exit()

print("GOOD")