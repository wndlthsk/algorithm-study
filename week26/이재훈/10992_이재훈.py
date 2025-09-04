N = int(input())

for i in range(1, N):
  print(' ' * (N - i), end='')
  if i >= 2:
    print('*', end='')
    print(' ' * (2 * (i - 1) - 1), end='')
    print('*')
  else:
    print('*')
print('*' * (2 * N - 1))