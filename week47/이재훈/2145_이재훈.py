import sys
input = sys.stdin.readline

while True:
  number = input().strip()
  if number == '0':
    break

  while len(number) > 1:
    number = str(sum(map(int, number)))
  print(number)