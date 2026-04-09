import sys
input = sys.stdin.readline

T = int(input())

patterns = ["TTT", "TTH", "THT", "THH", "HTT", "HTH", "HHT", "HHH"]

for _ in range(T):
  s = input().strip()
  cnt = {p: 0 for p in patterns}
  
  for i in range(38):
    sub = s[i:i+3]
    cnt[sub] += 1
  
  print(*[cnt[p] for p in patterns])