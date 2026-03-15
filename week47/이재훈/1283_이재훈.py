N = int(input())

short_key = set()

for _ in range(N):
  line = input()
  arr = list(line)
  found = False

  # 1단계: 단어 첫 글자
  for i, ch in enumerate(arr):
    if (i == 0 or arr[i-1] == ' ') and ch.lower() not in short_key:
      short_key.add(ch.lower())
      arr[i] = "[" + ch + "]"
      found = True
      break

  # 2단계: 전체 문자
  if not found:
    for i, ch in enumerate(arr):
      if ch != ' ' and ch.lower() not in short_key:
        short_key.add(ch.lower())
        arr[i] = "[" + ch + "]"
        break

  print("".join(arr))