scores = [list(map(int, input().split())) for _ in range(5)]
s = [sum(row) for row in scores]
best = max(s)
number = s.index(best) + 1

print(number, best)
