import sys
input = sys.stdin.readline

s = input().strip()
n = int(input())
words = [input().strip() for _ in range(n)]

for shift in range(26):
  decoded = ''
  for c in s:
    decoded += chr((ord(c) - ord('a') + shift) % 26 + ord('a'))
  
  for w in words:
    if w in decoded:
      print(decoded)
      exit()