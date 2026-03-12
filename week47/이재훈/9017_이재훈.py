import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
  N = int(input())
  arr = list(map(int, input().split()))

  team_cnt = {}
  for x in arr:
    team_cnt[x] = team_cnt.get(x, 0) + 1

  valid = {team for team, c in team_cnt.items() if c == 6}

  scores = {}
  fifth = {}
  rank = 1
  for team in arr:
    if team not in valid:
      continue

    if team not in scores:
      scores[team] = []
    scores[team].append(rank)

    if len(scores[team]) == 5:
      fifth[team] = rank

    rank += 1

  result = []
  for team in scores:
    score_sum = sum(scores[team][:4])
    result.append((score_sum, fifth[team], team))

  print(sorted(result)[0][2])