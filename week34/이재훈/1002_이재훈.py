import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
  x1, y1, r1, x2, y2, r2 = map(int, input().split())

  dx = x1 - x2
  dy = y1 - y2
  dist2 = dx ** 2 + dy **2          # 중심 거리의 제곱
  
  sumR = r1 + r2
  diffR = abs(r1 - r2)
  sumR2 = sumR ** 2
  diffR2 = diffR ** 2

  if dist2 == 0 and r1 == r2:
    print(-1)
  elif diffR2 < dist2 < sumR2:
    print(2)
  elif dist2 == sumR2 or dist2 == diffR2:
    print(1)
  else:
    print(0)