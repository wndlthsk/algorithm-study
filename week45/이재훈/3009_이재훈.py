dots = [list(map(int, input().split())) for _ in range(3)]

ds_x = [dot[0] for dot in dots]
ds_y = [dot[1] for dot in dots]

x, y = 0, 0
for i in range(3):
  if ds_x.count(ds_x[i]) == 1:
    x = ds_x[i]
  if ds_y.count(ds_y[i]) == 1:
    y = ds_y[i]
print(x, y)