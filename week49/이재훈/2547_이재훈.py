T = int(input())
for _ in range(T):
  line = input()
  N = int(input())
  
  cnt = 0
  for _ in range(N):
    candy = int(input())
    cnt += candy
  
  print('YES' if cnt % N == 0 else 'NO')