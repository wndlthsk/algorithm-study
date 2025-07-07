import sys
input = sys.stdin.readline

N = int(input())

except_grade = [int(input()) for _ in range(N)]

lst = sorted(except_grade)

res = 0
for i in range(N):
  res += abs(lst[i] - (i + 1))
print(res)