from math import gcd

def solution(n, m):
    g = gcd(n, m)

    return [g, n * m // g]