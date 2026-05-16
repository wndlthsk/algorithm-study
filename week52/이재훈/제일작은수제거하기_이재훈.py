def solution(arr):
    min_val = min(arr)
    arr.remove(min_val)
    
    if arr:
        return arr
     
    return [-1]