word = input()

d = {}
for ch in word.upper():
  d[ch] = d.get(ch, 0) + 1

srt = sorted(d.items(), key=lambda x: -x[1])

if len(srt) > 1 and srt[0][1] == srt[1][1]:
  print('?')
else:
  print(srt[0][0])