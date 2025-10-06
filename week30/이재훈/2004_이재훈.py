def count_factor(num, factor):
  count = 0
  while num >= factor:
    count += num // factor
    num //= factor
  return count

n, m = map(int, input().split())

# 2와 5의 개수 구하기
two = count_factor(n, 2) - count_factor(m, 2) - count_factor(n - m, 2)
five = count_factor(n, 5) - count_factor(m, 5) - count_factor(n - m, 5)

print(min(two, five))
