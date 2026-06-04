from math import gcd

def solution(arr):
    lcm = arr[0]

    for num in arr[1:]:
        lcm = lcm * num // gcd(lcm, num)

    return lcm