N = int(input())

blank = N - 1
for row in range(N):
  star = 2 * row + 1
  print(' ' * blank, '*' * star, sep='')
  blank -= 1

blank = 1
for row in range(N - 2, -1, -1):
  star = 2 * row + 1
  print(' ' * blank, '*' * star, sep='')
  blank += 1