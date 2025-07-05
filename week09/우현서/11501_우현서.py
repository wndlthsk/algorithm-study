import sys

t = int(sys.stdin.readline())
for _ in range(t):
    n = int(sys.stdin.readline())
    numbers = list(map(int, sys.stdin.readline().split()))
    # print(n, numbers)

    result = 0
    max_price = 0
    for i in range(n-1, -1, -1):
        if numbers[i] > max_price:
            max_price = numbers[i]
        else:
            result += max_price - numbers[i]

    print(result)