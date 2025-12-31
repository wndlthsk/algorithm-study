S = input()

alphabet = [0] * 26
for ch in S:
  idx = ord(ch) - 97
  alphabet[idx] += 1
print(*alphabet)