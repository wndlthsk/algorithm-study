word = input()

d = {
  'ABC': 2,
  'DEF': 3,
  'GHI': 4,
  'JKL': 5,
  'MNO': 6,
  'PQRS': 7,
  'TUV': 8,
  'WXYZ': 9,
}

time = 0
for ch in word:
  for dial in d.keys():
    if ch in dial:
      time += d[dial] + 1
      break
print(time)