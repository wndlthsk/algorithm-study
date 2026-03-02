T = int(input())

A = 300
B = 60
C = 10

a = T // A
b = (T % A) // B
c = ((T % A) % B) // C

if ((T % A) % B) % C != 0:
  print(-1)
  exit(0)
else:
  print(a, b, c)