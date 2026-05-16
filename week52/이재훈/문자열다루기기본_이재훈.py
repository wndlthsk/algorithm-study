def solution(s):
    is_length_pass = False
    is_only_number = False
    
    if len(s) == 4 or len(s) == 6:
        is_length_pass = True
    if s.isdigit():
        is_only_number = True
    
    return is_length_pass and is_only_number