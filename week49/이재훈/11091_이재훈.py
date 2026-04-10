N = int(input())
for _ in range(N):
  line = input().lower()
  s = set(line)
  
  exist = [False] * 26
  cnt = 0
  for ch in s:
    if ch.isalpha():
      cnt += 1
      idx = ord(ch) - ord('a')
      exist[idx] = True
  
  miss = []
  for i, b in enumerate(exist):
    if not b:
      miss.append(chr(ord('a') + i))
  if cnt == 26:
    print("pangram")
  else:
    print(f"missing {''.join(miss)}")