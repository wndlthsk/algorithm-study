def solution(s):
    op = ''
    number = ''
    if not s[0].isdigit():
        op = s[0]
        number = int(s[1:])
    else:
        number = int(s)
    
    if op and op == '-':
        number = -1 * number
    
    return number