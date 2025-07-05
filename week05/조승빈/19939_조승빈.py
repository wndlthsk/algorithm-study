N, K = map(int, input().split())

min_required = K * (K + 1) // 2

if N < min_required:
    print(-1)
else:
    extra = N - min_required
    min_diff = (K - 1) + (1 if extra % K != 0 else 0)
    print(min_diff)

    