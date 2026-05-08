def solution(n, w, num):
    total_r = (n - 1) // w + 1
    total_c = w
    
    is_right = False
    num_r = (num - 1) // w
    if num_r % 2 == 0:
        is_right = True
    
    base = (num - 1) % w
    num_c = base if is_right else (w - 1) - base
    
    remain = n % w
    if remain == 0:
        return total_r - num_r
    
    last_row = (n - 1) // w
    
    is_exist = False
    if last_row % 2 == 0:
        if 0 <= num_c < remain:
            is_exist = True
    else:
        if w - remain <= num_c < w:
            is_exist = True
    
    return total_r - num_r if is_exist else total_r - num_r - 1