def solution(n, m):
    def gcd(n, m):
        if n < m:
            n, m = m, n
        
        while m > 0:
            n, m = m, n % m
        
        return n
    
    g = gcd(n, m)
    l = n * m // g
    return [g, l]