max_people = 0
current = 0

for _ in range(4):
  out_people, in_people = map(int, input().split())
  current -= out_people
  current += in_people
  max_people = max(max_people, current)

print(max_people)