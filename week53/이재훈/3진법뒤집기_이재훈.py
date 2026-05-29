def solution(n):
    nums = []

    while n > 0:
        nums.append(str(n % 3))
        n //= 3

    return int(''.join(nums), 3)