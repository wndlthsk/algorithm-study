n = int(input())
result = 0
power = 0
while n > 0:
    if n & 1:
        result += 3 ** power
    power += 1
    n >>= 1
print(result)

