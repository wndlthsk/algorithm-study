X = int(input())

step = 1
while step * (step + 1) // 2 < X:
  step += 1

base_seq = (step - 1) * step // 2
offset = X - (base_seq + 1)

bottom, top = 0, 0
if step % 2 == 0:
  top = 1 + offset
  bottom = step - offset
else:
  top = step - offset
  bottom = 1 + offset
print(f"{top}/{bottom}")