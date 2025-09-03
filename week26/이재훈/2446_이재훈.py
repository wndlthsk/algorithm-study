N = int(input())
for i in range(1, N + 1):
  print(' ' * (i - 1), end='')
  print('*' * ((2 * N) - (2 * (i - 1)) - 1))
for i in range(N + 1, (2 * N - 1) + 1):
  print(' ' * (2 * N - i - 1), end='')
  print('*' * (2 * (i - N) + 1))