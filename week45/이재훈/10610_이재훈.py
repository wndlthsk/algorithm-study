import sys
input = sys.stdin.readline

N = input().strip()
digits = list(N)

srt = sorted(digits, reverse=True)

total = sum(map(int, srt))

if '0' not in srt or total % 3 != 0:
  print(-1)
else:
  print(''.join(srt))