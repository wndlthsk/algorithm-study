import sys
import math

def sieve(n):
    is_prime = [True] * (n + 1)
    is_prime[0] = is_prime[1] = False
    for i in range(2, int(n**0.5) + 1):
        if is_prime[i]:
            for j in range(i*i, n+1, i):
                is_prime[j] = False
    return is_prime

def lcm(a, b):
    return a * b // math.gcd(a, b)


n = int(input())
arr = list(map(int, input().split(" ")))


is_prime = sieve(1000000)


primes = [x for x in arr if is_prime[x]]

if not primes:
    print(-1)
else:
    result = primes[0]
    for p in primes[1:]:
        result = lcm(result, p)
    print(result)
