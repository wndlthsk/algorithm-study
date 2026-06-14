from collections import Counter

def solution(topping):
    counter = Counter(topping)
    left = set()

    answer = 0

    for t in topping:
        left.add(t)

        counter[t] -= 1
        if counter[t] == 0:
            del counter[t]

        if len(left) == len(counter):
            answer += 1

    return answer