T = int(input())
for _ in range(T):
  string = input()
  first, last = string[0], string[-1]
  print(first, last, sep="")