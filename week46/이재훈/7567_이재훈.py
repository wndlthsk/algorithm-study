dish = input()

height = 10
prev = dish[0]
for ch in dish[1:]:
  if prev == ch:
    height += 5
  else:
    height += 10
    prev = ch
print(height)