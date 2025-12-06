N, M = map(int, input().split())

no_listen = set(input() for _ in range(N))
no_see = set(input() for _ in range(M))

double = no_listen & no_see
print(len(double))
print('\n'.join(sorted(double)))