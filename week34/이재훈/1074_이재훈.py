N, r, c = map(int, input().split())

def recursion(n, r, c):
  # 더 이상 나눌 수 없는 2×2 칸일 때
  if n == 0:
    return 0

  size = 2 ** (n - 1)  # 한 변 길이의 절반
  # 한 사분면의 칸 수
  area = size * size

  # (r, c)가 속한 사분면 찾기
  if r < size and c < size:           # 1사분면 (왼쪽 위)
    return recursion(n - 1, r, c)
  elif r < size and c >= size:        # 2사분면 (오른쪽 위)
    return area + recursion(n - 1, r, c - size)
  elif r >= size and c < size:        # 3사분면 (왼쪽 아래)
    return 2 * area + recursion(n - 1, r - size, c)
  else:                               # 4사분면 (오른쪽 아래)
    return 3 * area + recursion(n - 1, r - size, c - size)

print(recursion(N, r, c))