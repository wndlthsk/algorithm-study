ROW_LEN = 5

words = [input() for _ in range(ROW_LEN)]

max_col_len = max(len(w) for w in words)

res = []
for col in range(max_col_len):
  for row in range(ROW_LEN):
    if col < len(words[row]):
      res.append(words[row][col])
print(''.join(res))