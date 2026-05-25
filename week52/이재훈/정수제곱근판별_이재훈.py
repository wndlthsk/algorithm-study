def solution(n):
    x = int(n ** 0.5)

    if x * x == n:
        return (x + 1) ** 2

    return -1