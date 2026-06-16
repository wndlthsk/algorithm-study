import math

def solution(arr):
    nxt = arr[0]
    for x in arr[1:]:
        nxt = math.lcm(nxt, x)
    
    return nxt