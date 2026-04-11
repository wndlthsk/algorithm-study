N = int(input())
for _ in range(N):
  line = input().lower()
  
  s = set()
  for ch in line:
    if 'a' <= ch <= 'z':
      s.add(ch)
  
  alphabet = set("abcdefghijklmnopqrstuvwxyz")
  miss = alphabet - s
  if len(s) == 26:
    print("pangram")
  else:
    print(f"missing {''.join(sorted(miss))}")