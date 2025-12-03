n = int(input())

logs = {}
for _ in range(n):
  name, entry = input().split()
  logs[name] = entry

res = []
for name, entry in logs.items():
  if entry == "enter":
    res.append(name)

res.sort(reverse=True)
print("\n".join(res))