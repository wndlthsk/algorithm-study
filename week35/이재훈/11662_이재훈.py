ax, ay, bx, by, cx, cy, dx, dy = map(int, input().split())

ix, iy = bx - ax, by - ay
jx, jy = dx - cx, dy - cy

# 두 점 사이 거리 제곱
def dist2(t):
  px = ax + ix * t
  py = ay + iy * t
  qx = cx + jx * t
  qy = cy + jy * t
  
  return (px - qx) ** 2 + (py - qy) ** 2

# 삼분 탐색
l, r = 0.0, 1.0
for _ in range(100):   # 충분히 수렴
  t1 = (2*l + r) / 3
  t2 = (l + 2*r) / 3
  if dist2(t1) < dist2(t2):
    r = t2
  else:
    l = t1

print(dist2((l + r) / 2) ** 0.5)