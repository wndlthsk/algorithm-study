from itertools import combinations

def solution(nums):
    def is_prime(x):
        if x < 2:
            return False

        for i in range(2, int(x ** 0.5) + 1):
            if x % i == 0:
                return False

        return True

    count = 0

    for comb in combinations(nums, 3):
        if is_prime(sum(comb)):
            count += 1

    return count