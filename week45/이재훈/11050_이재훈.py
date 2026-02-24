N, K = map(int, input().split())

total_top = 1
for i in range(K):
  total_top *= N - i

total_bottom = 1
for i in range(1, K + 1):
  total_bottom *= i

print(total_top // total_bottom)