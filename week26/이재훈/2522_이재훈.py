N = int(input())
for i in range(1, ((2*N)-1) + 1):
  if i <= N:
    print(' ' * abs(N - i), end='')
    print('*' * i)
  else:
    print(' ' * abs(N - i), end='')
    print('*' * (2 * N - i))