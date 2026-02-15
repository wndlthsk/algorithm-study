N = int(input())

total = 0
s = set()
for _ in range(N):
  record = input()
  
  if record == "ENTER":
    total += len(s)
    s.clear()
  elif record != "ENTER":
    s.add(record)
print(total + len(s))