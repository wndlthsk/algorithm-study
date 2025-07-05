import sys
from itertools import combinations

n = int(sys.stdin.readline())
s = []
for _ in range(n):
    s.append(list(map(int, sys.stdin.readline().split())))
people = [i for i in range(n)]

minimum = float('inf')
for i in range(1, n//2 + 1):
    for team1 in (combinations(people, i)):
        team2 = tuple(p for p in people if p not in team1)

        score_1, score_2 = 0, 0
        for a in range(len(team1)):
            for b in range(a+1, len(team1)):
                score_1 += s[team1[a]][team1[b]] + s[team1[b]][team1[a]]

        for a in range(len(team2)):
            for b in range(a+1, len(team2)):
                score_2 += s[team2[a]][team2[b]] + s[team2[b]][team2[a]]

        minimum = min(minimum, abs(score_1 - score_2))
print(minimum)