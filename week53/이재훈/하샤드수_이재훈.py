def solution(x):
    total = sum(map(int, str(x)))
    return x % total == 0