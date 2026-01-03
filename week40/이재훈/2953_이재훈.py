chef = []
for _ in range(5):
  total = sum(map(int, input().split()))
  chef.append(total)

m = max(chef)
idx = chef.index(m)
print(idx + 1, m)