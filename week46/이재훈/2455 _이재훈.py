max_p = float('-inf')
people = 0
for _ in range(4):
  out, ride = map(int, input().split())
  people -= out
  people += ride
  
  if max_p < people:
    max_p = people
print(max_p)