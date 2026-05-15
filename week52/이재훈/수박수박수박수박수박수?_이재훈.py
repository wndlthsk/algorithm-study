def solution(n):
    word = ['수', '박'] * (n // 2)
    
    if n % 2 == 0:
        return ''.join(word)
    else:
        return ''.join(word) + '수'
    