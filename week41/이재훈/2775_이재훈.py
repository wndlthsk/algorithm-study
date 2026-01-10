T = int(input())
MAX = 15
apt = [[0] * MAX for _ in range(MAX)]
for i in range(1, MAX):
  ho = i - 1
  apt[0][ho] = i

for layer in range(1, MAX):
  for ho in range(1, MAX):
    ho -= 1
    apt[layer][ho] = sum(apt[layer - 1][:ho+1])

for _ in range(T):
  k = int(input())
  n = int(input())
  print(apt[k][n-1])