d = {
  0: 'E',
  1: 'A',
  2: 'B',
  3: 'C',
  4: 'D',
}

for _ in range(3):
  play_res = list(map(int, input().split()))
  
  cnt_zero = play_res.count(0)
  print(d[cnt_zero])