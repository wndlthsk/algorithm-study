N = int(input())

curr = N
cnt = 0

while True:
  a = curr // 10      # 십의 자리
  b = curr % 10       # 일의 자리
  curr = b * 10 + ((a + b) % 10)  # 새 숫자 생성
  cnt += 1
  
  if curr == N:       # 원래 수로 돌아오면 종료
    break

print(cnt)