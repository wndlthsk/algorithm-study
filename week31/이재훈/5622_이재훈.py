string = input()

d = {
  2: 'ABC',
  3: 'DEF',
  4: 'GHI',
  5: 'JKL',
  6: 'MNO',
  7: 'PQRS',
  8: 'TUV',
  9: 'WXYZ',
}

res = 0
for x in string:
  for t, chars in d.items():
    if x in chars:
      res += t + 1
print(res)