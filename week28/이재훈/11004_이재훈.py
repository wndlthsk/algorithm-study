N, K = map(int, input().split())
Ai = list(map(int, input().split()))

print(sorted(Ai)[K - 1])