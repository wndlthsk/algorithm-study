N, K = map(int, input().split())
scores = list(map(int, input().split()))

s = sorted(scores, reverse=True)
print(s[K - 1])