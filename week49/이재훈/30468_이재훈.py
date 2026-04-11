STR, DEX, INT, LUK, N = map(int, input().split())
st = [STR, DEX, INT, LUK]

total = sum(st)
need = N * 4

minimal = 0
if total < need:
  minimal = need - total
print(minimal)