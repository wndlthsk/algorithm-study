def solution(t, p):
    answer = 0
    size = len(p)

    for i in range(len(t) - size + 1):
        if int(t[i:i + size]) <= int(p):
            answer += 1

    return answer