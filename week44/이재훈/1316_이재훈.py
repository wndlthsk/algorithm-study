N = int(input())

def is_group_word(word):
  chunks = []
  for ch in word:
    if chunks:
      if chunks[-1] != ch and ch in chunks:
        return False
    chunks.append(ch)
  return True

cnt = 0
for _ in range(N):
  word = input()
  if is_group_word(word):
    cnt += 1
print(cnt)