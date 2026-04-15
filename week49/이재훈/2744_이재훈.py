s = input().strip()

result = ''
for ch in s:
  if ch.islower():
    result += ch.upper()
  else:
    result += ch.lower()

print(result)