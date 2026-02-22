import sys
input = sys.stdin.readline

N = int(input())
cards = list(map(int, input().split()))
M = int(input())
goals = list(map(int, input().split()))

freq = {}
for card in cards:
  freq[card] = freq.get(card, 0) + 1

res = []
for goal in goals:
  res.append(freq.get(goal, 0))
print(' '.join(map(str, res)))