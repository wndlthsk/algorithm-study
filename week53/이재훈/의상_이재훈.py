def solution(clothes):
    d = {}

    for name, kind in clothes:
        d[kind] = d.get(kind, 0) + 1

    answer = 1

    for cnt in d.values():
        answer *= (cnt + 1)

    return answer - 1