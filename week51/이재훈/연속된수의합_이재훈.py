def solution(num, total):
    start = (total - num*(num-1)//2) // num
    
    return list(range(start, start + num))