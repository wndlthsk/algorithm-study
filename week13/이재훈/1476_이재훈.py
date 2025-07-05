E, S, M = map(int, input().split())

year = 1
e, s, m = 1, 1, 1  # 시작은 항상 1 1 1

while True:
  if e == E and s == S and m == M:
    break
  
  # 1년 증가
  year += 1

  # 각 수 범위에 맞게 1~15, 1~28, 1~19로 순환
  e += 1
  s += 1
  m += 1

  if e > 15:
    e = 1
  if s > 28:
    s = 1
  if m > 19:
    m = 1
print(year)
