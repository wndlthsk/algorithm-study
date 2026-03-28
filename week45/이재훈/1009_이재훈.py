T = int(input())

d = {
  1: [1],
  2: [2, 4, 8, 6],
  3: [3, 9, 7, 1],
  4: [4, 6],
  5: [5],
  6: [6],
  7: [7, 9, 3, 1],
  8: [8, 4, 2, 6],
  9: [9, 1],
}

for _ in range(T):
  a, b = map(int, input().split())
  before_last_digit = a % 10
  if before_last_digit == 0:
    print(10)
    continue
  
  repeat = len(d[before_last_digit])
  idx = (b - 1) % repeat
  after_last_digit = d[before_last_digit][idx]
  print(after_last_digit)