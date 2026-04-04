import sys
input = sys.stdin.readline

king, stone, N = input().split()
N = int(N)

dx = {
  "R": (1, 0), "L": (-1, 0), "B": (0, -1), "T": (0, 1),
  "RT": (1, 1), "LT": (-1, 1), "RB": (1, -1), "LB": (-1, -1)
}

kx, ky = ord(king[0]) - ord('A'), int(king[1]) - 1
sx, sy = ord(stone[0]) - ord('A'), int(stone[1]) - 1

for _ in range(N):
  cmd = input().strip()
  dx_, dy_ = dx[cmd]
  
  nkx, nky = kx + dx_, ky + dy_
  
  if not (0 <= nkx < 8 and 0 <= nky < 8):
    continue
  
  if (nkx, nky) == (sx, sy):
    nsx, nsy = sx + dx_, sy + dy_
    if not (0 <= nsx < 8 and 0 <= nsy < 8):
      continue
    sx, sy = nsx, nsy
  
  kx, ky = nkx, nky
print(chr(kx + ord('A')) + str(ky + 1))
print(chr(sx + ord('A')) + str(sy + 1))