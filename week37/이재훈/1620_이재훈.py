import sys
input = sys.stdin.readline

N, M = map(int, input().split())

num_to_name = {}
name_to_num = {}

for i in range(1, N + 1):
  name = input().strip()
  num_to_name[i] = name
  name_to_num[name] = i

for _ in range(M):
  q = input().strip()
  if q.isdigit():
    print(num_to_name[int(q)])
  else:
    print(name_to_num[q])