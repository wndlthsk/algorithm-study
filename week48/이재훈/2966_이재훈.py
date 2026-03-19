n = int(input())
answers = input().strip()

patterns = {
  "Adrian": "ABC",
  "Bruno": "BABC",
  "Goran": "CCAABB"
}

scores = {name: 0 for name in patterns}

for i in range(n):
  for name, pattern in patterns.items():
    if answers[i] == pattern[i % len(pattern)]:
      scores[name] += 1

max_score = max(scores.values())

print(max_score)
for name in sorted(scores):
  if scores[name] == max_score:
    print(name)