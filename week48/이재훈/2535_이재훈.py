import sys
input = sys.stdin.readline

N = int(input())
students = [tuple(map(int, input().split())) for _ in range(N)]

students.sort(key=lambda x: -x[2])

country_cnt = {}
result = []
for c, s, score in students:
  if country_cnt.get(c, 0) < 2:
    result.append((c, s))
    country_cnt[c] = country_cnt.get(c, 0) + 1
  if len(result) == 3:
    break

for c, s in result:
  print(c, s)