L = int(input())
string = list(input())

MOD = 1234567891
R = 31

total = 0
for power, ch in enumerate(string):
  ai = ord(ch) - ord('a') + 1
  total += (ai * (R ** power)) % MOD
print(total % MOD)