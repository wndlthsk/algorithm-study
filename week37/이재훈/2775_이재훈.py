T = int(input())

for _ in range(T):
  k = int(input())
  n = int(input())
  
  # (k층, n호)를 표현할 2차원 DP 테이블
  apt = [[0] * (n + 1) for _ in range(k + 1)]
  
  # 0층 초기화: 0층 i호 = i
  for i in range(1, n + 1):
    apt[0][i] = i
  
  for floor in range(1, k + 1):      # 1층부터 k층까지
    for room in range(1, n + 1):   # 1호부터 n호까지
      apt[floor][room] = apt[floor][room - 1] + apt[floor - 1][room]
  print(apt[k][n])