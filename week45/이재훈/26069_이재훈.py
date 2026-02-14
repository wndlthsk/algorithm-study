N = int(input())

danced = {"ChongChong"}

for _ in range(N):
  a, b = input().split()
  # 둘 중 하나라도 이미 춤을 추고 있었다면
  if a in danced or b in danced:
    danced.add(a)
    danced.add(b)
print(len(danced))