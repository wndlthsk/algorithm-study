from collections import Counter

def solution(participant, completion):
    counter = Counter(participant)
    counter.subtract(completion)

    for name, count in counter.items():
        if count > 0:
            return name