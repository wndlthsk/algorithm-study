def solution(phone_number):
    ph = list(phone_number)
    n = len(ph)
    ph[:n-4] = list('*' * (n - 4))
    return ''.join(ph)