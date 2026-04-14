units = {
  'kg': ('lb', 2.2046),
  'lb': ('kg', 0.4536),
  'l': ('g', 0.2642),
  'g': ('l', 3.7854),
  }

T = int(input())
for _ in range(T):
  val, unit = input().split()
  val = float(val)
  
  u, v = units[unit]
  res = val * v
  print(f"{res:.4f} {u}")