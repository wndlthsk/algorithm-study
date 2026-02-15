N = int(input())

danced = set(["ChongChong"])
for _ in range(N):
  A, B = input().split()
  if A in danced or B in danced:
    danced.add(A)
    danced.add(B)
print(len(danced))