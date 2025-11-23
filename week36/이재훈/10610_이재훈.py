N = input()
digits = list(map(int, N))

# 조건1: 0이 존재해야 한다 → 10의 배수
if 0 not in digits:
  print(-1)
  exit()

# 조건2: 자리수 합이 3으로 나누어 떨어져야 한다
if sum(digits) % 3 != 0:
  print(-1)
  exit()

# 가능하면 가장 큰 수 만들어 출력
digits.sort(reverse=True)
print(''.join(map(str, digits)))