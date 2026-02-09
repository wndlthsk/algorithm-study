word = input()
i = 0
n = len(word)

while True:
  if i == n:
    print(1)
    break

  if word[i] != 'w':
    print(0)
    break

  cnt = 0
  while i < n and word[i] == 'w':
    cnt += 1
    i += 1

  for ch in ['o', 'l', 'f']:
    for _ in range(cnt):
      if i >= n or word[i] != ch:
        print(0)
        exit()
      i += 1
