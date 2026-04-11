n, m = map(int, input().split())
if n - m < m:
  m = n - m

def count_term(base, number):
  cnt = 0
  while base >= number:
    cnt += base // number
    base //= number
  return cnt

two = count_term(n, 2) - count_term(m, 2) - count_term(n - m, 2)
five = count_term(n, 5) - count_term(m, 5) - count_term(n - m, 5)

print(min(two, five))