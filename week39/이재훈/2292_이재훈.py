N = int(input())

cur = 1      # 현재 껍질의 최대 값
cnt = 1      # 껍질 번호
while True:
  if N <= cur:
    print(cnt)
    break
  
  cur += 6 * cnt
  cnt += 1