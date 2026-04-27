def solution(numbers):
    s = set(numbers)
    not_found = set(range(10)) - s
    
    return sum(not_found)