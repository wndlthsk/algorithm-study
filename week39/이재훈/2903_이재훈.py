N = int(input())

side = 2  # 한 변의 점 개수 (1단계)
for _ in range(N - 1):
  side = side * 2 - 1

print(side ** 2)
