from math import gcd

def solution(numer1, denom1, numer2, denom2):
    g = gcd(denom1, denom2)
    l = denom1 * denom2 // g
    
    top = numer1 * (l // denom1) + numer2 * (l // denom2)
    
    remove_mul = gcd(top, l)
    return [top // remove_mul, l // remove_mul]