def solution(s):
    line = list(map(int, s.split()))
    return f"{min(line)} {max(line)}"