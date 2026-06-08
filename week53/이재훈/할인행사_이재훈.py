def solution(want, number, discount):
    answer = 0

    for i in range(len(discount) - 9):
        items = discount[i:i + 10]

        ok = True
        for w, n in zip(want, number):
            if items.count(w) != n:
                ok = False
                break

        if ok:
            answer += 1

    return answer