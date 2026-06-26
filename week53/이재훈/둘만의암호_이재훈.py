def solution(s, skip, index):
    alphabet = [chr(i) for i in range(ord('a'), ord('z') + 1) if chr(i) not in skip]
    pos = {c: i for i, c in enumerate(alphabet)}
    n = len(alphabet)

    answer = []

    for ch in s:
        answer.append(alphabet[(pos[ch] + index) % n])

    return ''.join(answer)