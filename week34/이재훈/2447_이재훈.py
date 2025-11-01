def draw_star(n):
  if n == 1:
    return ['*']

  stars = draw_star(n // 3)
  result = []

  for s in stars:
    result.append(s * 3)                           # 위쪽
  for s in stars:
    result.append(s + ' ' * (n // 3) + s)          # 가운데
  for s in stars:
    result.append(s * 3)                           # 아래쪽

  return result

N = int(input())
print('\n'.join(draw_star(N)))