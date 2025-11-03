seconds = [int(input()) for _ in range(4)]

total = sum(seconds)
x = total // 60
y = total % 60

print(x)
print(y)