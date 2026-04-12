P = int(input())
for _ in range(P):
  d = {
    "TTT": 0, "TTH": 0, "THT": 0, "THH": 0,
    "HTT": 0,"HTH": 0,"HHT": 0,"HHH": 0,
    }
  line = input()
  for idx in range(38):
    seq = line[idx : idx+3]
    d[seq] = d.get(seq, 0) + 1
  
  print(*d.values())