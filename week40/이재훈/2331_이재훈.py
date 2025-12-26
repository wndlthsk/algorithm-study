A, P = input().split()

number = list(map(int, A))
sq = int(P)

sequence = [int(A)]

while True:
  total = 0
  for n in number:
    total += n ** sq

  if total in sequence:
    print(sequence.index(total))
    break

  sequence.append(total)
  number = list(map(int, str(total)))
