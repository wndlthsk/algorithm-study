def solution(a, b):
    DAYS = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"]
    MONTHS = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    
    after_1_1 = sum(MONTHS[:a-1]) + b - 1
    
    index_offset_1_1 = 5
    idx = (index_offset_1_1 + after_1_1) % 7
    
    return DAYS[idx]