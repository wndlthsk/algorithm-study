matrix = [list(input().split()) for _ in range(9)]

biggest = float('-inf')
row, col = 0, 0
for i in range(9):
  for j in range(9):
    int_val = int(matrix[i][j])
    if int_val > biggest:
      biggest = int_val
      row, col = i, j
print(biggest)
print(row + 1, col + 1)