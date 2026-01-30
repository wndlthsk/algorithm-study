X = int(input())

cross_sum = 0
line = 0

while X > cross_sum:
  line += 1
  cross_sum += line

idx = cross_sum - X

if line % 2 == 0:
  top = line - idx
  bottom = 1 + idx
else:
  top = 1 + idx
  bottom = line - idx
print(f"{top}/{bottom}")