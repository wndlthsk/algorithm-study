N = int(input())

grade = []
for _ in range(N):
  name, k, e, m = input().split()
  korean, english, math = map(int, (k, e, m))
  grade.append([name, korean, english, math])

srt = sorted(grade, key=lambda row: (-row[1], row[2], -row[3], row[0]))

for r in srt:
  print(r[0])