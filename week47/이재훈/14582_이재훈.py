first = list(map(int, input().split()))
second = list(map(int, input().split()))

total_x, total_y = 0, 0
is_win = False

for i in range(9):
  # 1회 초
  total_x += first[i]
  if total_x > total_y:
    is_win = True

  # 1회 말
  total_y += second[i]
  if total_x > total_y:
    is_win = True

if is_win:
  print("Yes")
else:
  print("No")