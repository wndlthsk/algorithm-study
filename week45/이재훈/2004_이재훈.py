import sys
input = sys.stdin.readline

n, m = map(int, input().split())

def count_five(x):
  cnt = 0
  while x > 0:
    x //= 5
    cnt += x
  return cnt

def count_two(x):
  cnt = 0
  while x > 0:
    x //= 2
    cnt += x
  return cnt

# n! 안의 5 개수
five_n = count_five(n)
# m! 안의 5 개수
five_m = count_five(m)
# (n-m)! 안의 5 개수
five_nm = count_five(n - m)

# 조합에서의 5 개수
five_cnt = five_n - five_m - five_nm

two_n = count_two(n)
two_m = count_two(m)
two_nm = count_two(n - m)

two_cnt = two_n - two_m - two_nm

print(min(two_cnt, five_cnt))